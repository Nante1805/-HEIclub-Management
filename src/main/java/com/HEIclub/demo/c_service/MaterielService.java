package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.MaterielDAO;
import com.HEIclub.demo.a_model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MaterielService {
    @Autowired
    private MaterielDAO materielDAO;

    public Materiel insert(Materiel toAdd) {
        try {
            this.materielDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Materiel> findAll() {
        try {
            return this.materielDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Materiel getById(int materielId) {
        try {
            return this.materielDAO.getById(materielId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Materiel update(int materielId, Materiel updatedMateriel) {
        try {
            Materiel existingMateriel = this.materielDAO.getById(materielId);

            if (updatedMateriel.getNom() != null) {
                existingMateriel.setNom(updatedMateriel.getNom());
            }

            this.materielDAO.update(existingMateriel);

            return existingMateriel;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int materielId) {
        try {
            this.materielDAO.delete(materielId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
