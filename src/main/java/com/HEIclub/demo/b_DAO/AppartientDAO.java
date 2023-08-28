package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Appartient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppartientDAO {
    @Autowired
    private Connection connection;

    public void insert(Appartient toAdd) throws SQLException {
        String sql = "INSERT INTO appartient (id_club, id_etudiant) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toAdd.getIdClub());
            preparedStatement.setInt(2, toAdd.getIdEtudiant());
            preparedStatement.executeUpdate();
        }
    }

    public List<Appartient> findAll() throws SQLException {
        String sql = "SELECT * FROM appartient";

        List<Appartient> allAppartients = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allAppartients.add(new Appartient(
                        result.getInt("id"),
                        result.getInt("id_club"),
                        result.getInt("id_etudiant")));
            }
        }

        return allAppartients;
    }

    public Appartient getById(int appartientId) throws SQLException {
        String sql = "SELECT * FROM appartient WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, appartientId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Appartient(
                            result.getInt("id"),
                            result.getInt("id_club"),
                            result.getInt("id_etudiant"));
                }
                return null;
            }
        }
    }

    public void update(Appartient updatedAppartient) throws SQLException {
        String sql = "UPDATE appartient SET id_club = ?, id_etudiant = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, updatedAppartient.getIdClub());
            preparedStatement.setInt(2, updatedAppartient.getIdEtudiant());
            preparedStatement.setInt(3, updatedAppartient.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int appartientId) throws SQLException {
        String sql = "DELETE FROM appartient WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, appartientId);
            preparedStatement.executeUpdate();
        }
    }
}
