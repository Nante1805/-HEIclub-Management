package com.HEIclub.demo.d_controller;

import com.HEIclub.demo.c_service.ClubService;
import com.HEIclub.demo.a_model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @PostMapping
    public Club addClub(@RequestBody Club club) {
        return clubService.insert(club);
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.findAll();
    }

    @GetMapping("/{clubId}")
    public Club getClubById(@PathVariable int clubId) {
        return clubService.getById(clubId);
    }

    @PutMapping("/{clubId}")
    public ResponseEntity<String> updateClub(@PathVariable int clubId, @RequestBody Club updatedClub) {
        try {
            return ResponseEntity.ok("Club " + clubId + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{clubId}")
    public ResponseEntity<String> deleteClub(@PathVariable int clubId) {
        try {
            clubService.delete(clubId);
            return ResponseEntity.ok("Club " + clubId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
