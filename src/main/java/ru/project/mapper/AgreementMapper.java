package ru.project.mapper;

import org.mapstruct.Mapper;
import ru.project.dto.AgreementDTO;
import ru.project.model.Agreement;

@Mapper(componentModel = "spring")
public interface AgreementMapper {

    Agreement toEntity(AgreementDTO dto);
}
