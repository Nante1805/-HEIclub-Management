package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.RequiertDAO;
import com.HEIclub.demo.a_model.Requiert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RequiertService {
    @Autowired
    private RequiertDAO requiertDAO;

    public Requiert insert(Requiert toAdd) {
        try {
            this.requiertDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int idEvenement, int idMateriel) {
        try {
            this.requiertDAO.delete(idEvenement, idMateriel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
