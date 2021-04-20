package Repository;

import model.Entity;
import model.Entity_Attribute;
import model.Model;

import java.sql.*;
import java.util.ArrayList;

public class Entity_Attribute_Manager implements Repos<Entity_Attribute> {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public Entity_Attribute_Manager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Entity_Attribute> getAll() {
        ArrayList<Entity_Attribute> entity_attributeList = new ArrayList<>();

        String query = "SELECT id_ea as id, name_ea as name, id_e as id_entity as model " +
                       "FROM entity_attribute;";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Entity_Attribute entity_attribute;
            while(rs.next()) {
                entity_attribute = new Entity_Attribute(rs.getInt("id"),
                                                        rs.getString("name"),
                                                        rs.getInt("id_entity"));
                entity_attributeList.add(entity_attribute);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity_attributeList;
    }

    @Override
    public Entity_Attribute getByKey(String key, String where) {
        Entity_Attribute entity_attribute = null;

        String query = "";

        PreparedStatement preparedStatement;

        try {
            if (where == "byId") {
                int id = Integer.parseInt(key);
                query = "SELECT id_ea as id, name_ea as name, id_e as id_entity " +
                        "FROM entity_attribute " +
                        "WHERE id_ea=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
            }
            else { // if (where == "byName")
                query = "SELECT id_ea as id, name_ea as name, id_e as id_entity " +
                        "FROM entity_attribute " +
                        "WHERE name_ea=? " +
                        "ORDER BY id_ea DESC " +
                        "LIMIT 1;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, key);
            }

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            entity_attribute = new Entity_Attribute(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getInt("id_entity"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entity_attribute;
    }

    @Override
    public void add_node(Entity_Attribute node) {
        String query = "INSERT INTO entity_attribute (id_ea, name_ea, id_e) VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, node.getId_EA());
            preparedStatement.setString(2, node.getName_EA());
            preparedStatement.setInt(3, node.getId_E());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_node(String key) {
        String query = "DELETE FROM entity_attribute " +
                       "WHERE id_ea=?;";

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
    public void update(String key, Entity_Attribute new_node) {
        String query = "UPDATE entity_attribute " +
                       "SET id_ea=?, name_ea=?, id_e=? " +
                       "WHERE id_ea=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, new_node.getId_EA());
            preparedStatement.setString(2, new_node.getName_EA());
            preparedStatement.setInt(3, new_node.getId_E());
            preparedStatement.setString(4, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Integer max_id() {
        String query = "SELECT MAX(id_ea) as max_id FROM entity_attribute LIMIT 1;";
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