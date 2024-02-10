package com.barretorafael.course.repositories;

import com.barretorafael.course.entities.OrderItem;
import com.barretorafael.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
