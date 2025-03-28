package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.DoctorProfileDto;
import kz.codeforensics.diabetics_hub.domain.entity.DoctorProfile;

public interface DoctorProfileService {

    DoctorProfileDto create(DoctorProfileDto doctorProfileDto);

//    DoctorProfile save(DoctorProfile doctorProfile);

}
