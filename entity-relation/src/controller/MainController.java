package controller;

import Repository.EntityDAO;

public class MainController {

    private final EntityDAO entityDAO = new EntityDAO();

//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "admin";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/card_game";
//
//    private static Connection connection;
//
//    static {
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    private static String kek() {
//
//        String query = "SELECT VERSION()";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            //preparedStatement.setString(1, nickname);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//
//            return resultSet.getString("version");
//            //player = new Player(resultSet.getString("nickname"), resultSet.getString("name"), resultSet.getString("date_of_birthday"), resultSet.getInt("gamepoints"), resultSet.getString("rank"), resultSet.getString("region"), resultSet.getString("last_activity"));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return "";
//    }
//
//    public void Act(ActionEvent event) {
//        System.out.println(kek());
//    }
}
