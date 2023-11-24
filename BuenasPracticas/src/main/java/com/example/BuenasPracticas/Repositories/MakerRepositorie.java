package com.example.BuenasPracticas.Repositories;

import com.example.BuenasPracticas.entitys.Maker;
import com.example.BuenasPracticas.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MakerRepositorie extends JpaRepository<Maker, Long> {

    public Optional<Maker> findByRuc(String ruc);
    Boolean existsByRuc(String ruc);


}
