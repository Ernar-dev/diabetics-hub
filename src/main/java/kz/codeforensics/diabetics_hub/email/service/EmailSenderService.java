package kz.codeforensics.diabetics_hub.email.service;

import jakarta.mail.internet.MimeMessage;
import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    public void sendEmailMorning(String to, Long userId) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("ernaramangeldi64@gmail.com");
            helper.setTo(to);
            helper.setSubject("Напоминание о приёме лекарства");

            // Подставляем userId в шаблон
            Context context = new Context();
            context.setVariable("userId", userId);

            String html = templateEngine.process("email-template", context);

            helper.setText(html, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке письма", e);
        }
    }

    public void sendEmailNoon(String to, Long userId) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("ernaramangeldi64@gmail.com");
            helper.setTo(to);
            helper.setSubject("Напоминание о приёме лекарства");

            // Подставляем userId в шаблон
            Context context = new Context();
            context.setVariable("userId", userId);

            String html = templateEngine.process("email-template-noon", context);

            helper.setText(html, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке письма", e);
        }
    }

    public void sendEmailNight(String to, Long userId) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("ernaramangeldi64@gmail.com");
            helper.setTo(to);
            helper.setSubject("Напоминание о приёме лекарства");

            // Подставляем userId в шаблон
            Context context = new Context();
            context.setVariable("userId", userId);

            String html = templateEngine.process("email-template-night", context);

            helper.setText(html, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке письма", e);
        }
    }

}

