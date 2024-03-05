package edu.dutchu.webquiz.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Arrays;
import java.util.Objects;

public class Quiz {

    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Text is mandatory")
    private String text;
    @Size(min = 2)
    @Pattern(regexp = "^[\\w\\s]*$", message = "Options must be words")
    private String[] options;
    @Pattern(regexp = "^[0-9]*$", message = "Answer must be a number")
    private int[] answers;

    public Quiz(String title, String text, String[] options, int[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answers = answer;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public int[] getAnswers() {
        return this.answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return answers == quiz.answers && Objects.equals(id, quiz.id) && Objects.equals(title, quiz.title) && Objects.equals(text, quiz.text) && Arrays.equals(options, quiz.options);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, text, Arrays.hashCode(answers));
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
                ", answer=" + Arrays.toString(answers) +
                '}';
    }
}
