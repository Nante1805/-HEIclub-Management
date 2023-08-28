package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EvenementDAO {
    @Autowired
    private Connection connection;

    public void insert(Evenement toAdd) throws SQLException {
        String sql = "INSERT INTO evenement (nom, date, id_club) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getNom());
            preparedStatement.setDate(2, toAdd.getDate());
            preparedStatement.setInt(3, toAdd.getIdClub());
            preparedStatement.executeUpdate();
        }
    }

    public List<Evenement> findAll() throws SQLException {
        String sql = "SELECT * FROM evenement";

        List<Evenement> allEvenements = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allEvenements.add(new Evenement(
                        result.getInt("id"),
                        result.getString("nom"),
                        result.getDate("date"),
                        result.getInt("id_club")));
            }
        }

        return allEvenements;
    }

    public Evenement getById(int evenementId) throws SQLException {
        String sql = "SELECT * FROM evenement WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, evenementId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Evenement(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getDate("date"),
                            result.getInt("id_club"));
                }
                return null;
            }
        }
    }

    public void update(Evenement updatedEvenement) throws SQLException {
        String sql = "UPDATE evenement SET nom = ?, date = ?, id_club = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedEvenement.getNom());
            preparedStatement.setDate(2, updatedEvenement.getDate());
            preparedStatement.setInt(3, updatedEvenement.getIdClub());
            preparedStatement.setInt(4, updatedEvenement.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int evenementId) throws SQLException {
        String sql = "DELETE FROM evenement WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, evenementId);
            preparedStatement.executeUpdate();
        }
    }
}
