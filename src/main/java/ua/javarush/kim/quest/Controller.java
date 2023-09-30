package ua.javarush.kim.quest;

import java.io.*;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.command.Command;
import ua.javarush.kim.quest.command.CommandContainer;
import ua.javarush.kim.quest.command.CommandException;

@WebServlet( "/quest")
public class Controller extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);
    private CommandContainer commands;

    @Override
    public void init(ServletConfig config) {
        commands = (CommandContainer) config.getServletContext().getAttribute("commandContainer");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String url = getParam(req, resp);
            LOG.debug("url: {}", url);
            req.getRequestDispatcher(url).forward(req, resp);
            LOG.debug("forward: {}", url);
        } catch (CommandException e) {
            LOG.debug("Error: {}", e.getMessage());
            resp.sendError(500, e.getMessage());
//			throw new ServletException("Cannot process the command", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            String url = getParam(req, resp);
            resp.sendRedirect(url);
            LOG.debug("redirected: {}", url);

        } catch (CommandException e) {
            LOG.debug("Error: {}", e.getMessage());
            resp.sendError(500, e.getMessage());

//			throw new ServletException("Cannot process the command", e);
        }

    }

    private String getParam(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = req.getSession();
        Map<String, String[]> parameters = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            session.setAttribute(key, value);
            LOG.debug("Put into session attribute: {} = {}", key, value);
        }

        String[] cmdName = parameters.get("cmd");
        LOG.debug("cmdName: {}", cmdName[0]);
        Command command = commands.getCommand(cmdName[0]);
        LOG.debug("command: {}", command);
        String url = "";
        url = command.doCommand(req, resp);

        return url;
    }
}