package com.example.prueba_.controllers;

import com.example.prueba_.entities.Commerce;
import com.example.prueba_.services.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prueba/commerce")
public class CommerceController {

    @Autowired
    private CommerceService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Commerce commerce) {
        return new ResponseEntity<>(service.save(commerce), HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("find/{date}/{productId}/{brandId}")
    public ResponseEntity<?> find(@PathVariable String date, @PathVariable int productId, @PathVariable int brandId) {
        return ResponseEntity.ok(service.findByStartDateAndProductIdAndBrandId(date,productId,brandId));
    }

    @GetMapping("findString/{date}/{productId}/{brandId}")
    public ResponseEntity<?> findString(@PathVariable String date, @PathVariable int productId, @PathVariable int brandId) {
        Commerce commerce = service.findByStartDateAndProductIdAndBrandId(date,productId,brandId);
        if(commerce!=null && commerce.getBrandId()!=null){
            return ResponseEntity.ok(commerce.getResponString());
        }
            return ResponseEntity.ok("No hay registros");

    }
}
