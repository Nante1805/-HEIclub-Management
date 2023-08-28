package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalleDAO {
    @Autowired
    private Connection connection;

    public void insert(Salle toAdd) throws SQLException {
        String sql = "INSERT INTO salle (nom, capacite) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getNom());
            preparedStatement.setInt(2, toAdd.getCapacite());
            preparedStatement.executeUpdate();
        }
    }

    public List<Salle> findAll() throws SQLException {
        String sql = "SELECT * FROM salle";

        List<Salle> allSalles = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allSalles.add(new Salle(
                        result.getInt("id"),
                        result.getString("nom"),
                        result.getInt("capacite")));
            }
        }

        return allSalles;
    }

    public Salle getById(int salleId) throws SQLException {
        String sql = "SELECT * FROM salle WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, salleId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Salle(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getInt("capacite"));
                }
                return null;
            }
        }
    }

    public void update(Salle updatedSalle) throws SQLException {
        String sql = "UPDATE salle SET nom = ?, capacite = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedSalle.getNom());
            preparedStatement.setInt(2, updatedSalle.getCapacite());
            preparedStatement.setInt(3, updatedSalle.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int salleId) throws SQLException {
        String sql = "DELETE FROM salle WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, salleId);
            preparedStatement.executeUpdate();
        }
    }
}
