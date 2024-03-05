package edu.dutchu.webquiz.exceptions;

import java.time.LocalDateTime;

public class ExceptionCustomMessage {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;

    public ExceptionCustomMessage(int statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}
