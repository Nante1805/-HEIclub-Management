package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Requiert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class RequiertDAO {
    @Autowired
    private Connection connection;

    public void insert(Requiert toAdd) throws SQLException {
        String sql = "INSERT INTO requiert (id_evenement, id_materiel) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toAdd.getIdEvenement());
            preparedStatement.setInt(2, toAdd.getIdMateriel());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int idEvenement, int idMateriel) throws SQLException {
        String sql = "DELETE FROM requiert WHERE id_evenement = ? AND id_materiel = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idEvenement);
            preparedStatement.setInt(2, idMateriel);
            preparedStatement.executeUpdate();
        }
    }
}
