package com.ob.ejercicio1.controller;

import com.ob.ejercicio1.entities.Laptop;
import com.ob.ejercicio1.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptop")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/laptop/{id}")
    public Optional<Laptop> findOneById(@PathVariable Long id){
        return laptopRepository.findById(id);
    }

    @PostMapping("/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if(laptop.getId() != null){
            return ResponseEntity.badRequest().build();

        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        if(laptop.getId() == null){
            return ResponseEntity.badRequest().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.badRequest().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("laptop")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}


