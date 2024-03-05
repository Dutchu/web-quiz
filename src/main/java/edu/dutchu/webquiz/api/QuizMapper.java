package edu.dutchu.webquiz.api;


import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.domain.Quiz;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    public GetQuizDTO toQuizDTO(Quiz quiz) {
        return new GetQuizDTO(quiz.getTitle(), quiz.getText(), quiz.getOptions());
    }

    public Quiz toQuiz(GetQuizDTO quizDTO) {
        return new Quiz(quizDTO.title(), quizDTO.text(), quizDTO.options());
    }
}
