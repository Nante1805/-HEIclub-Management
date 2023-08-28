package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.AdhesionDAO;
import com.HEIclub.demo.a_model.Adhesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdhesionService {
    @Autowired
    private AdhesionDAO adhesionDAO;

    public Adhesion insert(Adhesion toAdd) {
        try {
            this.adhesionDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Adhesion> findAll() {
        try {
            return this.adhesionDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Adhesion getById(int adhesionId) {
        try {
            return this.adhesionDAO.getById(adhesionId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Adhesion update(int adhesionId, Adhesion updatedAdhesion) {
        try {
            Adhesion existingAdhesion = this.adhesionDAO.getById(adhesionId);

            if (updatedAdhesion.getDate() != null) {
                existingAdhesion.setDate(updatedAdhesion.getDate());
            }
            if (updatedAdhesion.getIdEtudiant() != 0) {
                existingAdhesion.setIdEtudiant(updatedAdhesion.getIdEtudiant());
            }

            this.adhesionDAO.update(existingAdhesion);

            return existingAdhesion;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int adhesionId) {
        try {
            this.adhesionDAO.delete(adhesionId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
