package kz.codeforensics.diabetics_hub.security.mapper;


import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import kz.codeforensics.diabetics_hub.security.utils.PasswordEncoderUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = PasswordEncoderUtil.class)
public interface ApplcationMapper {

    AuthenticationResponse mapToDto(User entity);

    User mapToEntity(AuthenticationResponse dto);

    @Mapping(target = "password", source = "dto.password", qualifiedByName = "encodePassword")
    @Mapping(target = "roles", source = "authority")
    User mapToEntityRegistrationDto(RegistrationDto dto, Set<Role> authority);

}
