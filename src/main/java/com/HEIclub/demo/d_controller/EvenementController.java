package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.EvenementService;
import com.HEIclub.demo.a_model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    @PostMapping
    public Evenement addEvenement(@RequestBody Evenement evenement) {
        return evenementService.insert(evenement);
    }

    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementService.findAll();
    }

    @GetMapping("/{evenementId}")
    public Evenement getEvenementById(@PathVariable int evenementId) {
        return evenementService.getById(evenementId);
    }

    @PutMapping("/{evenementId}")
    public ResponseEntity<String> updateEvenement(@PathVariable int evenementId, @RequestBody Evenement updatedEvenement) {
        try {
            return ResponseEntity.ok("Evenement " + evenementId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{evenementId}")
    public ResponseEntity<String> deleteEvenement(@PathVariable int evenementId) {
        try {
            evenementService.delete(evenementId);
            return ResponseEntity.ok("Evenement " + evenementId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
