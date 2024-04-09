package ru.project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ValidationErrorResponse {
    private final Integer status;
    private final String error;
    private final List<Violation> violations;

}

