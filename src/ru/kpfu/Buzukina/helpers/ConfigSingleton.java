package ru.kpfu.Buzukina.helpers;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

/**
 * Created by taa on 23.10.16.
 */
public class ConfigSingleton {
    private static Configuration cfg = null;
    public static Configuration getConfig(ServletContext sc) {
        if (cfg == null){
            cfg = new Configuration();
            cfg.setServletContextForTemplateLoading(
                    sc,
                    "/WEB-INF/templates"
            );
            cfg.setTemplateExceptionHandler(
                    TemplateExceptionHandler.HTML_DEBUG_HANDLER
            );
        }
        return cfg;
    }
}
