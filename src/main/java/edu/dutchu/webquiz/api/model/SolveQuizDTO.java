package edu.dutchu.webquiz.api.model;

import jakarta.annotation.Nonnull;

public record SolveQuizDTO(
        @Nonnull
        int[] answer
) {
}
