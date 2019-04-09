package com.github.fajarvm.restwebservice.service.impl;

import com.github.fajarvm.restwebservice.model.Product;
import com.github.fajarvm.restwebservice.repository.ProductRepository;
import com.github.fajarvm.restwebservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            return product;
        }

        log.error("Cannot find product with ID: " + productId);
        return Optional.empty();
    }

    @Override
    public boolean save(Product product) {
        if (product.getCurrentPrice() == null) {
            product.setCurrentPrice((double) 0);
        }

        if (product.getLastUpdate() == null) {
            Date now = new Date();
            product.setLastUpdate(now.getTime());
        }

        try {
            repository.save(product);

            // TODO: return a response that can be worked with
            return true;
        } catch (Exception e) {
            // TODO: return a response that can be worked with
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        Optional<Product> result = repository.findById(product.getId());
        if (result.isPresent()) {
            Product updated = result.get();
            if (product.getName() != null) {
                updated.setName(product.getName());
            }

            if (product.getCurrentPrice() != null) {
                updated.setCurrentPrice(product.getCurrentPrice());
            }

            Date now = new Date();
            updated.setLastUpdate(now.getTime());

            try {
                repository.saveAndFlush(updated);

                // TODO: return a response that can be worked with
                return true;
            } catch (Exception e) {

                // TODO: return a response that can be worked with
                return false;
            }
        }

        // TODO: return a response that can be worked with
        return false;
    }
}
