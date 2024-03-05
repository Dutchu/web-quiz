package edu.dutchu.webquiz.api.model;

public record CreateQuizResponseDTO(String title, String text, String[] options, Long id) {
}
