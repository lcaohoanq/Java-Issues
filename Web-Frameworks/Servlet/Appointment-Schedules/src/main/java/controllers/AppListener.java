package controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import utils.LogsUtils;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // This method is called when the application is starting up
        LogsUtils.ensureLogsFolderExists();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // This method is called when the application is shutting down
    }
}
