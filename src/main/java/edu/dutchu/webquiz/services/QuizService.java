package edu.dutchu.webquiz.services;


import edu.dutchu.webquiz.api.QuizMapper;
import edu.dutchu.webquiz.api.model.*;
import edu.dutchu.webquiz.domain.AppUser;
import edu.dutchu.webquiz.domain.Quiz;
import edu.dutchu.webquiz.exceptions.QuizNotFoundException;
import edu.dutchu.webquiz.exceptions.UnauthorizedException;
import edu.dutchu.webquiz.exceptions.WrongAnswerFormatException;
import edu.dutchu.webquiz.repositories.QuizRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final AppUserService appUserService;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper, AppUserService appUserService) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
        this.appUserService = appUserService;
    }

    public QuizSolveResponseDTO solveQuiz(Long quizId, SolveQuizDTO answer) {
        QuizSolveResponseDTO result;
        IntStream answers;
        IntStream userAnswers;
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found"));

        if (answer == null) {
            throw new WrongAnswerFormatException("Answer cannot be null");
        }

        if (quiz.getAnswers() == null) {
            answers = IntStream.empty();
        } else {
            answers = quiz.getAnswers().stream().mapToInt(Integer::intValue);
        }

        userAnswers = Arrays.stream(answer.answer());

        if (assertIntStreamContains(answers, userAnswers)) {
            result = new QuizSolveResponseDTO(true, "Good Job!");
        } else {
            result = new QuizSolveResponseDTO(false, "Try again!");
        }
        return result;
    }

    private boolean assertIntStreamContains(IntStream answers, IntStream userAnswers) {
        Set<Integer> answerSet = answers.boxed().collect(Collectors.toSet());
        Set<Integer> userAnswerSet = userAnswers.boxed().collect(Collectors.toSet());
        //check if all user answers are EXACTLY the same as the answer set (no more, no less)
        return userAnswerSet.equals(answerSet);
    }

    public GetQuizDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found"));

        return quizMapper.toQuizDTO(quiz);
    }

    public List<GetQuizDTO> getQuizzes() {
        //TODO: Implement pagination
        List<Quiz> quizzes = quizRepository.findAll();

        return quizzes.stream()
                .map(quizMapper::toQuizDTO)
                .toList();
    }

    public CreateQuizResponseDTO createQuiz(CreateQuizDTO quiz, String username) {
        Quiz newQuiz = quizMapper.toQuiz(quiz);
        AppUser foundUser = appUserService.findUserByEmail(username);
        newQuiz.setCreatedBy(foundUser);
        Quiz savedQuiz = quizRepository.save(newQuiz);
        return quizMapper.toCreateQuizResponseDTO(savedQuiz);
    }

    public void deleteQuizById(Long id, String username) {
        AppUser foundUser = appUserService.findUserByEmail(username);
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found"));

        if (null == quiz.getCreatedBy()) {
            throw new UnauthorizedException("Quiz is missing createdBy user id!");
        }

        if (!quiz.getCreatedBy().equals(foundUser)) {
            throw new UnauthorizedException("User is not authorized to delete this quiz");
        }

        try {
            quizRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new QuizNotFoundException(e.getMessage() + " Quiz not found");
        }
    }
}
