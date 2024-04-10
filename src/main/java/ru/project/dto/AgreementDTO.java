package ru.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Builder
@Data
public class AgreementDTO {
    private Long productId;
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private long schedulerJobId;
    @NotBlank
    private String number;
    @NotNull
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private Long validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private BigDecimal interestRate;
    private BigDecimal coefficient;
    private String coefficientAction;
    private BigDecimal minimumInterestRate;
    private BigDecimal minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;
    private BigDecimal maximaInterestRate;
    private BigDecimal maximaInterestRateCoefficient;
    private String maximaInterestRateCoefficientAction;

}
