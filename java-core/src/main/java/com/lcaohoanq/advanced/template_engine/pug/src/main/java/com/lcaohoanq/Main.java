package com.lcaohoanq.advanced.template_engine.pug.src.main.java.com.lcaohoanq;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        renderIndex("index.jade");
        renderVar("variable.jade");

        Map<String, Object> model = new HashMap<>();
        model.put("title", "My Page Title");
        model.put("heading", "Welcome to My Page");
        model.put("message", "This is a message rendered from a Jade template.");

        String data = jadeConfiguration("src/main/resources/templates/", "variable.jade", model);
        System.out.println(data);
    }

    private static String jadeConfiguration(String templatePath, String fileName, Map<String, Object> model) {
        try{
            JadeConfiguration loader = new JadeConfiguration();
            loader.setTemplateLoader(new FileTemplateLoader(templatePath, "UTF-8"));
            JadeTemplate template = loader.getTemplate(fileName);
            return Jade4J.render(template, model);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void renderIndex(String name) {
        try {
            // Specify the path to the directory containing the Jade templates
            String templatesPath = "src/main/resources/templates/";

            // Load the Jade template
            JadeConfiguration loader = new JadeConfiguration();
            loader.setTemplateLoader(new FileTemplateLoader(templatesPath, "UTF-8"));
            JadeTemplate template = loader.getTemplate(name);

            // Data to be passed to the template
            Map<String, Object> model = new HashMap<>();

            // Render the template with the provided data
            String htmlOutput = Jade4J.render(template, model);

            // Output the rendered HTML
            System.out.println(htmlOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renderVar(String name) {
        try {
            // Specify the path to the directory containing the Jade templates
            String templatesPath = "src/main/resources/templates/";

            // Load the Jade template
            JadeConfiguration loader = new JadeConfiguration();
            loader.setTemplateLoader(new FileTemplateLoader(templatesPath, "UTF-8"));
            JadeTemplate template = loader.getTemplate(name);

            // Data to be passed to the template
            Map<String, Object> model = new HashMap<>();
            model.put("title", "My Page Title");
            model.put("heading", "Welcome to My Page");
            model.put("message", "This is a message rendered from a Jade template.");

            // Render the template with the provided data
            String htmlOutput = Jade4J.render(template, model);

            // Output the rendered HTML
            System.out.println(htmlOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
