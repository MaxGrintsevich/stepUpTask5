package ru.project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CorporateSettlementAccount {
    long instanceId;
    String registryTypeCode;
    String accountType;
    String currencyCode;
    String branchCode;
    String priorityCode;
    String mdmCode;
    String clientCode;
    String trainRegion;
    String counter;
    String salesCode;
}
