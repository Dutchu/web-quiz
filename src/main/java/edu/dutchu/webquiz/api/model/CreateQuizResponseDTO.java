package edu.dutchu.webquiz.api.model;

import java.util.List;

//In tests order is important, so I have to return list instead of set
public record CreateQuizResponseDTO(String title, String text, List<String> options, Long id) {
}