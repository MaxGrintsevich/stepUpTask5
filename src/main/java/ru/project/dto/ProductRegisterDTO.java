package ru.project.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRegisterDTO {
    private Long productId;
    private String branchCode;
    private String currencyCode;
    private String mdmCode;
    private String priorityCode;
    private String type;

}
