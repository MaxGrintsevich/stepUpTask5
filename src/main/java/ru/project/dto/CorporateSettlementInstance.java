package ru.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CorporateSettlementInstance {

    private Long instanceId;
    @NotBlank
    private String productType;
    @NotBlank
    private String productCode;
    @NotBlank
    private String registerType;
    @NotBlank
    @Size(max=50)
    private String mdmCode;
    @NotBlank
    private String contractNumber;
    @NotNull
    private Date contractDate;
    @NotBlank
    private String priority;
    private BigDecimal interestRatePenalty;
    private BigDecimal minimalBalance;
    private BigDecimal thresholdAmount;
    private String accountingDetails;
    private String rateType;
    private BigDecimal taxPercentageRate;
    private BigDecimal technicalOverdraftLimitAmount;
    @NotNull
    private Long contractId;
    @NotBlank
    private String branchCode;
    @NotBlank
    private String isoCurrencyCode;
    @NotBlank
    private String urgencyCode;
    @NotNull
    private Integer referenceCode;
    private List<AdditionalProperty> additionalPropertiesVip;
    private List<AgreementDTO> instanceArrangement;

}
