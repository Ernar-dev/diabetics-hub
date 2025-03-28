package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.GlucoseMonitoringDto;
import kz.codeforensics.diabetics_hub.domain.dto.MeasurementDto;
import kz.codeforensics.diabetics_hub.domain.entity.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    Measurement mapToEntity(MeasurementDto measurementDto);

    MeasurementDto mapToDto(Measurement measurement);

    GlucoseMonitoringDto mapToGlucoseMonitoringDto(Measurement measurement);

}
