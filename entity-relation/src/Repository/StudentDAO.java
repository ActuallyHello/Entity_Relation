package Repository;

import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO implements Repos<Student> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/card_game";

    private static Connection connection;

    public StudentDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> studentList = new ArrayList<>();

        String query = "SELECT ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Student student;
            while(rs.next()) {
                student = new Student(rs.getString(""),rs.getString("") , rs.getString(""), rs.getString(""), rs.getString(""), rs.getLong(""));
                studentList.add(student);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student getByKey(String key) {
        Student student = null;
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            student = new Student(rs.getString(""),rs.getString("") , rs.getString(""), rs.getString(""), rs.getString(""), rs.getLong(""));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    @Override
    public void add_node(Student node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, node.getId_S());
            preparedStatement.setString(2, node.getFname());
            preparedStatement.setString(3, node.getLname());
            preparedStatement.setString(4, node.getMname());
            preparedStatement.setString(5, node.getName_group());
            preparedStatement.setLong(6, node.getId_M());

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
    public void update(String key, Student new_node) {
        String query = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, new_node.getId_S());
            preparedStatement.setString(2, new_node.getFname());
            preparedStatement.setString(3, new_node.getLname());
            preparedStatement.setString(4, new_node.getMname());
            preparedStatement.setString(5, new_node.getName_group());
            preparedStatement.setLong(6, new_node.getId_M());
            preparedStatement.setString(7, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
