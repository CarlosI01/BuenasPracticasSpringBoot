package com.example.BuenasPracticas.persitencia;

import com.example.BuenasPracticas.entitys.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDao {
    public Optional<Maker> findById(Long id);
    public List<Maker> findAll();

    public Optional<Maker> findByRuc(String ruc);

    Boolean existsByRuc(String ruc);


    public void save (Maker maker);

//    public Maker update(Maker maker, Long id);

    public void deleteByid(Long id);


}
