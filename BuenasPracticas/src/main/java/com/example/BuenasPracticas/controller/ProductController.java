package com.example.BuenasPracticas.controller;
import com.example.BuenasPracticas.Service.IProductService;
import com.example.BuenasPracticas.controller.dto.ProductDTO;
import com.example.BuenasPracticas.entitys.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()){
            Product product= productOptional.get();
            ProductDTO productDTO= ProductDTO.builder()
                    .id(product.getId())
                    .nombres(product.getNombres())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOList = productService.findAll()
                .stream().map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .nombres(product.getNombres())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/findByPrice/{min}/{max}")
    public ResponseEntity<?> findByPrice(@PathVariable BigDecimal min, @PathVariable BigDecimal max){
        List<ProductDTO> productDTOList= productService.findByPriceInRange(min, max)
                .stream().map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .nombres(product.getNombres())
                        .price(product.getPrice())
                        .maker(product.getMaker()).build())
                .toList();
        return  ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        if(productDTO.getNombres().isBlank() || productDTO.getPrice() == null || productDTO.getMaker()==null){
            return ResponseEntity.badRequest().build();
        }
        productService.save(Product.builder()
                .nombres(productDTO.getNombres())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        Optional<Product> optionalProduct= productService.findById(id);
        if(optionalProduct.isPresent()){

            Product product= optionalProduct.get();
            product.setNombres(productDTO.getNombres());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            productService.save(product);

            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id != null){
            productService.deleteByid(id);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }



}
