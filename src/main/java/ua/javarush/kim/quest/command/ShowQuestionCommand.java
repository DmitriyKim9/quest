package ua.javarush.kim.quest.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowQuestionCommand extends Command{

    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        return "/WEB-INF/quest.jsp";
    }
}
