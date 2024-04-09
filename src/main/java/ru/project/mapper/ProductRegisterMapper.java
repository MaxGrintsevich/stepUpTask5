package ru.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.project.dto.ProductRegisterDTO;
import ru.project.model.TppProductRegister;

@Mapper(componentModel = "spring")
public interface ProductRegisterMapper {
    TppProductRegister toEntity(ProductRegisterDTO dto);
}

