/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

/**
 *
 * @author Luu Cao Hoang
 */
public class DBConnect {
    protected Connection connection;
    
    public DBConnect(){
        try{
            String user = "sa";
            String password ="132316";
            String url = "jdbc:sqlserver://DESKTOP-P3UQBH9\\PIEDTEAM:1433;databaseName=DBK18C1_studentManagement";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
               Logger.getLogger(DBConnect.class.getName()).Logger.getLogger(DBConnect.class.getName()).log(Level.INFO, "message");
        }
    }
    
}
