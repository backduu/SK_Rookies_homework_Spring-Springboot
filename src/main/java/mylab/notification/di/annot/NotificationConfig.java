package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        // SMTP 서버와 포트 설정
        return new EmailNotificationService("smtp.mail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        // SMS 제공업체 설정
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager(
            EmailNotificationService emailService,
            SmsNotificationService smsService) {
        // 위에서 정의한 서비스들을 주입하여 NotificationManager 생성
        return new NotificationManager(emailService, smsService);
    }
}
