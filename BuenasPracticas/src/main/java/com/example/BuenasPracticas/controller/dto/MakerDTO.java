package com.example.BuenasPracticas.controller.dto;
import com.example.BuenasPracticas.entitys.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;
    private String nombre;
    private String ruc;

    private List<Product> product= new ArrayList<>();
}

