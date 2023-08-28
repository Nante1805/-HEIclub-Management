package com.HEIclub.demo.b_DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.HEIclub.demo.a_model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;

public class EtudiantDAO {
    @Autowired
    private Connection connection;

    public void insert(Etudiant toAdd) throws SQLException {
        String sql = "INSERT INTO etudiant (nom, prenom) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getNom());
            preparedStatement.setString(2, toAdd.getPrenom());
            preparedStatement.executeUpdate();
        }
    }

    public List<Etudiant> findAll() throws SQLException {
        String sql = "SELECT * FROM etudiant";

        List<Etudiant> allEtudiants = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allEtudiants.add(new Etudiant(
                        result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom")));
            }
        }

        return allEtudiants;
    }

    public Etudiant getById(int etudiantId) throws SQLException {
        String sql = "SELECT * FROM etudiant WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, etudiantId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Etudiant(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getString("prenom"));
                }
                return null;
            }
        }
    }

    public void update(Etudiant updatedEtudiant) throws SQLException {
        String sql = "UPDATE etudiant SET nom = ?, prenom = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedEtudiant.getNom());
            preparedStatement.setString(2, updatedEtudiant.getPrenom());
            preparedStatement.setInt(3, updatedEtudiant.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int etudiantId) throws SQLException {
        String sql = "DELETE FROM etudiant WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, etudiantId);
            preparedStatement.executeUpdate();
        }
    }
}
