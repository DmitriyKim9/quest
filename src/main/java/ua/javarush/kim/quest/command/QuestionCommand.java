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

        session.setAttribute("question", question);
        LOG.debug("Put into session attribute 'question' = {}", question);
        session.setAttribute("answers", answers);
        LOG.debug("Put into session attribute 'answers' = {}", answers);

        return "quest?cmd=showQuestion";
    }
}
