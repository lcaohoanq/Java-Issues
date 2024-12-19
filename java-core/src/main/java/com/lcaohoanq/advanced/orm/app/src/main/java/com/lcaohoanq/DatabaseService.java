package com.lcaohoanq.advanced.orm.app.src.main.java.com.lcaohoanq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public static Connection getConnection() throws SQLException {
        try {
            String dbUrl = EnvUtils.get("DB_URL_DOCKER");
            String dbUsername = EnvUtils.get("MYSQL_USER");
            String dbPassword = EnvUtils.get("MYSQL_PASSWORD");
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try(Connection ignored = DatabaseService.getConnection()){
            System.out.println("Database connection established");
        }catch (Exception e){
            System.out.println(e.getMessage()) ;
        }
    }

}

