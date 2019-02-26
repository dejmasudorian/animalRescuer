package org.fasttrackit.persistence;

import org.fasttrackit.Animal;
import org.fasttrackit.Recess;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalRepository {
    public void  createAnimalTable(Animal animalTable) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = DatabaseConfiguration.getConnection();
        String insertSql = "INSERT INTO animal_table (`name`, age, health, spirit, `fav_food`, `recess`) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1,animalTable.getName());
        preparedStatement.setInt(2, animalTable.getAge());
        preparedStatement.setInt(3, animalTable.getTableHealth());
        preparedStatement.setInt(4,animalTable.getTableSpirit());
        preparedStatement.setString(5,animalTable.getFav_food());
        preparedStatement.setString(6,animalTable.getRecess().getName());

        preparedStatement.executeUpdate();
    }

    public List<Animal> getAnimalTable() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DatabaseConfiguration.getConnection();
        String query = "SELECT * FROM animal_table;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Animal> response = new ArrayList<>();

        while (resultSet.next()) {
            Animal animalTable = new Animal();
            animalTable.setId(resultSet.getLong("id"));
            animalTable.setName(resultSet.getString("name"));
            animalTable.setAge(resultSet.getInt("age"));
            animalTable.setTableHealth(resultSet.getInt("health"));
            animalTable.setTableSpirit(resultSet.getInt("spirit"));
            animalTable.setFav_food(resultSet.getString("fav_food"));
            Recess recess = new Recess();
            animalTable.setRecess(recess);
            animalTable.getRecess().setName(resultSet.getString("recess"));

            response.add(animalTable);

        }
        return response;
    }

    public void updateAnimalTable(Animal animalTable) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DatabaseConfiguration.getConnection();
        String insertSql = "UPDATE animal_table SET `name` = ? , age = ?, health = ?, spirit = ?, `fav_food`=?, `recess`=?" +
                "WHERE  id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1,animalTable.getName());
        preparedStatement.setInt(2, animalTable.getAge());
        preparedStatement.setInt(3, animalTable.getTableHealth());
        preparedStatement.setInt(4,animalTable.getTableSpirit());
        preparedStatement.setString(5,animalTable.getFav_food());
        preparedStatement.setString(6,animalTable.getRecess().getName());
        preparedStatement.setLong(7, animalTable.getId());
        preparedStatement.executeUpdate();
    }
}
