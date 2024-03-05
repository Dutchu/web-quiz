package edu.dutchu.webquiz.repositories;


import edu.dutchu.webquiz.domain.Quiz;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class QuizRepository {
    private final ConcurrentHashMap<Long, Quiz> quizzes = new ConcurrentHashMap<>();
    public Quiz save(Quiz quiz) {
        int size = quizzes.size();
        Long quizId = (long) (size + 1);
        return quizzes.put(quizId, quiz);
    }
    public Quiz get() {
        return quizzes.get(1L);
    }
}
