package ua.javarush.kim.quest.quest.repository;

import ua.javarush.kim.quest.quest.entity.Question;

import java.util.Optional;

public interface QuestionRepo {
    Optional<Question> getQuestionById(String login) throws SourceException;
}
