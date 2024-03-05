package edu.dutchu.webquiz.api.model;

public record CreateQuizDTO(String title, String text, String[] options, int answer) {
}
