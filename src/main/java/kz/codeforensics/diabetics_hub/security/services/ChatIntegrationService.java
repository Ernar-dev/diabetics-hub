package kz.codeforensics.diabetics_hub.security.services;

import kz.codeforensics.diabetics_hub.security.models.dto.ChatUserDTO;
import kz.codeforensics.diabetics_hub.security.models.dto.ChatUserLoginDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatIntegrationService {

    @Value("${chat.server.url}") // например: http://localhost:3001/api/chat/register
    private String chatServerUrl;

    @Value("${chat.server.login.url}")
    private String chatServerLoginUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendUserToChatServer(ChatUserDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ChatUserDTO> request = new HttpEntity<>(dto, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(chatServerUrl, request, String.class);
            System.out.println("Response from Chat Server: " + response.getBody());
        } catch (Exception ex) {
            System.err.println("Failed to send data to chat server: " + ex.getMessage());
        }
    }

    public void sendUserToChatLoginServer(ChatUserLoginDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ChatUserLoginDto> request = new HttpEntity<>(dto, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(chatServerLoginUrl, request, String.class);
            System.out.println("Response from Chat Server: " + response.getBody());
        } catch (Exception ex) {
            System.err.println("Failed to send data to chat server: " + ex.getMessage());
        }
    }

}

