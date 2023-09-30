package ua.javarush.kim.quest.service;

import ua.javarush.kim.quest.entity.Question;

public interface QuestionService {
    Question getQuestionWithAnswersbyId(Long questionId);
}
