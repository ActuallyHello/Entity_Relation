package Repository;

import model.Model;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class ModelDAO implements Repos<Model> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/card_game";

    private static Connection connection;

    public ModelDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Model> getAll() {
        ArrayList<Model> modelList = new ArrayList<>();

        String query = "SELECT ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Model model;
            while(rs.next()) {
                model = new Model(rs.getLong(""),rs.getString("") , rs.getLong(""));
                modelList.add(model);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return modelList;
    }

    @Override
    public Model getByKey(String key) {
        Model model = null;
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            model = new Model(rs.getLong(""),rs.getString("") , rs.getLong(""));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return model;
    }

    @Override
    public void add_node(Model node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, node.getId_M());
            preparedStatement.setString(2, node.getName_M());
            preparedStatement.setLong(3, node.getId_BE());

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
    public void update(String key, Model new_node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, new_node.getId_M());
            preparedStatement.setString(2, new_node.getName_M());
            preparedStatement.setLong(3, new_node.getId_BE());
            preparedStatement.setString(4, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
