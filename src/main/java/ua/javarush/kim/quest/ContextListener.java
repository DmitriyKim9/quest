package ua.javarush.kim.quest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.command.*;
import ua.javarush.kim.quest.repository.QuestionRepo;
import ua.javarush.kim.quest.repository.json.QuestionRepoImpl;
import ua.javarush.kim.quest.service.QuestionService;
import ua.javarush.kim.quest.service.impl.QuestionServiceImpl;

import java.io.InputStream;


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
        initDatasource(context);
        LOG.debug("jsonFileInputStream initialized");
        initServices(context);
        LOG.debug("Services initialized");
    }

    private void initDatasource(ServletContext context) throws IllegalStateException {
        // Получение значение параметра jsonFilePath из web.xml
        String jsonFilePath = context.getInitParameter("jsonFilePath");
        // Получите InputStream к файлу JSON из папки resources
        InputStream inputStream = context.getResourceAsStream(jsonFilePath);

        if (inputStream == null) {
            LOG.debug("Path or File not found: {}", jsonFilePath);
            throw new IllegalStateException("Cannot initialize jsonFilePath: JSOM file is not exist");
        } else {
            context.setAttribute("jsonFileInputStream", inputStream);
            LOG.trace("context.setAttribute 'jsonFileInputStream'");
        }
    }

    private void initServices(ServletContext context) {
        // create repository
        QuestionRepo questionRepo = new QuestionRepoImpl((InputStream) context.getAttribute("jsonFileInputStream"));
        LOG.trace("created 'QuestionRepo': {}", questionRepo);

        // create services
        QuestionService questionService = new QuestionServiceImpl(questionRepo);
        context.setAttribute("questionService",questionService);
        LOG.trace("context.setAttribute 'questionService': {}", questionService);

        // create commands
        //index
        CommandContainer commands = new CommandContainer();
        Command command = new IndexCommand();
        commands.addCommand(null, command);
        commands.addCommand("", command);

        //question
        command = new QuestionCommand(questionService);
        commands.addCommand("question", command);
        command = new ShowQuestionCommand();
        commands.addCommand("showQuestion", command);

        context.setAttribute("commandContainer", commands);
        LOG.trace("context.setAttribute 'commandContainer': {}", commands);
    }
}
