package ru.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OthersErrorResponse {
    private int status;
    private String error;
    private String stack;

}
