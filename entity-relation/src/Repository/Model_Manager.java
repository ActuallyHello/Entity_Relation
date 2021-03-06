package Repository;

import model.Model;

import java.sql.*;
import java.util.ArrayList;

public class Model_Manager implements Repos<Model> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public Model_Manager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Model> getAll() {
        ArrayList<Model> modelList = new ArrayList<>();

        String query = "SELECT id_m as id, name_m as name, id_s as id_student " +
                       "FROM model;";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Model model;
            while(rs.next()) {
                model = new Model(rs.getInt("id"),
                                  rs.getString("name"),
                                  rs.getString("id_student"));
                modelList.add(model);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return modelList;
    }

    @Override
    public Model getByKey(String key, String where) {
        Model model = null;

        String query = "";

        try {

            PreparedStatement preparedStatement;

            if (where == "byId") {
                int id = Integer.parseInt(key);
                query = "SELECT id_m as id, name_m as name, id_s as id_student " +
                        "FROM model " +
                        "WHERE id_m=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
            }
            else { // if (where == "byName")
                query = "SELECT id_m as id, name_m as name, id_s as id_student " +
                        "FROM model " +
                        "WHERE name_m=? " +
                        "ORDER BY id_m DESC " +
                        "LIMIT 1;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, key);
            }


            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            model = new Model(rs.getInt("id"),
                              rs.getString("name"),
                              rs.getString("id_student"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return model;
    }

    @Override
    public void add_node(Model node) {
        String query = "INSERT INTO model (id_m, name_m, id_s) VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, node.getId_M());
            preparedStatement.setString(2, node.getName_M());
            preparedStatement.setString(3, node.getId_S());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_node(String key) {
        String query = "DELETE FROM model " +
                       "WHERE id_m=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String key, Model new_node) {
        String query = "UPDATE model " +
                       "SET id_m=?, name_m=?, id_s=? " +
                       "WHERE id_m=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, new_node.getId_M());
            preparedStatement.setString(2, new_node.getName_M());
            preparedStatement.setString(3, new_node.getId_S());
            preparedStatement.setString(4, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Integer max_id() {
        String query = "SELECT MAX(id_m) as max_id FROM model LIMIT 1;";
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