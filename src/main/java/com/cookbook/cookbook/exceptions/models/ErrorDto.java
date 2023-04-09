package com.cookbook.cookbook.exceptions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {

    private int statusCode;

    private String message;
}
