package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;

public record  AuthLoginRequest (@NotBlank String username,
                                 @NotBlank String password) {

}
