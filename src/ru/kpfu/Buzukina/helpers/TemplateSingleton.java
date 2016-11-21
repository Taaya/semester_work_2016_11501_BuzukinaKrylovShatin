package ru.kpfu.Buzukina.helpers;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by taa on 02.11.16.
 */
public class TemplateSingleton {
    String ftl;
    HttpServletRequest request;
    HttpServletResponse response;

    private static TemplateSingleton ourInstance = new TemplateSingleton();

    public static TemplateSingleton getInstance() {
        return ourInstance;
    }

    private TemplateSingleton() {
    }
    public TemplateSingleton(String ftl){
        this.ftl = ftl;
    }

    public void render(HttpServletRequest request, HttpServletResponse response, Map root) throws IOException {

        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate(ftl);
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}
