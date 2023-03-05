package org.astashonok.userservice.mapper;

public interface ParameterizedDtoMapper<DTO, ENTITY> {

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
