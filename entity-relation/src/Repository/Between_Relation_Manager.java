package Repository;

import model.Between_relation;

import java.sql.*;
import java.util.ArrayList;

public class Between_Relation_Manager implements Repos<Between_relation> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public Between_Relation_Manager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Between_relation> getAll() {
        ArrayList<Between_relation> between_relations = new ArrayList<>();

        String query = "SELECT id_be as id, name_be as name, power_be as power, id_e_left as left, id_e_right as right, id_m as model " +
                       "FROM between_entity;";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Between_relation between_relation;
            while(rs.next()) {
                between_relation = new Between_relation(rs.getInt("id"),
                                                        rs.getString("name"),
                                                        rs.getString("power"),
                                                        rs.getInt("left"),
                                                        rs.getInt("right"),
                                                        rs.getInt("model"));
                between_relations.add(between_relation);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return between_relations;
    }

    @Override
    public Between_relation getByKey(String key, String where) {
        Between_relation between_relation = null;

        String query = "";

        try {

            PreparedStatement preparedStatement;

            if (where == "byId") {
                int id = Integer.parseInt(key);
                query = "SELECT id_be as id, name_be as name, power_be as power, id_e_left as left, id_e_right as right, id_m as model " +
                        "FROM between_entity " +
                        "WHERE id_be=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
            }
            else { // if (where == "byName")
                query = "SELECT id_be as id, name_be as name, power_be as power, id_e_left as left, id_e_right as right, id_m as model " +
                        "FROM between_entity " +
                        "WHERE name_be=? " +
                        "ORDER BY id_be DESC " +
                        "LIMIT 1;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, key);
            }


            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            between_relation = new Between_relation(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getString("power"),
                                                    rs.getInt("left"),
                                                    rs.getInt("right"),
                                                    rs.getInt("model"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return between_relation;
    }

    @Override
    public void add_node(Between_relation node) {
        String query = "INSERT INTO between_entity (id_be, name_be, power_be, id_e_left, id_e_right, id_m) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, node.getId_BE());
            preparedStatement.setString(2, node.getName_BE());
            preparedStatement.setString(3, node.getPower_BE());
            preparedStatement.setInt(4, node.getId_E_left());
            preparedStatement.setInt(5, node.getId_E_right());
            preparedStatement.setInt(6, node.getId_M());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_node(String key) {
        String query = "DELETE FROM between_entity " +
                       "WHERE id_be=?";

        try {
            int id = Integer.parseInt(key);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String key, Between_relation new_node) {
        String query = "UPDATE between_entity " +
                       "SET id_be=?, name_be=?, power_be=?, id_e_left=?, id_e_right=?, id_m=? " +
                       "WHERE id_be=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, new_node.getId_BE());
            preparedStatement.setString(2, new_node.getName_BE());
            preparedStatement.setString(3, new_node.getPower_BE());
            preparedStatement.setInt(4, new_node.getId_E_left());
            preparedStatement.setInt(5, new_node.getId_E_right());
            preparedStatement.setInt(6, new_node.getId_M());
            preparedStatement.setString(7, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Integer max_id() {
        String query = "SELECT MAX(id_be) as max_id FROM between_entity LIMIT 1;";
        Integer max = 0;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();

            max = rs.getInt("max_id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (max == null) {
            max = 0;
        }

        return max;
    }
}
