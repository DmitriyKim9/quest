package ua.javarush.kim.quest.quest.entity;

import java.util.List;

public class Game {
    private Long id;
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", questions=" + questions +
                '}';
    }
}
