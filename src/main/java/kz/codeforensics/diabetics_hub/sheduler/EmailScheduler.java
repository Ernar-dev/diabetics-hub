package kz.codeforensics.diabetics_hub.sheduler;

import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmailScheduler {

    private UserService userService;
    private final RestTemplate restTemplate;

    public EmailScheduler(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    // Отправка в 08:00
    @Scheduled(cron = "0 0 8 * * *")
    public void sendMorningReminder() {
        try {
            List<User> userList = userService.findAll();
            for (User user : userList) {
                for (Role role : user.getRoles()) {
                    if (role.getName() == RoleEnum.PATIENT) {
                        String url = "http://localhost:8080/email/send-morning"
                                + "?to=" + user.getEmail()
                                + "&userId=" + user.getId();

                        restTemplate.postForObject(url, null, String.class);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке напоминания: " + e.getMessage(), e);
        }

    }

    // Отправка в 14:00
    @Scheduled(cron = "0 0 14 * * *")
    public void sendAfternoonReminder() {
        try {
            List<User> userList = userService.findAll();
            for (User user : userList) {
                for (Role role : user.getRoles()) {
                    if (role.getName() == RoleEnum.PATIENT) {
                        String url = "http://localhost:8080/email/send-noon"
                                + "?to=" + user.getEmail()
                                + "&userId=" + user.getId();

                        restTemplate.postForObject(url, null, String.class);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке напоминания: " + e.getMessage(), e);
        }
    }

    // Отправка в 20:00
    @Scheduled(cron = "0 0 20 * * *")
    public void sendEveningReminder() {
        try {
            List<User> userList = userService.findAll();
            for (User user : userList) {
                for (Role role : user.getRoles()) {
                    if (role.getName() == RoleEnum.PATIENT) {
                        String url = "http://localhost:8080/email/send-night"
                                + "?to=" + user.getEmail()
                                + "&userId=" + user.getId();

                        restTemplate.postForObject(url, null, String.class);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке напоминания: " + e.getMessage(), e);
        }
    }
}

