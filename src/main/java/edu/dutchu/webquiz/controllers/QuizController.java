package edu.dutchu.webquiz.controllers;


import edu.dutchu.webquiz.api.model.CreateQuizDTO;
import edu.dutchu.webquiz.api.model.CreateQuizResponseDTO;
import edu.dutchu.webquiz.api.model.GetQuizDTO;
import edu.dutchu.webquiz.api.model.QuizSolveResponseDTO;
import edu.dutchu.webquiz.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/quizzes/", "/api/quizzes"})
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
    public ResponseEntity<QuizSolveResponseDTO> solveQuiz(@PathVariable("id") Long quizId, @RequestParam("answer") Integer answer) {
        return ResponseEntity.ok(quizService.solveQuiz(quizId, answer));
    }

    @PostMapping()
    public ResponseEntity<CreateQuizResponseDTO> createQuiz(@RequestBody CreateQuizDTO quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }

}
