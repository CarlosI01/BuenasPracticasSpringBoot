package com.example.BuenasPracticas.persitencia;

import com.example.BuenasPracticas.entitys.Maker;
import com.example.BuenasPracticas.entitys.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDao {

    public Optional<Product> findById(Long id);
    public List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    public void save (Product product);

    public void deleteByid(Long id);
}
