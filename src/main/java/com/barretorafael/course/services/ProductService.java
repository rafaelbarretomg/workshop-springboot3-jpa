package com.barretorafael.course.services;

import com.barretorafael.course.entities.Product;
import com.barretorafael.course.entities.User;
import com.barretorafael.course.repositories.ProductRepository;
import com.barretorafael.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
