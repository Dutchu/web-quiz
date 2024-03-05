package edu.dutchu.webquiz.services;


import edu.dutchu.webquiz.api.QuizMapper;
import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.api.model.QuizResultDTO;
import edu.dutchu.webquiz.repositories.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public GetQuizDTO getQuiz() {
        return quizMapper.toQuizDTO(quizRepository.get());
    }

    public QuizResultDTO solveQuiz(Long anwser) {
        QuizResultDTO result;
        if (anwser == 2) {
             result = new QuizResultDTO(true, "Good Job!");
        } else {
            result = new QuizResultDTO(false, "Try again!");
        }
        return result;
    }
}
