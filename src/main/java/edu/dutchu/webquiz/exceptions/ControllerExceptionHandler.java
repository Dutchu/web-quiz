package edu.dutchu.webquiz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler ({WrongAnswerFormatException.class, QuizNotFoundException.class})
    public ResponseEntity<ExceptionCustomMessage> handleQuizNotFoundException(RuntimeException e, WebRequest request) {

        ExceptionCustomMessage message = new ExceptionCustomMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getDescription(false));
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
