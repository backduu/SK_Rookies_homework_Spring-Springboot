package mylab.order.di.xml;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;
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
    	assertNotNull("ShoppingCart has injected", cart);
    	assertEquals(2, cart.getProducts().size(), "There are not two products.");
        assertEquals("노트북", cart.getProducts().get(0).getName(), "First one is not a notebook");
        assertEquals("스마트폰", cart.getProducts().get(1).getName(), "Second one is not a phone"); 
    }

    @Test
    public void testOrderService() {
    	assertNotNull("orderService has injected", orderService);
    	assertEquals(2600000.0, orderService.calculateOrderTotal(), "It's not same.");
    }

}
