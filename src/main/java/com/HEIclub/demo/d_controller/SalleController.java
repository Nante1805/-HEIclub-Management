package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.SalleService;
import com.HEIclub.demo.a_model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;

    @PostMapping
    public Salle addSalle(@RequestBody Salle salle) {
        return salleService.insert(salle);
    }

    @GetMapping
    public List<Salle> getAllSalles() {
        return salleService.findAll();
    }

    @GetMapping("/{salleId}")
    public Salle getSalleById(@PathVariable int salleId) {
        return salleService.getById(salleId);
    }

    @PutMapping("/{salleId}")
    public ResponseEntity<String> updateSalle(@PathVariable int salleId, @RequestBody Salle updatedSalle) {
        try {
            return ResponseEntity.ok("Salle " + salleId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{salleId}")
    public ResponseEntity<String> deleteSalle(@PathVariable int salleId) {
        try {
            salleService.delete(salleId);
            return ResponseEntity.ok("Salle " + salleId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
