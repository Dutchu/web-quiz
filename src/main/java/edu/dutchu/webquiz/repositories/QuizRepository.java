package edu.dutchu.webquiz.repositories;


import edu.dutchu.webquiz.domain.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class QuizRepository {
    private final ConcurrentHashMap<Long, Quiz> quizzes = new ConcurrentHashMap<>();
    public Quiz save(Quiz quiz) {
        int size = quizzes.size();
        Long quizId = (long) (size + 1);
        quiz.setId(quizId);
        quizzes.put(quizId, quiz);
        return quiz;
    }

    public Quiz getById(Long id) {
        return quizzes.get(id);
    }

    public List<Quiz> getAll() {
        return List.copyOf(quizzes.values());
    }
}
