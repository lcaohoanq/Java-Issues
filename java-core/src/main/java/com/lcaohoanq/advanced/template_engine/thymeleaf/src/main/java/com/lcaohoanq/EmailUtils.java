package com.lcaohoanq.advanced.template_engine.thymeleaf.src.main.java.com.lcaohoanq;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class EmailUtils {

    private final TemplateEngine templateEngine;

    public EmailUtils() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public String emailSendOtp(String name, String otp) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("otp", otp);
        return templateEngine.process("sendOtp", context);
    }

    public static void main(String[] args) {
        EmailUtils emailUtils = new EmailUtils();
        System.out.println(emailUtils.emailSendOtp("hoang", "999999"));
    }

}