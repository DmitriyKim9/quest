package ua.javarush.kim.quest.repository;

import ua.javarush.kim.quest.entity.Question;

public interface QuestionRepo {
    Question getQuestionWithAnswersbyId(Long questionId);
}
