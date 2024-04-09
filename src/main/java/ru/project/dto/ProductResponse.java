package ru.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ProductResponse {
    String instanceId;
    List<Long> registerId = new ArrayList<>();
    List<Long> supplementaryAgreementId = new ArrayList<>();
}
