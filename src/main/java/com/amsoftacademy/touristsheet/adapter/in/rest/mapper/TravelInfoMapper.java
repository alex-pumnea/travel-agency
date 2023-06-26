package com.amsoftacademy.touristsheet.adapter.in.rest.mapper;

import com.amsoftacademy.touristsheet.adapter.in.rest.dto.TravelInfoDto;
import com.amsoftacademy.touristsheet.domain.TravelInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TravelInfoMapper {
    TravelInfo toEntity(TravelInfoDto travelInfoDto);

    TravelInfoDto toDto(TravelInfo travelInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TravelInfo partialUpdate(TravelInfoDto travelInfoDto, @MappingTarget TravelInfo travelInfo);
}