package com.example.BuenasPracticas.Service;

import com.example.BuenasPracticas.entitys.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Optional<Product> findById(Long id);
    public List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    public void save (Product product);

    public void deleteByid(Long id);
}
