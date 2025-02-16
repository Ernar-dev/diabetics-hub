package kz.codeforensics.diabetics_hub.security.mapper;


import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplcationMapper {

    AuthenticationResponse mapToDto(User entity);

    User mapToEntity(AuthenticationResponse dto);

}
