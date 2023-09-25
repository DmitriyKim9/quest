package ua.javarush.kim.quest.quest.repository;

import ua.javarush.kim.quest.quest.entity.Answer;

import java.util.Optional;

public interface AnswerRepo {
    Optional<Answer> getAnswerById(String login) throws SourceException;
}
