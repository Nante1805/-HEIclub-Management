package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Utilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UtiliseDAO {
    @Autowired
    private Connection connection;

    public void insert(Utilise toAdd) throws SQLException {
        String sql = "INSERT INTO utilise (id_club, id_salle) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toAdd.getIdClub());
            preparedStatement.setInt(2, toAdd.getIdSalle());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int idClub, int idSalle) throws SQLException {
        String sql = "DELETE FROM utilise WHERE id_club = ? AND id_salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idClub);
            preparedStatement.setInt(2, idSalle);
            preparedStatement.executeUpdate();
        }
    }
}
