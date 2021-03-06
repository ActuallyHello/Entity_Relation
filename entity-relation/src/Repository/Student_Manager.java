package Repository;

import model.Entity;
import model.Model;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class Student_Manager implements Repos<Student> {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public Student_Manager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> studentList = new ArrayList<>();

        String query = "SELECT id_s as id, fname as first, lname as last, mname as mid, name_group as group " +
                       "FROM student;";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Student student;
            while(rs.next()) {
                student = new Student(rs.getString("id"),
                                      rs.getString("first"),
                                      rs.getString("last"),
                                      rs.getString("mid"),
                                      rs.getString("group"));
                studentList.add(student);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student getByKey(String key, String where) {
        Student student = null;

        String query = "";

        try {

            PreparedStatement preparedStatement;

            if (where == "byId") {
                int id = Integer.parseInt(key);
                query = "SELECT id_s as id, fname as first, lname as last, mname as mid, name_group as group " +
                        "FROM student " +
                        "WHERE id_s=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
            }
            else { // if (where == "byName")
                query = "SELECT id_s as id, fname as first, lname as last, mname as mid, name_group as group " +
                        "FROM student " +
                        "WHERE lname=? " +
                        "ORDER BY id_s DESC " +
                        "LIMIT 1;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, key);
            }


            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            student = new Student(rs.getString("id"),
                                  rs.getString("first"),
                                  rs.getString("last"),
                                  rs.getString("mid"),
                                  rs.getString("name_group"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    @Override
    public void add_node(Student node) {
        String query = "INSERT INTO student (id_S, fname, lname, mname, name_group) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, node.getId_S());
            preparedStatement.setString(2, node.getFname());
            preparedStatement.setString(3, node.getLname());
            preparedStatement.setString(4, node.getMname());
            preparedStatement.setString(5, node.getName_group());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete_node(String key) {
        String query = "DELETE FROM student " +
                       "WHERE id_s=?";

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
        String query = "UPDATE student " +
                       "SET id_s=?, fname=?, lname=?, mname=?, name_group=? " +
                       "WHERE id_s=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, new_node.getId_S());
            preparedStatement.setString(2, new_node.getFname());
            preparedStatement.setString(3, new_node.getLname());
            preparedStatement.setString(4, new_node.getMname());
            preparedStatement.setString(5, new_node.getName_group());
            preparedStatement.setString(6, key);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Integer max_id() {
        String query = "SELECT MAX(id_s) as max_id FROM between_entity LIMIT 1;";
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
