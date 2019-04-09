package com.github.fajarvm.restwebservice.controller;

import com.github.fajarvm.restwebservice.model.Product;
import com.github.fajarvm.restwebservice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "products", description = "the products API")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    /**
     * Get a list of products.
     */
    @ApiOperation(value = "Get a list of products", nickname = "getAll", notes = "Returns a list of products", response = Product.class, responseContainer = "List", tags = {"products",})
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAll() {
        return service.findAll();
    }

    /**
     * Get a single product with the given ID.
     */
    @ApiOperation(value = "Find a product by ID", nickname = "getById", notes = "Returns a single product with the given ID", response = Product.class, tags = {"products",})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable("id") final Integer id) {
        Optional<Product> product = service.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            // TODO: return the appropriate HTTP response
            return null;
        }
    }

    /**
     * Update a single product with the given ID.
     */
    @ApiOperation(value = "Update a product by ID", nickname = "update", notes = "Updates a product with the given ID", tags = {"products",})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") final Integer id, @RequestBody Product product) {
        product.setId(id);
        boolean updated = service.update(product);
        if (updated) {
            log.debug("Successfully updated a product with ID: " + id);
        } else {
            // TODO: return the appropriate HTTP response
            log.error("Cannot find product with ID: " + id);
        }
    }

    /**
     * Creates a product.
     */
    @ApiOperation(value = "Add a new product to the list", nickname = "create", notes = "Creates a new product to the list", tags = {"products",})
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody final Product product) {
        boolean created = service.save(product);
        if (created) {
            log.debug("Successfully created a product");
        } else {
            // TODO: return the appropriate HTTP response
            log.error("Cannot create product");
        }
    }
}
