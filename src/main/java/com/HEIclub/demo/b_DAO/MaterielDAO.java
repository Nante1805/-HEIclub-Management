package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MaterielDAO {
    @Autowired
    private Connection connection;

    public void insert(Materiel toAdd) throws SQLException {
        String sql = "INSERT INTO materiel (nom) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getNom());
            preparedStatement.executeUpdate();
        }
    }

    public List<Materiel> findAll() throws SQLException {
        String sql = "SELECT * FROM materiel";

        List<Materiel> allMateriels = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allMateriels.add(new Materiel(
                        result.getInt("id"),
                        result.getString("nom")));
            }
        }

        return allMateriels;
    }

    public Materiel getById(int materielId) throws SQLException {
        String sql = "SELECT * FROM materiel WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, materielId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Materiel(
                            result.getInt("id"),
                            result.getString("nom"));
                }
                return null;
            }
        }
    }

    public void update(Materiel updatedMateriel) throws SQLException {
        String sql = "UPDATE materiel SET nom = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedMateriel.getNom());
            preparedStatement.setInt(2, updatedMateriel.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int materielId) throws SQLException {
        String sql = "DELETE FROM materiel WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, materielId);
            preparedStatement.executeUpdate();
        }
    }
}
