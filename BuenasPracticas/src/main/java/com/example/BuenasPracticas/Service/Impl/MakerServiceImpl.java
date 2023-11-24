package com.example.BuenasPracticas.Service.Impl;

import com.example.BuenasPracticas.Service.IMakerService;
import com.example.BuenasPracticas.entitys.Maker;
import com.example.BuenasPracticas.entitys.Product;
import com.example.BuenasPracticas.persitencia.IMakerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MakerServiceImpl implements IMakerService {

    private final IMakerDao makerDao;
    @Autowired
    public MakerServiceImpl(IMakerDao makerDao) {
        this.makerDao = makerDao;
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public Optional<Maker> findByRuc(String ruc) {
        return makerDao.findByRuc(ruc);
    }

    @Override
    public Boolean existsByRuc(String ruc) {
        return makerDao.existsByRuc(ruc);
    }


    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteByid(Long id) {
        makerDao.deleteByid(id);
    }
}
