package com.anks.tech.ecommerce.Utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${base.url}")
    private String url;
    @Async
    public void sendOtpEmail(String name, String email, String otp) throws MessagingException, UnsupportedEncodingException {


        String fromAddress = "anksngo@gmail.com";
        String senderName = "Anks Tech";
        String subject = "Please verify your registration";
        String content = "Dear ${name},<br>"
                        + "Please click the link below to verify your registration:<br>"
                        + """
                        <div>
                        <a href="${url}/api/v1/verify-account?email=%s&otp=%s" target="_blank">VERIFY</a>
                        </div>
                        """
                        + "Thank you!,<br>"
                        + "Anks Tech.";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom(fromAddress,senderName);

        mimeMessageHelper.setTo(email);


        mimeMessageHelper.setSubject(subject);

        content = content.replace("${name}", name);
        content = content.replace("${url}", this.url);
        mimeMessageHelper.setText( content
        .formatted(email, otp), true);

        javaMailSender.send(mimeMessage);
    }

}
