package Repository;

import model.Between_relation;
import model.Entity;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class Between_RelationDAO implements Repos<Between_relation> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/card_game";

    private static Connection connection;

    public Between_RelationDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Between_relation> getAll() {
        ArrayList<Between_relation> between_relations = new ArrayList<>();

        String query = "SELECT ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Between_relation between_relation;
            while(rs.next()) {
                between_relation = new Between_relation(rs.getLong(""),rs.getString("") , rs.getString(""), rs.getLong(""), rs.getLong(""));
                between_relations.add(between_relation);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return between_relations;
    }

    @Override
    public Between_relation getByKey(String key) {
        Between_relation between_relation = null;
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            between_relation = new Between_relation(rs.getLong(""),rs.getString("") , rs.getString(""), rs.getLong(""), rs.getLong(""));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return between_relation;
    }

    @Override
    public void add_node(Between_relation node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, node.getId_BE());
            preparedStatement.setString(2, node.getName_BE());
            preparedStatement.setString(3, node.getPower_BE());
            preparedStatement.setLong(4, node.getId_E_left());
            preparedStatement.setLong(5, node.getId_E_right());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_node(String key) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String key, Between_relation new_node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, new_node.getId_BE());
            preparedStatement.setString(2, new_node.getName_BE());
            preparedStatement.setString(3, new_node.getPower_BE());
            preparedStatement.setLong(4, new_node.getId_E_left());
            preparedStatement.setLong(5, new_node.getId_E_right());
            preparedStatement.setString(6, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
