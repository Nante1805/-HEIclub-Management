package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.EtudiantDAO;
import com.HEIclub.demo.a_model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantDAO etudiantDAO;

    public Etudiant insert(Etudiant toAdd) {
        try {
            this.etudiantDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Etudiant> findAll() {
        try {
            return this.etudiantDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Etudiant getById(int etudiantId) {
        try {
            return this.etudiantDAO.getById(etudiantId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Etudiant update(int etudiantId, Etudiant updatedEtudiant) {
        try {
            Etudiant existingEtudiant = this.etudiantDAO.getById(etudiantId);

            if (updatedEtudiant.getNom() != null) {
                existingEtudiant.setNom(updatedEtudiant.getNom());
            }
            if (updatedEtudiant.getPrenom() != null) {
                existingEtudiant.setPrenom(updatedEtudiant.getPrenom());
            }

            this.etudiantDAO.update(existingEtudiant);

            return existingEtudiant;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int etudiantId) {
        try {
            this.etudiantDAO.delete(etudiantId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}