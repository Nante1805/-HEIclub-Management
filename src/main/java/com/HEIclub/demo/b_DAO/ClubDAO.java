package com.HEIclub.demo.b_DAO;

import com.HEIclub.demo.a_model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClubDAO {
    @Autowired
    private Connection connection;

    public void insert(Club toAdd) throws SQLException {
        String sql = "INSERT INTO club (nom, president) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toAdd.getNom());
            preparedStatement.setString(2, toAdd.getPresident());
            preparedStatement.executeUpdate();
        }
    }

    public List<Club> findAll() throws SQLException {
        String sql = "SELECT * FROM club";

        List<Club> allClubs = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                allClubs.add(new Club(
                        result.getInt("id"),
                        result.getString("nom"),
                        result.getString("president")));
            }
        }

        return allClubs;
    }

    public Club getById(int clubId) throws SQLException {
        String sql = "SELECT * FROM club WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clubId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    return new Club(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getString("president"));
                }
                return null;
            }
        }
    }

    public void update(Club updatedClub) throws SQLException {
        String sql = "UPDATE club SET nom = ?, president = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedClub.getNom());
            preparedStatement.setString(2, updatedClub.getPresident());
            preparedStatement.setInt(3, updatedClub.getId());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int clubId) throws SQLException {
        String sql = "DELETE FROM club WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clubId);
            preparedStatement.executeUpdate();
        }
    }
}
