package ua.javarush.kim.quest.entity;

import java.util.List;

public class Question {
    private Long id;
    private Long gameId;
    private String title;
    private String question;
    private boolean isEnd;
    private List<Answer> answers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", isEnd=" + isEnd +
                ", answers=" + answers +
                '}';
    }
}
