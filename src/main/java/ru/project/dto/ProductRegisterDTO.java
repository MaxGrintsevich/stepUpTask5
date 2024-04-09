package ru.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductRegisterDTO {
    Long productId;
    String branchCode;
    String currencyCode;
    String mdmCode;
    String priorityCode;
    String type;

}
