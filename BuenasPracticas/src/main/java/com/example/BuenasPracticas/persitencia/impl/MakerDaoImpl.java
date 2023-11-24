package com.example.BuenasPracticas.persitencia.impl;

import com.example.BuenasPracticas.Repositories.MakerRepositorie;
import com.example.BuenasPracticas.entitys.Maker;
import com.example.BuenasPracticas.persitencia.IMakerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MakerDaoImpl implements IMakerDao {
    private MakerRepositorie makerRepositorie;
    @Autowired
    public MakerDaoImpl(MakerRepositorie makerRepositorie) {
        this.makerRepositorie = makerRepositorie;
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepositorie.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return ((List<Maker>) makerRepositorie.findAll());
    }

    @Override
    public Optional<Maker> findByRuc(String ruc) {
        return makerRepositorie.findByRuc(ruc);
    }

    @Override
    public Boolean existsByRuc(String ruc) {
        return makerRepositorie.existsByRuc(ruc);
    }


    @Override
    public void save(Maker maker) {
        makerRepositorie.save(maker);
    }

    @Override
    public void deleteByid(Long id) {
        makerRepositorie.deleteById(id);
    }
}
