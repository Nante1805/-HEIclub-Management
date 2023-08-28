package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Adhesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdhesionDAO {
    @Autowired
    private Connection connection;

    public void insert(Adhesion toAdd) throws SQLException {
        String sql = "INSERT INTO adhesion (date, id_etudiant) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, toAdd.getDate());
            preparedStatement.setInt(2, toAdd.getIdEtudiant());
            preparedStatement.executeUpdate();
        }
    }

    public List<Adhesion> findAll() throws SQLException {
        String sql = "SELECT * FROM adhesion";

        List<Adhesion> allAdhesions = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allAdhesions.add(new Adhesion(
                        result.getInt("id"),
                        result.getDate("date"),
                        result.getInt("id_etudiant")));
            }
        }

        return allAdhesions;
    }

    public Adhesion getById(int adhesionId) throws SQLException {
        String sql = "SELECT * FROM adhesion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, adhesionId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Adhesion(
                            result.getInt("id"),
                            result.getDate("date"),
                            result.getInt("id_etudiant"));
                }
                return null;
            }
        }
    }

    public void update(Adhesion updatedAdhesion) throws SQLException {
        String sql = "UPDATE adhesion SET date = ?, id_etudiant = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, updatedAdhesion.getDate());
            preparedStatement.setInt(2, updatedAdhesion.getIdEtudiant());
            preparedStatement.setInt(3, updatedAdhesion.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int adhesionId) throws SQLException {
        String sql = "DELETE FROM adhesion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, adhesionId);
            preparedStatement.executeUpdate();
        }
    }
}
