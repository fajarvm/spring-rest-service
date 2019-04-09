package com.github.fajarvm.restwebservice.service;

import com.github.fajarvm.restwebservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(final Integer productId);

    boolean save(Product product);

    boolean update(Product product);

}
