package ua.javarush.kim.quest.quest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.quest.command.Command;
import ua.javarush.kim.quest.quest.command.CommandContainer;
import ua.javarush.kim.quest.quest.command.IndexCommand;


@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener {
    private static final Logger LOG = LoggerFactory.getLogger(ContextListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        LOG.trace("Servlet context destruction starts");
        // do nothing
        LOG.trace("Servlet context destruction finished");
    }

    // bootstrap of the application
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.debug("Start context initialization");
        ServletContext context = sce.getServletContext();
        initServices(context);
        LOG.debug("Services initialized");
    }


    private void initServices(ServletContext context) {
        // create repository

        // create services

        // create commands
        CommandContainer commands = new CommandContainer();
        Command command = new IndexCommand();
        commands.addCommand(null, command);
        commands.addCommand("", command);


        context.setAttribute("commandContainer", commands);
        LOG.trace("context.setAttribute 'commandContainer': {}", commands);

    }

}
