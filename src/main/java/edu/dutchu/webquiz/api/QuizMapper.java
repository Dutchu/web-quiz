package edu.dutchu.webquiz.api;


import edu.dutchu.webquiz.api.model.CreateQuizDTO;
import edu.dutchu.webquiz.api.model.CreateQuizResponseDTO;
import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.domain.Quiz;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    public GetQuizDTO toQuizDTO(Quiz quiz) {
        return new GetQuizDTO(quiz.getTitle(), quiz.getText(), quiz.getOptions(), quiz.getId());
    }

    public Quiz toQuiz(CreateQuizDTO createQuizDTO) {
        return new Quiz(createQuizDTO.title(), createQuizDTO.text(), createQuizDTO.options(), createQuizDTO.answer());
    }

    public CreateQuizResponseDTO toCreateQuizResponseDTO(Quiz quiz) {
        return new CreateQuizResponseDTO(quiz.getTitle(), quiz.getText(), quiz.getOptions(), quiz.getId());
    }}
