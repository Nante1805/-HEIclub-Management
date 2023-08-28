package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.ClubDAO;
import com.HEIclub.demo.a_model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubDAO clubDAO;

    public Club insert(Club toAdd) {
        try {
            this.clubDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Club> findAll() {
        try {
            return this.clubDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Club getById(int clubId) {
        try {
            return this.clubDAO.getById(clubId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Club update(int clubId, Club updatedClub) {
        try {
            Club existingClub = this.clubDAO.getById(clubId);

            if (updatedClub.getNom() != null) {
                existingClub.setNom(updatedClub.getNom());
            }
            if (updatedClub.getPresident() != null) {
                existingClub.setPresident(updatedClub.getPresident());
            }

            this.clubDAO.update(existingClub);

            return existingClub;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int clubId) {
        try {
            this.clubDAO.delete(clubId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
