package dao;

import datasource.DatabaseConnection;
import entity.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public Currency getCurrency(String abbreviation) throws SQLException {
        String query = "SELECT abbreviation, name, rate FROM currency WHERE abbreviation = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, abbreviation);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    double rate = resultSet.getDouble("rate");
                    return new Currency(abbreviation, name, rate);
                }
            }
        }
        return null; // Currency not found
    }

    public List<String> getAllCurrencyAbbreviations() throws SQLException {
        List<String> abbreviations = new ArrayList<>();
        String query = "SELECT abbreviation FROM currency ORDER BY abbreviation";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                abbreviations.add(resultSet.getString("abbreviation"));
            }
        }
        return abbreviations;
    }
}