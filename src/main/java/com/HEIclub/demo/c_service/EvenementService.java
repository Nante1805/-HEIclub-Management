package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.EvenementDAO;
import com.HEIclub.demo.a_model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EvenementService {
    @Autowired
    private EvenementDAO evenementDAO;

    public Evenement insert(Evenement toAdd) {
        try {
            this.evenementDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Evenement> findAll() {
        try {
            return this.evenementDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Evenement getById(int evenementId) {
        try {
            return this.evenementDAO.getById(evenementId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Evenement update(int evenementId, Evenement updatedEvenement) {
        try {
            Evenement existingEvenement = this.evenementDAO.getById(evenementId);

            if (updatedEvenement.getNom() != null) {
                existingEvenement.setNom(updatedEvenement.getNom());
            }
            if (updatedEvenement.getDate() != null) {
                existingEvenement.setDate(updatedEvenement.getDate());
            }
            if (updatedEvenement.getIdClub() != 0) {
                existingEvenement.setIdClub(updatedEvenement.getIdClub());
            }

            this.evenementDAO.update(existingEvenement);

            return existingEvenement;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int evenementId) {
        try {
            this.evenementDAO.delete(evenementId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
