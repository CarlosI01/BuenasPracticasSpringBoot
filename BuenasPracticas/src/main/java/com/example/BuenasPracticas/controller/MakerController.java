package com.example.BuenasPracticas.controller;

import com.example.BuenasPracticas.Service.IMakerService;
import com.example.BuenasPracticas.controller.dto.MakerDTO;
import com.example.BuenasPracticas.entitys.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    private IMakerService makerService;
    @Autowired
    public MakerController(IMakerService makerService) {
        this.makerService = makerService;
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional= makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker= makerOptional.get();
            MakerDTO makerDTO= MakerDTO.builder()
                    .id(maker.getId())
                    .nombre(maker.getNombre())
                    .product(maker.getProduct())
                    .ruc(maker.getRuc()).build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MakerDTO> makerDTOList= makerService.findAll()
                .stream().map(maker-> MakerDTO.builder()
                        .id(maker.getId())
                        .nombre(maker.getNombre())
                        .product(maker.getProduct())
                        .ruc(maker.getRuc())
                        .build())
                        .toList();
        return ResponseEntity.ok(makerDTOList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
       boolean exit= makerService.existsByRuc(makerDTO.getRuc());
        if(makerDTO.getNombre().isBlank() || exit){
            return ResponseEntity.badRequest().body("nooooo");
        }

        makerService.save(Maker.builder().nombre(makerDTO.getNombre())
                .ruc(makerDTO.getRuc()).build());
        return ResponseEntity.created(new URI( "/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody MakerDTO makerDTO, @PathVariable Long id){
        Optional<Maker> makerOptional= makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker= makerOptional.get();

            maker.setNombre(makerDTO.getNombre());
            makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(id != null){
            makerService.deleteByid(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findByRuc/{ruc}")
    public ResponseEntity<?> findByRuc(@PathVariable String ruc){
        Optional<Maker> makerOptiona= makerService.findByRuc(ruc);
        if(makerOptiona.isPresent()){
            Maker maker= makerOptiona.get();
            MakerDTO makerDTO= MakerDTO.builder()
                    .ruc(maker.getRuc()).build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/exists/{ruc}")
    public ResponseEntity<?> checkRucExistence(@PathVariable String ruc) {
        Boolean exists = makerService.existsByRuc(ruc);

        if (exists) {
            return ResponseEntity.ok("El RUC ya existe en la base de datos.");
        } else {
            return ResponseEntity.ok("El RUC no existe en la base de datos.");
        }
    }

}
