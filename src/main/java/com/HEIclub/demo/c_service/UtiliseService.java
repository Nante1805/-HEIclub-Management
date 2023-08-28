package com.HEIclub.demo.c_service;

import com.HEIclub.demo.b_DAO.UtiliseDAO;
import com.HEIclub.demo.a_model.Utilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UtiliseService {
    @Autowired
    private UtiliseDAO utiliseDAO;

    public Utilise insert(Utilise toAdd) {
        try {
            this.utiliseDAO.insert(toAdd);
            return toAdd;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(int idClub, int idSalle) {
        try {
            this.utiliseDAO.delete(idClub, idSalle);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
