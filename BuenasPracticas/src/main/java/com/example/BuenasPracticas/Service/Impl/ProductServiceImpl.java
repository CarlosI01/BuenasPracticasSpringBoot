package com.example.BuenasPracticas.Service.Impl;

import com.example.BuenasPracticas.Service.IProductService;
import com.example.BuenasPracticas.entitys.Product;
import com.example.BuenasPracticas.persitencia.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductDao productDao;
    @Autowired
    public ProductServiceImpl(IProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDao.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteByid(Long id) {
        productDao.deleteByid(id);
    }
}
