package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.MaterielService;
import com.HEIclub.demo.a_model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiels")
public class MaterielController {
    @Autowired
    private MaterielService materielService;

    @PostMapping
    public Materiel addMateriel(@RequestBody Materiel materiel) {
        return materielService.insert(materiel);
    }

    @GetMapping
    public List<Materiel> getAllMateriels() {
        return materielService.findAll();
    }

    @GetMapping("/{materielId}")
    public Materiel getMaterielById(@PathVariable int materielId) {
        return materielService.getById(materielId);
    }

    @PutMapping("/{materielId}")
    public ResponseEntity<String> updateMateriel(@PathVariable int materielId, @RequestBody Materiel updatedMateriel) {
        try {
            return ResponseEntity.ok("Materiel " + materielId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{materielId}")
    public ResponseEntity<String> deleteMateriel(@PathVariable int materielId) {
        try {
            materielService.delete(materielId);
            return ResponseEntity.ok("Materiel " + materielId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
