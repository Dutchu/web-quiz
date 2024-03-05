package edu.dutchu.webquiz.api;


import edu.dutchu.webquiz.api.model.CreateQuizDTO;
import edu.dutchu.webquiz.api.model.CreateQuizResponseDTO;
import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.domain.Quiz;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class QuizMapper {
    public GetQuizDTO toQuizDTO(Quiz quiz) {
        return new GetQuizDTO(
                quiz.getTitle(),
                quiz.getText(),
                quiz.getOptions(),
                quiz.getId());
    }

    public Quiz toQuiz(CreateQuizDTO createQuizDTO) {
        int[] answer = createQuizDTO.answer();
        List<Integer> answerList = (answer != null)
                ? Arrays.stream(answer).boxed().toList()
                : Collections.emptyList();

        return new Quiz(
                createQuizDTO.title(),
                createQuizDTO.text(),
                Arrays.asList(createQuizDTO.options()),
                answerList);
    }

    public CreateQuizResponseDTO toCreateQuizResponseDTO(Quiz quiz) {
        return new CreateQuizResponseDTO(
                quiz.getTitle(), quiz.getText(),
                quiz.getOptions().stream()
                        .sorted(Comparator.reverseOrder())
                        .toList(),
                quiz.getId());
    }
}
