package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.PrescriptionDto;
import kz.codeforensics.diabetics_hub.domain.entity.Prescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

    Prescription mapToEntity(PrescriptionDto prescriptionDto);

    PrescriptionDto mapToDto(Prescription prescription);

}
