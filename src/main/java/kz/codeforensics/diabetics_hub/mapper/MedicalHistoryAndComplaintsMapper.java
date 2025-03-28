package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import kz.codeforensics.diabetics_hub.domain.entity.MedicalHistoryAndComplaints;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalHistoryAndComplaintsMapper {

    MedicalHistoryAndComplaints mapToEntity(MedicalHistoryAndComplaintsDto dto);

    MedicalHistoryAndComplaintsDto mapToDto(MedicalHistoryAndComplaints entity);

}
