package edu.dutchu.webquiz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Text is mandatory")
    private String text;
    @Size(min = 2)
    @ElementCollection(fetch = FetchType.EAGER)
    private final List<String> options = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private final List<Integer> answers = new ArrayList<>();

    public Quiz() {
    }
    public Quiz(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Quiz(String title, String text, List<String> options, List<Integer> answers) {
        this.title = title;
        this.text = text;
        this.options.addAll(options);
        this.answers.addAll(answers);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }
    public void setOptions(String[] options) {
        this.options.addAll(Arrays.asList(options));
    }
    public List<Integer> getAnswers() {
        return answers;
    }
    public void setAnswers(int[] answers) {
        this.answers.addAll(Arrays.stream(answers).boxed().toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(title, quiz.title) && Objects.equals(text, quiz.text) && Objects.equals(options, quiz.options) && Objects.equals(answers, quiz.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, options, answers);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answers=" + answers +
                '}';
    }
}
