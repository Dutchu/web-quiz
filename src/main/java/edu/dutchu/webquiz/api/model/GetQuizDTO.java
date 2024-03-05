package edu.dutchu.webquiz.api.model;

public record GetQuizDTO (String title, String text, String[] options, Long id){
}
