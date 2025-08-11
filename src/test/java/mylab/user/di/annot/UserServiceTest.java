package mylab.user.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testDI() {
        assertNotNull("UserService has injected", userService);
        assertNotNull("UserRepository has injected", userService.getUserRepository());
        
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        assertNotNull("SecurityService has injected", userService.getSecurityService());
    }

    @Test
    public void testRegisterUser() {
        boolean result = userService.registerUser("user01", "홍길동", "secure123");
        assertTrue("User should be registered successfully", result);
    }

}
