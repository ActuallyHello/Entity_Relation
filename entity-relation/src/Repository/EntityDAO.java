package Repository;

import model.Entity;
import model.Model;

import java.sql.*;
import java.util.ArrayList;

public class EntityDAO implements Repos<Entity> {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/card_game";

    private static Connection connection;

    public EntityDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> entityList = new ArrayList<>();

        String query = "SELECT ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Entity entity;
            while(rs.next()) {
                entity = new Entity(rs.getLong(""),rs.getString(""));
                entityList.add(entity);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return entityList;
    }

    @Override
    public Entity getByKey(String key) {
        Entity entity = null;
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            entity = new Entity(rs.getLong(""),rs.getString(""));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity;
    }

    @Override
    public void add_node(Entity node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, node.getId_E());
            preparedStatement.setString(2, node.getName_E());

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
    public void update(String key, Entity new_node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, new_node.getId_E());
            preparedStatement.setString(2, new_node.getName_E());
            preparedStatement.setString(3, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
