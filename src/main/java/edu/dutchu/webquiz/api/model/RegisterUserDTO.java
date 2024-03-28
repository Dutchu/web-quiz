package edu.dutchu.webquiz.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record RegisterUserDTO(@Email(regexp=".+@.+\\..+") String email, @Pattern(regexp = ".{5,}") String password) {
}
