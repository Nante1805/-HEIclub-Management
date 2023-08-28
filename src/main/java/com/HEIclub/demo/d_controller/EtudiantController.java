package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.EtudiantService;
import com.HEIclub.demo.a_model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.insert(etudiant);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.findAll();
    }

    @GetMapping("/{etudiantId}")
    public Etudiant getEtudiantById(@PathVariable int etudiantId) {
        return etudiantService.getById(etudiantId);
    }

    @PutMapping("/{etudiantId}")
    public ResponseEntity<String> updateEtudiant(@PathVariable int etudiantId, @RequestBody Etudiant updatedEtudiant) {
        try {
            return ResponseEntity.ok("Etudiant " + etudiantId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{etudiantId}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable int etudiantId) {
        try {
            etudiantService.delete(etudiantId);
            return ResponseEntity.ok("Etudiant " + etudiantId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
