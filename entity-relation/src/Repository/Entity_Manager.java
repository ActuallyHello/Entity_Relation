package Repository;

import model.Between_relation;
import model.Entity;
import model.Model;

import java.sql.*;
import java.util.ArrayList;

public class Entity_Manager implements Repos<Entity> {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public Entity_Manager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> entityList = new ArrayList<>();

        String query = "SELECT id_e as id, name_e as name " +
                       "FROM entity;";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Entity entity;
            while(rs.next()) {
                entity = new Entity(rs.getInt("id"),
                                    rs.getString("name"));
                entityList.add(entity);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return entityList;
    }

    @Override
    public Entity getByKey(String key, String where) {
        Entity entity = null;

        String query = "";

        try {

            PreparedStatement preparedStatement;

            if (where == "byId") {
                int id = Integer.parseInt(key);
                query = "SELECT id_e as id, name_e as name " +
                        "FROM entity " +
                        "WHERE id_e=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
            }
            else { // if (where == "byName")
                query = "SELECT id_e as id, name_e as name " +
                        "FROM entity " +
                        "WHERE name_e=? " +
                        "ORDER BY id_e DESC " +
                        "LIMIT 1;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, key);
            }

            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                entity = new Entity(rs.getInt("id"),
                                    rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity;

    }

    @Override
    public void add_node(Entity node) {
        String query = "INSERT INTO entity (id_e, name_e) VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, node.getId_E());
            preparedStatement.setString(2, node.getName_E());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_node(String key) {
        String query = "DELETE FROM entity " +
                       "WHERE id_e=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String key, Entity new_node) {
        String query = "UPDATE entity " +
                       "SET id_e=?, name_e=? " +
                       "WHERE id_e=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, new_node.getId_E());
            preparedStatement.setString(2, new_node.getName_E());
            preparedStatement.setString(3, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Integer max_id() {
        String query = "SELECT MAX(id_e) as max_id FROM entity LIMIT 1;";
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
