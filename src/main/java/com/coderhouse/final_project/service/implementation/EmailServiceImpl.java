package com.coderhouse.final_project.service.implementation;


import com.coderhouse.final_project.model.documents.Orden;
import com.coderhouse.final_project.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl  implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Orden orden) {
        var message = new SimpleMailMessage();
        message.setTo("coderhouse.camila26@gmail.com");

        message.setSubject("Orden generada n°: " + orden.getOrderNumber());
        message.setText("La orden generada es la siguiente:" + orden.toString());

        javaMailSender.send(message);
    }

}
