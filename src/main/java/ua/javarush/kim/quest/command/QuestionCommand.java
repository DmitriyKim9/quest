package ua.javarush.kim.quest.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.entity.Answer;
import ua.javarush.kim.quest.entity.Question;
import ua.javarush.kim.quest.service.QuestionService;

import java.util.List;

public class QuestionCommand extends Command {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionCommand.class);
    private final QuestionService questionService;

    public QuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        String nextQuestionId = req.getParameter("nextQuestionId");
        LOG.debug("Get parameter 'nextQuestionId' = {}", nextQuestionId);
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        LOG.debug("Get attribute 'name' = {}", name);
        if (name == null) {
            name = req.getParameter("name");
            LOG.debug("Get parameter 'name' = {}", name);
        }

        Integer qtyLose = (Integer) session.getAttribute("qtyLose");
        LOG.debug("Get attribute 'qtyLose' = {}", qtyLose);
        if (qtyLose == null) qtyLose = 0;

        Integer qtyWin = (Integer) session.getAttribute("qtyWin");
        LOG.debug("Get attribute 'qtyWin' = {}", qtyWin);
        if (qtyWin == null) qtyWin = 0;


        long id;
        if (nextQuestionId == null) {
            id = 0L;
        } else {
            try {
                id = Long.parseLong(nextQuestionId);
            } catch (NumberFormatException e) {
                LOG.debug("Wrong parameter questionId", e);
                throw new CommandException(e);
            }
        }

        Question question = questionService.getQuestionWithAnswersbyId(id);
        List<Answer> answers = question.getAnswers();

        if (question.getIsEnd()) {
            if (question.getIsWin()) {
                qtyWin++;
            } else {
                qtyLose++;
            }
        }

        session.setAttribute("question", question);
        LOG.debug("Put into session attribute 'question' = {}", question);
        session.setAttribute("answers", answers);
        LOG.debug("Put into session attribute 'answers' = {}", answers);
        session.setAttribute("name", name);
        LOG.debug("Put into session attribute 'name' = {}", name);
        session.setAttribute("qtyLose", qtyLose);
        LOG.debug("Put into session attribute 'qtyLose' = {}", qtyLose);
        session.setAttribute("qtyWin", qtyWin);
        LOG.debug("Put into session attribute 'qtyWin' = {}", qtyWin);

        return "quest?cmd=showQuestion";
    }
}
