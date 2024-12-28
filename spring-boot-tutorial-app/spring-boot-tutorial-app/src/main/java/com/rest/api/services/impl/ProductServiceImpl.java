package com.rest.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entities.Product;
import com.rest.api.repositories.ProductRepository;
import com.rest.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Product product, int productId) {
        Product product1 = this.productRepository.findById(productId).orElseThrow( () ->new RuntimeException("Product not found") );
        product1.setAbout(product.getAbout());
        product1.setName(product.getName());;
        product1.setPrice(product.getPrice());

        return this.productRepository.save(product1);
    }

    @Override
    public void delete(int productId) {
        Product product1 = this.productRepository.findById(productId).orElseThrow( () ->new RuntimeException("Product not found") );
        this.productRepository.delete(product1);
    }

    @Override
    public Product getById(int productId) {
        Product product1 = this.productRepository.findById(productId).orElseThrow( () ->new RuntimeException("Product not found") );
        return product1;
    }

    @Override
    public List<Product> getAll() {
        List<Product> all =  this.productRepository.findAll();
        return all;
    }

}
