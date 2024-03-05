package edu.dutchu.webquiz.exceptions;

public class WrongAnswerFormatException extends RuntimeException {
    public WrongAnswerFormatException(String message) {
        super(message);
    }
}
