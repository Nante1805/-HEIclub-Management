package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.SalleDAO;
import com.HEIclub.demo.a_model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SalleService {
    @Autowired
    private SalleDAO salleDAO;

    public Salle insert(Salle toAdd) {
        try {
            this.salleDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Salle> findAll() {
        try {
            return this.salleDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Salle getById(int salleId) {
        try {
            return this.salleDAO.getById(salleId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Salle update(int salleId, Salle updatedSalle) {
        try {
            Salle existingSalle = this.salleDAO.getById(salleId);

            if (updatedSalle.getNom() != null) {
                existingSalle.setNom(updatedSalle.getNom());
            }
            if (updatedSalle.getCapacite() != 0) {
                existingSalle.setCapacite(updatedSalle.getCapacite());
            }

            this.salleDAO.update(existingSalle);

            return existingSalle;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int salleId) {
        try {
            this.salleDAO.delete(salleId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
