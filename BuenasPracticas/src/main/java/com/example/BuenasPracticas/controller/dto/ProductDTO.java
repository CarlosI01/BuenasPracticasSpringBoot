package com.example.BuenasPracticas.controller.dto;

import com.example.BuenasPracticas.entitys.Maker;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String nombres;
    private BigDecimal price;
    private Maker maker;

}
