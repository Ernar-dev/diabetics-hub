package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChatMessageDto {

    private Long senderId;

    private Long receiverId;

    private String message;

    private LocalDate createdAt;

}
