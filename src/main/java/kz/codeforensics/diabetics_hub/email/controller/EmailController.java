package kz.codeforensics.diabetics_hub.email.controller;

import kz.codeforensics.diabetics_hub.email.service.EmailReceiverService;
import kz.codeforensics.diabetics_hub.email.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailSenderService senderService;

    @Autowired
    private EmailReceiverService receiverService;

    @PostMapping("/send-morning")
    public String sendEmailMorning(@RequestParam String to,
                            @RequestParam Long userId) {
        senderService.sendEmailMorning(to, userId);
        return "Email sent successfully!";
    }

    @PostMapping("/send-noon")
    public String sendEmailNoon(@RequestParam String to,
                            @RequestParam Long userId) {
        senderService.sendEmailNoon(to, userId);
        return "Email sent successfully!";
    }

    @PostMapping("/send-night")
    public String sendEmailNight(@RequestParam String to,
                            @RequestParam Long userId) {
        senderService.sendEmailNight(to, userId);
        return "Email sent successfully!";
    }

    @GetMapping("/email-response-morning")
    public String handleEmailResponseMorning(
            @RequestParam String answer,
            @RequestParam Long userId // Можно и String, если не числовой
    ) {
        receiverService.getAnswerMorning(answer, userId);
        return "Спасибо за ваш ответ: " + (answer.equals("yes") ? "✅ Да" : "❌ Нет");
    }

    @GetMapping("/email-response-noon")
    public String handleEmailResponseNoon(
            @RequestParam String answer,
            @RequestParam Long userId // Можно и String, если не числовой
    ) {
        receiverService.getAnswerNoon(answer, userId);
        return "Спасибо за ваш ответ: " + (answer.equals("yes") ? "✅ Да" : "❌ Нет");
    }

    @GetMapping("/email-response-night")
    public String handleEmailResponse(
            @RequestParam String answer,
            @RequestParam Long userId // Можно и String, если не числовой
    ) {
        receiverService.getAnswerNight(answer, userId);
        return "Спасибо за ваш ответ: " + (answer.equals("yes") ? "✅ Да" : "❌ Нет");
    }

}
