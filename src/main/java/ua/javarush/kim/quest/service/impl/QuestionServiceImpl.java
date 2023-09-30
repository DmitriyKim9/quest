package ua.javarush.kim.quest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.kim.quest.entity.Question;
import ua.javarush.kim.quest.repository.QuestionRepo;
import ua.javarush.kim.quest.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);
    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question getQuestionWithAnswersbyId(Long questionId) {
        return questionRepo.getQuestionWithAnswersbyId(questionId);
    }
}
