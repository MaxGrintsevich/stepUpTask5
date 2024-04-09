package ru.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Setter
@Getter
public class AgreementDTO {
    Long productId;
    String generalAgreementId;
    String supplementaryAgreementId;
    String arrangementType;
    long schedulerJobId;
    @NotBlank
    String number;
    @NotNull
    Date openingDate;
    Date closingDate;
    Date cancelDate;
    Long validityDuration;
    String cancellationReason;
    String status;
    Date interestCalculationDate;
    BigDecimal interestRate;
    BigDecimal coefficient;
    String coefficientAction;
    BigDecimal minimumInterestRate;
    BigDecimal minimumInterestRateCoefficient;
    String minimumInterestRateCoefficientAction;
    BigDecimal maximaInterestRate;
    BigDecimal maximaInterestRateCoefficient;
    String maximaInterestRateCoefficientAction;

    @Override
    public String toString() {
        return "{" +
                "generalAgreementId='" + generalAgreementId + '\'' +
                ", supplementaryAgreementId='" + supplementaryAgreementId + '\'' +
                ", arrangementType='" + arrangementType + '\'' +
                ", schedulerJobId=" + schedulerJobId +
                ", number='" + number + '\'' +
                ", openingDate=" + openingDate +
                ", closingDate=" + closingDate +
                ", cancelDate=" + cancelDate +
                ", validityDuration=" + validityDuration +
                ", cancellationReason='" + cancellationReason + '\'' +
                ", status='" + status + '\'' +
                ", interestCalculationDate=" + interestCalculationDate +
                ", interestRate=" + interestRate +
                ", coefficient=" + coefficient +
                ", coefficientAction='" + coefficientAction + '\'' +
                ", minimumInterestRate=" + minimumInterestRate +
                ", minimumInterestRateCoefficient='" + minimumInterestRateCoefficient + '\'' +
                ", minimumInterestRateCoefficientAction='" + minimumInterestRateCoefficientAction + '\'' +
                ", maximaInterestRate=" + maximaInterestRate +
                ", maximaInterestRateCoefficient=" + maximaInterestRateCoefficient +
                ", maximaInterestRateCoefficientAction='" + maximaInterestRateCoefficientAction + '\'' +
                '}';
    }
}
