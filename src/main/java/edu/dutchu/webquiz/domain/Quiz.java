package edu.dutchu.webquiz.domain;

import java.util.Arrays;
import java.util.Objects;

public class Quiz {
    private Long id;
    private String title;
    private String text;
    private String[] options;
    private int answer;

    public Quiz(String title, String text, String[] options, int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return answer == quiz.answer && Objects.equals(id, quiz.id) && Objects.equals(title, quiz.title) && Objects.equals(text, quiz.text) && Arrays.equals(options, quiz.options);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, text, answer);
        result = 31 * result + Arrays.hashCode(options);
        return result;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer=" + answer +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getAnswer() {
        return this.answer;
    }
}
