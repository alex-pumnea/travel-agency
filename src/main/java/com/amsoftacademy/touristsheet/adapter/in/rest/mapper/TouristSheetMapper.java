package com.amsoftacademy.touristsheet.adapter.in.rest.mapper;

import com.amsoftacademy.touristsheet.adapter.in.rest.dto.TouristSheetRequest;
import com.amsoftacademy.touristsheet.domain.TouristSheet;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CustomerMapper.class, AddressMapper.class, TravelInfoMapper.class, EmergencyContactMapper.class})
public interface TouristSheetMapper {
    TouristSheet toEntity(TouristSheetRequest touristSheetRequest);

    TouristSheetRequest toDto(TouristSheet touristSheet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TouristSheet partialUpdate(TouristSheetRequest touristSheetRequest, @MappingTarget TouristSheet touristSheet);
}