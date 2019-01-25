package ru.javastudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javastudy.dao.models.MailUser;
import ru.javastudy.dao.models.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;


@Controller
public class MailController {

    @RequestMapping(value="/send",method = RequestMethod.POST)
    public String send(@ModelAttribute("mailUser") MailUser mailUser){
        sendEmail(mailUser);
        return "redirect:/callback";//will redirect to viewemp request mapping
    }

    @RequestMapping("/callback")
    public String viewsend(Model m){
        m.addAttribute("command", new MailUser());
        return "callback";
    }

    private void sendEmail(MailUser mailUser) {
        final String systemMail = "ser.lakhmenev123@gmail.com";
        final String systemPassword = "lahmenev1q2w3e4r5t6y";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(systemMail, systemPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(systemMail));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ser.lakhmenev1993@mail.ru"));
            //тема сообщения
            message.setSubject("Сообщения от клиентов (свадьба)","UTF-8");
            //текст
            message.setText(mailUser.getText() + "\n" + "\n"+ "Имя заказчика: " + mailUser.getUserName() + "\n"
                    + "Номер телефона: " + mailUser.getPhoneNumber() + "\n" + "Электронная почта: " + mailUser.getEmail());

            //отправляем сообщение
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
