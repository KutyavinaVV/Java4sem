package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.models.Appointment;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendUserMail(UserDetailsImpl user, Appointment appointment) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String message = "Your entry has been successfully created! Details: " +
                appointment.getDate() + " " + appointment.getTime() + " " + appointment.getFullName();
        mailMessage.setFrom(username);
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Appointment");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }




}
