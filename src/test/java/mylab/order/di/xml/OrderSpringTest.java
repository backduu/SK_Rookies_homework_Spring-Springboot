package mylab.order.di.xml;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
    @Autowired
    private ShoppingCart cart;

    @Autowired
    private OrderService orderService;

    @Test
    public void testShoppingCart() {
        double expectedTotal = 1800000 + 800000;
        assertEquals(expectedTotal, cart.getTotalPrice());
    }

    @Test
    public void testOrderService() {
        double expectedTotal = 1800000 + 800000;
        assertEquals(expectedTotal, orderService.calculateOrderTotal());
    }

}
