package com.example.BuenasPracticas.Service;

import com.example.BuenasPracticas.entitys.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    public Optional<Maker> findById(Long id);
    public List<Maker> findAll();

    public Optional<Maker> findByRuc(String ruc);

    Boolean existsByRuc(String ruc);

    public void save (Maker maker);

    public void deleteByid(Long id);

}
