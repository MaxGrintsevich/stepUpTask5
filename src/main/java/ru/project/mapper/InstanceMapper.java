package ru.project.mapper;

import org.mapstruct.*;
import ru.project.dto.ProductRegisterDTO;
import ru.project.model.TppProduct;
import ru.project.dto.CorporateSettlementInstance;

@Mapper(componentModel = "spring")
public interface InstanceMapper {


    @Mapping(target = "clientId", source = "mdmCode")
    @Mapping(target = "type", source = "productType")
    @Mapping(target = "number", source = "contractNumber")
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "dateOfConclusion", source = "contractDate")
    @Mapping(target = "startDateTime", source = "contractDate")
    @Mapping(target = "penaltyRate", source = "interestRatePenalty")
    @Mapping(target = "nso", source = "minimalBalance")
    @Mapping(target = "thresholdAmount", source = "thresholdAmount")
    @Mapping(target = "interestRateType", source = "rateType")
    @Mapping(target = "requisiteType", source = "accountingDetails")
    @Mapping(target = "taxRate", source = "taxPercentageRate")
    //@Mapping(target = "branchCode", source = "branchCode")
    TppProduct map (CorporateSettlementInstance csi);

    @Mapping(target = "branchCode", source = "branchCode")
    @Mapping(target = "currencyCode", source = "isoCurrencyCode")
    @Mapping(target = "mdmCode", source = "mdmCode")
    @Mapping(target = "priorityCode", source = "priority")
    @Mapping(target = "productId", source = "instanceId")
    ProductRegisterDTO registerMap(CorporateSettlementInstance csi);
}
