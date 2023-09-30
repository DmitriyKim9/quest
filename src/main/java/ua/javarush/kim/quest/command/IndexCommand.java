package ua.javarush.kim.quest.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexCommand extends Command {

//	private static final Logger LOG = LoggerFactory.getLogger(IndexCommand.class);

    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) {
        return "index.jsp";
    }

}
