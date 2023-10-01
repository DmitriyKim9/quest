package ua.javarush.kim.quest.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndexCommand extends Command {

	private static final Logger LOG = LoggerFactory.getLogger(IndexCommand.class);

    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("qtyLose");
        LOG.debug("Remove attribute 'qtyLose'");
        session.removeAttribute("qtyWin");
        LOG.debug("Remove attribute 'qtyWin'");
        return "index.jsp";
    }

}
