package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.DoctorProfileDto;
import kz.codeforensics.diabetics_hub.domain.entity.DoctorProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorProfileMapper {

    @Mapping(target = "userId", source = "user")
    DoctorProfile mapToEntity(DoctorProfileDto doctorProfileDto);

    @Mapping(target = "user", source = "userId")
    DoctorProfileDto mapToDto(DoctorProfile doctorProfile);

}
