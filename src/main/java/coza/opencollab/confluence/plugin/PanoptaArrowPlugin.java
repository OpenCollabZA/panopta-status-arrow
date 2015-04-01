package coza.opencollab.confluence.plugin;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;

import java.util.Map;

/**
 * Renders the Panopta up or down arrow to indicate the status of a specific 
 * configured server. The plugin takes the developer API key and the server name 
 * as parameters. A limitation is that only one macro instance can be used per 
 * server name on a page.
 * 
 * @author Samuel Holtzkampf
 */
public class PanoptaArrowPlugin implements Macro {

    @Override
    public String execute(Map<String, String> parameters, String bodyContent, ConversionContext conversionContext) throws MacroExecutionException {
        Map context = MacroUtils.defaultVelocityContext();
        context.put("devAPIKey", parameters.get("devAPIKey"));
        context.put("serverName", parameters.get("serverName"));
        return VelocityUtils.getRenderedTemplate("/coza/confluence/plugin/templates/macro.vm", context);
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }
}