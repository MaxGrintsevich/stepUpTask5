package ru.project.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.project.dto.CorporateSettlementAccount;
import ru.project.dto.ProductRegisterDTO;

@Mapper(componentModel = "spring")
public interface CSAccountMapper {
    @Mapping( target="type", source="registryTypeCode")
    ProductRegisterDTO toRegisterDTO(CorporateSettlementAccount csa);
}
