package ru.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class CorporateSettlementInstance {

    Long instanceId;
    @NotBlank
    String productType;
    @NotBlank
    String productCode;
    @NotBlank
    String registerType;
    @NotBlank
    @Size(max=50)
    String mdmCode;
    @NotBlank
    String contractNumber;
    @NotNull
    Date contractDate;
    @NotBlank
    String priority;
    BigDecimal interestRatePenalty;
    BigDecimal minimalBalance;
    BigDecimal thresholdAmount;
    String accountingDetails;
    String rateType;
    BigDecimal taxPercentageRate;
    BigDecimal technicalOverdraftLimitAmount;
    @NotNull
    Long contractId;
    @NotBlank
    String branchCode;
    @NotBlank
    String isoCurrencyCode;
    @NotBlank
    String urgencyCode;
    @NotNull
    Integer referenceCode;
    List<AdditionalProperty> additionalPropertiesVip;
    List<AgreementDTO> instanceArrangement;

    @Override
    public String toString() {
        return "{" +
                "instanceId=" + instanceId +
                ", productType='" + productType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", registerType='" + registerType + '\'' +
                ", mdmCode='" + mdmCode + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", contractDate=" + contractDate +
                ", priority=" + priority +
                ", interestRatePenalty=" + interestRatePenalty +
                ", minimalBalance=" + minimalBalance +
                ", thresholdAmount=" + thresholdAmount +
                ", accountingDetails='" + accountingDetails + '\'' +
                ", rateType='" + rateType + '\'' +
                ", taxPercentageRate=" + taxPercentageRate +
                ", technicalOverdraftLimitAmount=" + technicalOverdraftLimitAmount +
                ", contractId=" + contractId +
                ", branchCode='" + branchCode + '\'' +
                ", isoCurrencyCode='" + isoCurrencyCode + '\'' +
                ", urgencyCode='" + urgencyCode + '\'' +
                ", referenceCode=" + referenceCode +
                ", additionalPropertiesVip=" + additionalPropertiesVip +
                ", instanceArrangement=" + instanceArrangement +
                '}';
    }
}
