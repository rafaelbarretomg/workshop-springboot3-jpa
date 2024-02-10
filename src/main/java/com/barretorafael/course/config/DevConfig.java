package com.barretorafael.course.config;

import com.barretorafael.course.entities.*;
import com.barretorafael.course.entities.enums.OrderStatus;
import com.barretorafael.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p6 = new Product(null, "Samsung Galaxy S21", "Sed vitae turpis nec augue ultricies commodo.", 899.99, "");
        Product p7 = new Product(null, "Wireless Headphones", "Quisque vitae justo eget urna vehicula rhoncus.", 129.95, "");
        Product p8 = new Product(null, "Coffee Maker", "Fusce dapibus, tellus ac cursus commodo.", 49.99, "");
        Product p9 = new Product(null, "Fitness Tracker", "Integer nec odio. Praesent libero.", 79.5, "");
        Product p10 = new Product(null, "Canon DSLR Camera", "Vestibulum id ligula porta felis euismod semper.", 699.0, "");
        Product p11 = new Product(null, "Bluetooth Speaker", "Curabitur blandit tempus porttitor.", 59.99, "");
        Product p12 = new Product(null, "External Hard Drive", "Aenean eu leo quam. Pellentesque ornare sem.", 119.0, "");
        Product p13 = new Product(null, "Electric Toothbrush", "Nullam id dolor id nibh ultricies vehicula ut id elit.", 39.95, "");
        Product p14 = new Product(null, "Gaming Mouse", "Etiam porta sem malesuada magna mollis euismod.", 49.99, "");
        Product p15 = new Product(null, "Wireless Charging Pad", "Duis mollis, est non commodo luctus.", 29.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

        p6.getCategories().add(cat1);
        p7.getCategories().add(cat3);
        p7.getCategories().add(cat1);
        p8.getCategories().add(cat1);
        p9.getCategories().add(cat1);
        p10.getCategories().add(cat1);
        p11.getCategories().add(cat1);
        p11.getCategories().add(cat3);
        p12.getCategories().add(cat1);
        p12.getCategories().add(cat3);
        p13.getCategories().add(cat1);
        p14.getCategories().add(cat1);
        p14.getCategories().add(cat3);
        p15.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));


        User u3 = new User(null, "Ana Oliveira", "ana@gmail.com", "966666666", "qwerty");
        User u4 = new User(null, "Carlos Pereira", "carlos@gmail.com", "955555555", "xyz123");
        User u5 = new User(null, "João Silva", "joao@gmail.com", "977777777", "abcdef");


        Order o4 = new Order(null, Instant.parse("2019-06-19T19:53:07Z"), OrderStatus.PAID, u3);
        Order o5 = new Order(null, Instant.parse("2019-07-19T03:42:10Z"), OrderStatus.DELIVERED, u4);
        Order o6 = new Order(null, Instant.parse("2019-07-19T15:21:22Z"), OrderStatus.SHIPPED, u5);
        Order o7 = new Order(null, Instant.parse("2019-07-19T15:21:22Z"), OrderStatus.CANCELED, u5);

        userRepository.saveAll(Arrays.asList(u3, u4, u5));
        orderRepository.saveAll(Arrays.asList(o4, o5, o6, o7));

        OrderItem oi5 = new OrderItem(o4, p6, 2, p6.getPrice());
        OrderItem oi6 = new OrderItem(o5, p8, 1, p8.getPrice());
        OrderItem oi7 = new OrderItem(o6, p10, 3, p10.getPrice());
        OrderItem oi8 = new OrderItem(o7, p12, 4, p12.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi5, oi6, oi7, oi8));

        Payment pay2 = new Payment(null, Instant.parse("2019-07-24T20:53:07Z"), o5);
        Payment pay3 = new Payment(null, Instant.parse("2019-07-24T19:53:07Z"), o6);
        Payment pay4 = new Payment(null, Instant.parse("2019-07-24T21:53:07Z"), o4);
        o5.setPayment(pay2);
        o6.setPayment(pay3);
        o4.setPayment(pay4);

        orderRepository.saveAll(Arrays.asList(o4, o5, o6));


    }
}

