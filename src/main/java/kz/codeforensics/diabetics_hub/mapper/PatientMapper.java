package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient mapToEntity(PatientDto patientDto);

    PatientDto mapToDto(Patient patient);

}
