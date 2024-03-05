package edu.dutchu.webquiz.exceptions;


public class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(String message) {
        super(message);
    }
}
