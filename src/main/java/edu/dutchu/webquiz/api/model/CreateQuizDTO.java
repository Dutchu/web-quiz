package edu.dutchu.webquiz.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateQuizDTO(
        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotBlank(message = "Text cannot be blank")
        String text,

        @NotNull
        @Size(min = 2, message = "Options must contain at least 2 elements")
        String[] options,

        int[] answers) {
}
