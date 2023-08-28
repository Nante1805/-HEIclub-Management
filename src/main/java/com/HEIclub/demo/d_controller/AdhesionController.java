package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.AdhesionService;
import com.HEIclub.demo.a_model.Adhesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adhesions")
public class AdhesionController {
    @Autowired
    private AdhesionService adhesionService;

    @PostMapping
    public Adhesion addAdhesion(@RequestBody Adhesion adhesion) {
        return adhesionService.insert(adhesion);
    }

    @GetMapping
    public List<Adhesion> getAllAdhesions() {
        return adhesionService.findAll();
    }

    @GetMapping("/{adhesionId}")
    public Adhesion getAdhesionById(@PathVariable int adhesionId) {
        return adhesionService.getById(adhesionId);
    }

    @PutMapping("/{adhesionId}")
    public ResponseEntity<String> updateAdhesion(@PathVariable int adhesionId, @RequestBody Adhesion updatedAdhesion) {
        try {
            return ResponseEntity.ok("Adhesion " + adhesionId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{adhesionId}")
    public ResponseEntity<String> deleteAdhesion(@PathVariable int adhesionId) {
        try {
            adhesionService.delete(adhesionId);
            return ResponseEntity.ok("Adhesion " + adhesionId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
