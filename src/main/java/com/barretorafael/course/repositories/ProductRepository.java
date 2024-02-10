package com.barretorafael.course.repositories;

import com.barretorafael.course.entities.Category;
import com.barretorafael.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
