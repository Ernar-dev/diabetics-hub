package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientHistoryMapper {

    PatientHistory mapToEntity(PatientHistoryDto patientHistoryDto);

    PatientHistoryDto mapToDto(PatientHistory patientHistory);

}
