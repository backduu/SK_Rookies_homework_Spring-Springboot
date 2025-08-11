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

        // EmailNotificationService가 주입되었는지 확인
        assertNotNull(notificationManager.getEmailService(), "EmailNotificationService가 null입니다.");
    }
}
