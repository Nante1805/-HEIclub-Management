package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.UtiliseService;
import com.HEIclub.demo.a_model.Utilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilise")
public class UtiliseController {
    @Autowired
    private UtiliseService utiliseService;

    @PostMapping
    public Utilise addUtilise(@RequestBody Utilise utilise) {
        return utiliseService.insert(utilise);
    }

    @DeleteMapping("/{idClub}/{idSalle}")
    public ResponseEntity<String> deleteUtilise(@PathVariable int idClub, @PathVariable int idSalle) {
        try {
            utiliseService.delete(idClub, idSalle);
            return ResponseEntity.ok("Utilise relationship deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
