package edu.dutchu.webquiz.services;


import edu.dutchu.webquiz.api.QuizMapper;
import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.api.model.CreateQuizDTO;
import edu.dutchu.webquiz.api.model.CreateQuizResponseDTO;
import edu.dutchu.webquiz.api.model.QuizSolveResponseDTO;
import edu.dutchu.webquiz.domain.Quiz;
import edu.dutchu.webquiz.exceptions.QuizNotFoundException;
import edu.dutchu.webquiz.exceptions.WrongAnswerFormatException;
import edu.dutchu.webquiz.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public QuizSolveResponseDTO solveQuiz(Long quizId, Integer answer) {

        QuizSolveResponseDTO result;
        Optional<Quiz> quiz = Optional.ofNullable(quizRepository.getById(quizId));

        if (answer == null) {
            throw new WrongAnswerFormatException("Answer cannot be null");
        }

        if (quiz.isEmpty()) {
            throw new QuizNotFoundException("Quiz not found");
        }

        if (quiz.get().getAnswer().equals(answer)) {
            result = new QuizSolveResponseDTO(true, "Good Job!");
        } else {
            result = new QuizSolveResponseDTO(false, "Try again!");
        }
        return result;

    }

    public GetQuizDTO getQuizById(Long id) {
        Optional<Quiz> quiz = Optional.ofNullable(quizRepository.getById(id));

        if (quiz.isPresent()) {
            return quizMapper.toQuizDTO(quiz.get());
        } else {
            throw new QuizNotFoundException("Quiz not found");
        }

    }

    public List<GetQuizDTO> getQuizzes() {
        List<Quiz> quizzes = quizRepository.getAll();
        List<GetQuizDTO> quizDtos = new ArrayList<>();

        quizzes.forEach(quiz -> {
            quizDtos.add(quizMapper.toQuizDTO(quiz));
        });

        return quizDtos;
    }

    public CreateQuizResponseDTO createQuiz(CreateQuizDTO quiz) {
        Quiz newQuiz = quizMapper.toQuiz(quiz);
        Quiz savedQuiz = quizRepository.save(newQuiz);
        return quizMapper.toCreateQuizResponseDTO(savedQuiz);
    }
}
