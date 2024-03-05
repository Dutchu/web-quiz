package edu.dutchu.webquiz;


import edu.dutchu.webquiz.domain.Quiz;
import edu.dutchu.webquiz.repositories.QuizRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class QuizBootstrap implements CommandLineRunner {

    QuizRepository quizRepository;

    public QuizBootstrap(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Quiz savedQuiz = quizRepository.save(
                new Quiz("The Java Logo"
                        , "What is depicted on the Java logo?"
                        , new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"}));
        System.out.println(savedQuiz);
    }
}
