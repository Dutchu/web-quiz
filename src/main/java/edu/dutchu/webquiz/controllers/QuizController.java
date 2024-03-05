package edu.dutchu.webquiz.controllers;


import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.api.model.QuizResultDTO;
import edu.dutchu.webquiz.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<GetQuizDTO> getQuiz() {
        GetQuizDTO quiz = quizService.getQuiz();
        System.out.println(quiz);
        return ResponseEntity.ok(quiz);
    }

    @PostMapping
    public ResponseEntity<QuizResultDTO> solveQuiz(@RequestParam("answer") Long anwser) {
        QuizResultDTO result = quizService.solveQuiz(anwser);
        return ResponseEntity.ok(result);
    }

}
