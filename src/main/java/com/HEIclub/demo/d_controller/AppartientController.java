package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.AppartientService;
import com.HEIclub.demo.a_model.Appartient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appartients")
public class AppartientController {
    @Autowired
    private AppartientService appartientService;

    @PostMapping
    public Appartient addAppartient(@RequestBody Appartient appartient) {
        return appartientService.insert(appartient);
    }

    @GetMapping
    public List<Appartient> getAllAppartients() {
        return appartientService.findAll();
    }

    @GetMapping("/{appartientId}")
    public Appartient getAppartientById(@PathVariable int appartientId) {
        return appartientService.getById(appartientId);
    }

    @PutMapping("/{appartientId}")
    public ResponseEntity<String> updateAppartient(@PathVariable int appartientId, @RequestBody Appartient updatedAppartient) {
        try {
            return ResponseEntity.ok("Appartient " + appartientId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{appartientId}")
    public ResponseEntity<String> deleteAppartient(@PathVariable int appartientId) {
        try {
            appartientService.delete(appartientId);
            return ResponseEntity.ok("Appartient " + appartientId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
