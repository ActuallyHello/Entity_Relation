package Repository;

import model.Entity;
import model.Entity_Attribute;
import model.Model;

import java.sql.*;
import java.util.ArrayList;

public class Entity_AttributeDAO implements Repos<Entity_Attribute> {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/er_db";

    private static Connection connection;

    public Entity_AttributeDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Entity_Attribute> getAll() {
        ArrayList<Entity_Attribute> entity_attributeList = new ArrayList<>();

        String query = "SELECT ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Entity_Attribute entity_attribute;
            while(rs.next()) {
                entity_attribute = new Entity_Attribute(rs.getLong(""),rs.getString("") , rs.getLong(""));
                entity_attributeList.add(entity_attribute);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity_attributeList;
    }

    @Override
    public Entity_Attribute getByKey(String key) {
        Entity_Attribute entity_attribute = null;
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            entity_attribute = new Entity_Attribute(rs.getLong(""),rs.getString(""), rs.getLong(""));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity_attribute;
    }

    @Override
    public void add_node(Entity_Attribute node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, node.getId_EA());
            preparedStatement.setString(2, node.getName_EA());
            preparedStatement.setLong(3, node.getId_E());

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
    public void update(String key, Entity_Attribute new_node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, new_node.getId_EA());
            preparedStatement.setString(2, new_node.getName_EA());
            preparedStatement.setLong(3, new_node.getId_E());
            preparedStatement.setString(4, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
