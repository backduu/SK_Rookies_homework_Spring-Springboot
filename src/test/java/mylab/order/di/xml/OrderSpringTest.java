package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class OrderSpringTest {
    @Test
    void testShoppingCartTotalPrice() {
        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product("P001", "Keyboard", 49.99);
        Product p2 = new Product("P002", "Mouse", 29.99);
        Product p3 = new Product("P003", "Monitor", 199.99);
        
        cart.setProducts(Arrays.asList(p1, p2, p3));

        double expectedTotal = 49.99 + 29.99 + 199.99;
        assertEquals(expectedTotal, cart.getTotalPrice(), 0.001, "Total price should match sum of product prices");
    }
    
    @Test
    void testOrderServiceTotalPrice() {
    	ShoppingCart cart = new ShoppingCart();
        cart.setProducts(Arrays.asList(
                new Product("P101", "Laptop", 999.99),
                new Product("P102", "Charger", 49.99)
        ));

        OrderService orderService = new OrderService();
        orderService.setShoppingCart(cart);

        double expectedTotal = 999.99 + 49.99;
        assertEquals(expectedTotal, orderService.calculateOrderTotal(), 0.001, "Order total should match cart total");
    }
}
