package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.AppartientDAO;
import com.HEIclub.demo.a_model.Appartient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AppartientService {
    @Autowired
    private AppartientDAO appartientDAO;

    public Appartient insert(Appartient toAdd) {
        try {
            this.appartientDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Appartient> findAll() {
        try {
            return this.appartientDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Appartient getById(int appartientId) {
        try {
            return this.appartientDAO.getById(appartientId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Appartient update(int appartientId, Appartient updatedAppartient) {
        try {
            Appartient existingAppartient = this.appartientDAO.getById(appartientId);

            if (updatedAppartient.getIdClub() != 0) {
                existingAppartient.setIdClub(updatedAppartient.getIdClub());
            }
            if (updatedAppartient.getIdEtudiant() != 0) {
                existingAppartient.setIdEtudiant(updatedAppartient.getIdEtudiant());
            }

            this.appartientDAO.update(existingAppartient);

            return existingAppartient;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int appartientId) {
        try {
            this.appartientDAO.delete(appartientId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
