package com.lcaohoanq.advanced.orm.app.src.main.java.com.lcaohoanq;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtils {
    private static Dotenv dotenv;

    static {
        try {
            dotenv = Dotenv.configure().load();
        } catch (Exception e) {
            throw new Error("Error initializing com.lcaohoanq.jdbc.maven.mysql.EnvUtils: " + e.getMessage());
        }
    }

    public static String get(String key) {
        try {
            return dotenv.get(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

