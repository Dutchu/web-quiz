package edu.dutchu.webquiz.controllers;


import edu.dutchu.webquiz.api.model.*;
import edu.dutchu.webquiz.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<GetQuizDTO>> getQuizzes() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetQuizDTO> getQuizById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<QuizSolveResponseDTO> solveQuiz(@PathVariable("id") Long quizId, @RequestBody @Valid SolveQuizDTO answer) {
        return ResponseEntity.ok(quizService.solveQuiz(quizId, answer));
    }

    @PostMapping()
    public ResponseEntity<CreateQuizResponseDTO> createQuiz(@RequestBody @Valid CreateQuizDTO quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }


}
