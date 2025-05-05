package kz.codeforensics.diabetics_hub.email.service;

import kz.codeforensics.diabetics_hub.service.DrugService;
import org.springframework.stereotype.Service;

import jakarta.mail.*;
import java.util.Properties;

@Service
public class EmailReceiverService {

    private final DrugService drugService;

    public EmailReceiverService(DrugService drugService) {
        this.drugService = drugService;
    }

    public void readEmails() {
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");

            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "your_email@gmail.com", "your_app_password");

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();

            System.out.println("Total messages: " + messages.length);
            for (int i = messages.length - 1; i >= Math.max(0, messages.length - 5); i--) {
                Message message = messages[i];
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Subject: " + message.getSubject());
                System.out.println("---------------------------");
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswerMorning(String answer, Long userId) {
        drugService.saveMorning(answer, userId);
    }

    public void getAnswerNoon(String answer, Long userId) {
        drugService.saveNoon(answer, userId);
    }

    public void getAnswerNight(String answer, Long userId) {
        drugService.saveNight(answer, userId);
    }

}
