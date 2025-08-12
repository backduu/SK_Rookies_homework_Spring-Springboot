package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mylab.user.di.annot.UserService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotificationManagerManager() {
        // NotificationManager가 주입되었는지 확인
        assertNotNull(notificationManager, "NotificationManager가 null입니다.");

        //이메일 서비스 검증
        NotificationService emailService = notificationManager.getEmailService();
        assertNotNull(notificationManager.getEmailService(), "EmailNotificationService is null");
        assertTrue(emailService instanceof EmailNotificationService, "EmailService is not type of EmailNotificationService");

        EmailNotificationService email = (EmailNotificationService) emailService;
        assertEquals("smtp.mail.com", email.getSmtpServer(), "SMTP is 'smtp.mail.com'");
        assertEquals(587, email.getPort(), "SMTP port number is 587");
        
        // SMS 서비스 검증
        NotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService, "SmsNotificationService is null");
        assertTrue(smsService instanceof SmsNotificationService, "SmsService is not type of SmsNotificationService");

        SmsNotificationService sms = (SmsNotificationService) smsService;
        assertEquals("SKT", sms.getProvider(), "Provider is not 'SKT'");
        
        // NotificationManager의 메서드 실행
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");

    }
}
