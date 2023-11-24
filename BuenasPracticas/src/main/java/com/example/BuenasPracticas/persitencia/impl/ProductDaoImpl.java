package com.example.BuenasPracticas.persitencia.impl;

import com.example.BuenasPracticas.Repositories.ProductRepositorie;
import com.example.BuenasPracticas.entitys.Product;
import com.example.BuenasPracticas.persitencia.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements IProductDao {

    private ProductRepositorie productRepositorie;
    @Autowired
    public ProductDaoImpl(ProductRepositorie productRepositorie) {
        this.productRepositorie = productRepositorie;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepositorie.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return ((List<Product>)productRepositorie.findAll());
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepositorie.findProductByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productRepositorie.save(product);
    }

    @Override
    public void deleteByid(Long id) {
        productRepositorie.deleteById(id);
    }
}
