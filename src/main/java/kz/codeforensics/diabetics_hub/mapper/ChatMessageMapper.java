package kz.codeforensics.diabetics_hub.mapper;

import kz.codeforensics.diabetics_hub.domain.dto.ChatMessageDto;
import kz.codeforensics.diabetics_hub.domain.entity.ChatMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

    ChatMessage mapToEntity(ChatMessageDto chatMessageDto);

    ChatMessageDto mapToDto(ChatMessage chatMessage);

}
