package ua.javarush.kim.quest.quest.entity;

import java.util.List;

public class Question {
    private Long id;
    private Long gameId;
    private String text;
    private List<Answer> answers;
    private boolean isEnd;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                ", isEnd=" + isEnd +
                '}';
    }
}
