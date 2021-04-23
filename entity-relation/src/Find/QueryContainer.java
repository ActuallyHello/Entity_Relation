package Find;

import javafx.scene.control.Tab;
import model.TableOutput;

import java.sql.*;
import java.util.ArrayList;

public class QueryContainer {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/erdb";

    private static Connection connection;

    public QueryContainer() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<TableOutput> findByStudent_All() {
        ArrayList<TableOutput> tOutput = null;

        String query = "SELECT student.id_s as record_book," +
                       " CONCAT(fname, ' ', lname, ' ', mname) as name," +
                       " name_group as group," +
                       " name_m as model " +
                       "FROM student" +
                        " INNER JOIN model" +
                            " ON student.id_s=model.id_s;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            tOutput = new ArrayList<TableOutput>();
            TableOutput output;
            //String result;

            while (resultSet.next()) {
                output = new TableOutput();
                output.setRecord_book(resultSet.getString("record_book"));
                output.setFIO(resultSet.getString("name"));
                output.setName_group(resultSet.getString("group"));
                output.setModel_name(resultSet.getString("model"));
                tOutput.add(output);
//                result = "";
//                result += resultSet.getString("record_book") + "; " +
//                          resultSet.getString("name") + "; " +
//                          resultSet.getString("group") + "; " +
//                          resultSet.getString("model");
//                list.add(result);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tOutput;
    }

    public ArrayList<TableOutput> findByStudent_Student(String key) {
        ArrayList<TableOutput> tOutput = null;

        String q = "SELECT m.name_m as model," +
                " l.name_e as left_name," +
                " be.name_be as relation_name," +
                " r.name_e as right_name," +
                " be.power_be as power_left_right" +
                "  FROM model as m" +
                " INNER JOIN student as s" +
                " ON s.id_s=m.id_s" +
                " INNER JOIN between_entity as be" +
                " ON be.id_m=m.id_m" +
                " INNER JOIN entity as l" +
                "  ON l.id_e=be.id_e_left" +
                " INNER JOIN entity as r" +
                " ON r.id_e=be.id_e_right" +
                " WHERE s.id_s=?;";

        String query = "SELECT m.name_m as model," +
                        " l.name_e as left_name," +
                        " be.name_be as relation_name," +
                        " r.name_e as right_name," +
                        " be.power_be as power_left_rigth " +
                        "FROM model as m" +
                            "INNER JOIN student as s " +
                                "ON s.id_s=m.id_s " +
                            "INNER JOIN between_entity as be " +
                                "ON be.id_m=m.id_m " +
                                "INNER JOIN entity as l " +
                                    "ON l.id_e=be.id_e_left " +
                                "INNER JOIN entity as r " +
                                    "ON r.id_e=be.id_e_right" +
                            "WHERE s.id_s=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1, key);

            ResultSet resultSet = preparedStatement.executeQuery();
            tOutput = new ArrayList<>();
            TableOutput output;

            while (resultSet.next()) {
                output = new TableOutput();
                output.setModel_name(resultSet.getString("model"));
                output.setLeft_entity(resultSet.getString("left_name"));
                output.setRelation_name(resultSet.getString("relation_name"));
                output.setRight_entity(resultSet.getString("right_name"));
                output.setPower_left_right(resultSet.getString("power_left_right"));
                tOutput.add(output);
//                result = "";
//                result += resultSet.getString("model") + "; " +
//                        resultSet.getString("left_name") + "; " +
//                        resultSet.getString("relation_name") + "; " +
//                        resultSet.getString("right_name") + "; " +
//                        resultSet.getString("power_left_right");
//                list.add(result);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tOutput;
    }

    //TODO
    // 1. Получить всех студентов и модели, которые они сделали
    // 2. Получить все модели и что в них входит
    // 3. Получить определенную модель и что в нее входит
    // 4. Получить все сущности и атрибуты, которые вхоидт в сущность, указав модель
    // 5. Получить определенную связь и модель


    public ArrayList<TableOutput> findByModel_All() {
        ArrayList<TableOutput> tOutput = null;

        String query = "SELECT m.name_m as model" +
                        " s.id_s as record_book" +
                        " CONCAT(s.fname, ' ', s.lname, ' ', s.mname) as name " +
                       "FROM model as m " +
                            "INNER JOIN student s" +
                                "ON s.id_s=m.id_s;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            tOutput = new ArrayList<TableOutput>();
            TableOutput output;
            //String result;

            while (resultSet.next()) {
                output = new TableOutput();
                output.setModel_name(resultSet.getString("model"));
                output.setRecord_book(resultSet.getString("record_book"));
                output.setFIO(resultSet.getString("name"));
//                result = "";
//                result += resultSet.getString("record_book") + "; " +
//                          resultSet.getString("name") + "; " +
//                          resultSet.getString("group") + "; " +
//                          resultSet.getString("model");
//                list.add(result);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tOutput;
    }

    public ArrayList<TableOutput> findByModel_Model(String key) {

        ArrayList<TableOutput> tOutput = null;

        String q = "select l.name_e as left_name, be.name_be as relation_name, r.name_e as right_name, be.power_be as power_left_right FROM model as m inner join student as s on s.id_s=m.id_s INNER JOIN between_entity as be ON be.id_m=m.id_m" +
                " INNER JOIN entity as l ON l.id_e=be.id_e_left INNER JOIN entity as r ON r.id_e=be.id_e_right WHERE m.name_m=?;";

        String query = "SELECT l.name_e as left_name," +
                        " be.name_be as relation_name," +
                        " r.name_e as right_name," +
                        " be.power_be as power_left_rigth " +
                        "FROM model as m" +
                            "INNER JOIN student as s " +
                                "ON s.id_s=m.id_s " +
                            "INNER JOIN between_entity as be " +
                                "ON be.id_m=m.id_m " +
                                "INNER JOIN entity as l " +
                                    "ON l.id_e=be.id_e_left " +
                                "INNER JOIN entity as r " +
                                    "ON r.id_e=be.id_e_right" +
                            "WHERE m.name_m=?;";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1, key);

            ResultSet resultSet = preparedStatement.executeQuery();
            tOutput = new ArrayList<>();
            TableOutput output;
            //String result;

            while (resultSet.next()) {
                output = new TableOutput();
                output.setLeft_entity(resultSet.getString("left_name"));
                output.setRelation_name(resultSet.getString("relation_name"));
                output.setRight_entity(resultSet.getString("right_name"));
                output.setPower_left_right(resultSet.getString("power_left_right"));
                tOutput.add(output);
                //result = "";
                //result += resultSet.getString("left_name") + "; " +
                //        resultSet.getString("relation_name") + "; " +
                //        resultSet.getString("right_name") + "; " +
                //        resultSet.getString("power_left_right");
                //list.add(result);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tOutput;
    }

    public ArrayList<TableOutput> findByEntity_All() {

        ArrayList<TableOutput> tOutput = null;

        String query = "SELECT distinct e.name_e as name_entity," +
                        " ea.name_ea as name_attribute," +
                        " be.name_be as name_relation," +
                        " m.name_m as name_model " +
                        "FROM entity as e " +
                            "INNER JOIN entity_attribute as ea " +
                                "ON ea.id_e=e.id_e " +
                            "INNER JOIN between_entity as be " +
                                "ON be.id_e_left=e.id_e " +
                                    "OR " +
                                    "be.id_e_right=e.id_e " +
                                "INNER JOIN model as m " +
                                    "ON m.id_m=be.id_m " +
                        "ORDER BY m.name_m, be.name_be;";

        try {
            //PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setString(1, key);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            tOutput = new ArrayList<>();
            //String result;
            TableOutput output;
            while (resultSet.next()) {
                output = new TableOutput();
                output.setEntity(resultSet.getString("name_entity"));
                output.setAttribute(resultSet.getString("name_attribute"));
                output.setRelation_name(resultSet.getString("name_relation"));
                output.setModel_name(resultSet.getString("name_model"));
                tOutput.add(output);
//                result = "";
//                result += resultSet.getString("name_entity") + "; " +
//                        resultSet.getString("name_attribute") + "; " +
//                        resultSet.getString("name_relation") + "; " +
//                        resultSet.getString("name_model");
//                list.add(result);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tOutput;
    }

//    public ArrayList<String> findByRelation_All() {
//
//        ArrayList<String> list = null;
//
//        String query = "SELECT be.name_be as name_relation," +
//                        " l.name_e as left_entity," +
//                        " r.name_e as right_entity," +
//                        " be.power_be as power_entity," +
//                        " m.name_m as name_model " +
//                        "FROM between_entity as be " +
//                            "INNER JOIN entity as l " +
//                                "ON l.id_e=be.id_e_left " +
//                            "INNER JOIN entity as r " +
//                                "ON r.id_e=be.id_e_right " +
//                            "INNER JOIN model as m " +
//                                "ON m.id_m=be.id_m;";
//
//
//    }

//    public ArrayList<String> findByRelation_Relation(String key) {
//
//        ArrayList<String> list = null;
//
//        String query = "SELECT be.name_be as name_relation," +
//                        " l.name_e as left_entity," +
//                        " r.name_e as right_entity," +
//                        " be.power_be as power_entity," +
//                        " m.name_m as name_model " +
//                        "FROM between_entity as be " +
//                            "INNER JOIN entity as l " +
//                                "ON l.id_e=be.id_e_left " +
//                            "INNER JOIN entity as r " +
//                                "ON r.id_e=be.id_e_right " +
//                            "INNER JOIN model as m " +
//                                "ON m.id_m=be.id_m" +
//                        "WHERE be.name_be=?;";
//
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, key);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            list = new ArrayList<>();
//            String result;
//
//            while (resultSet.next()) {
//                result = "";
//                result += resultSet.getString("model") + "; " +
//                        resultSet.getString("left_name") + "; " +
//                        resultSet.getString("relation_name") + "; " +
//                        resultSet.getString("right_name") + "; " +
//                        resultSet.getString("power_left_right");
//                list.add(result);
//            }
//        }
//        catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return list;
//    }
}
