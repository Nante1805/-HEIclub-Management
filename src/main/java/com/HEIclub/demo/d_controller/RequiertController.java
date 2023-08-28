package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.RequiertService;
import com.HEIclub.demo.a_model.Requiert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requiert")
public class RequiertController {
    @Autowired
    private RequiertService requiertService;

    @PostMapping
    public Requiert addRequiert(@RequestBody Requiert requiert) {
        return requiertService.insert(requiert);
    }

    @DeleteMapping("/{idEvenement}/{idMateriel}")
    public ResponseEntity<String> deleteRequiert(@PathVariable int idEvenement, @PathVariable int idMateriel) {
        try {
            requiertService.delete(idEvenement, idMateriel);
            return ResponseEntity.ok("Requiert deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
