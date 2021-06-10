package controller;

import Find.QueryContainer;
import Repository.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Entity;
import model.Model;
import model.Student;
import model.TableOutput;

import java.io.IOException;
import java.util.ArrayList;

public class QueryController {

    @FXML
    private ChoiceBox<String> chbParametr, chbCondition, chbData;

    @FXML
    private TableView<TableOutput> tvOutput;

    @FXML
    private TableColumn<TableOutput, String> tc1;
    @FXML
    private TableColumn<TableOutput, String> tc2;
    @FXML
    private TableColumn<TableOutput, String> tc3;
    @FXML
    private TableColumn<TableOutput, String> tc4;
    @FXML
    private TableColumn<TableOutput, String> tc5;

    private final ArrayList<String> parametr = new ArrayList<String>() {{
        add("Студент");
        add("Модель");
        //add("Связь");
        add("Сущность");
        //add("Атрибут сущности");
    }};

    //private ArrayList<String> condition = new ArrayList<>() {{
    //    add("Вывести ");
    //    add("");
    //}};

    private ArrayList<String> data = new ArrayList<>() {{
       add("Всех");
    }};

    private QueryContainer queryContainer;

    private Entity_Manager entity_manager;
    //private Entity_Attribute_Manager attribute_manager;
    //private Between_Relation_Manager relation_manager;
    private Model_Manager model_manager;
    private Student_Manager student_manager;

    public void initialize(ActionEvent event) {
        chbParametr.getItems().setAll(parametr);
        chbParametr.setOnAction(this::showParametr);

        chbCondition.setOnAction(this::showCondition);
        chbData.setOnAction(this::showData);

        tc1.setText("");
        tc2.setText("");
        tc3.setText("");
        tc4.setText("");
        tc5.setText("");
    }

    private void showData(ActionEvent event) {

        queryContainer = new QueryContainer();
        ObservableList<TableOutput> list = FXCollections.observableArrayList();
        tvOutput.setItems(list);
        ArrayList<TableOutput> tOutput = new ArrayList<>();

        if (chbParametr.getValue() == "Студент") {
            if (chbData.getValue() == "Всех") {

                tc1.setText("Зачётка");
                tc2.setText("ФИО");
                tc3.setText("Группа");
                tc4.setText("Модель");
                tc5.setText("");

                tOutput = queryContainer.findByStudent_All();

                if (tOutput != null) {
                    System.out.println("AGA TYT YA");
                }

                for (TableOutput t: tOutput) {
                    list.add(t);
                }

                tc1.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("record_book"));
                tc2.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("FIO"));
                tc3.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("name_group"));
                tc4.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("model_name"));

                tvOutput.setItems(list);
            } else { // выбран студент

                tc1.setText("Модель");
                tc2.setText("Сущность 1");
                tc3.setText("Связь");
                tc4.setText("Сущность 2");
                tc5.setText("Мощность");


                tOutput = queryContainer.findByStudent_Student(chbData.getValue());

                for (TableOutput t: tOutput) {
                    list.add(t);
                }

                tc1.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("model_name"));
                tc2.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("left_entity"));
                tc3.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("relation_name"));
                tc4.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("right_entity"));
                tc5.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("power_left_right"));

                tvOutput.setItems(list);
            }

        }
        if (chbParametr.getValue() == "Модель") {
            if (chbData.getValue() == "Всех") {

                tc1.setText("Модель");
                tc2.setText("Зачётка");
                tc3.setText("ФИО");
                tc4.setText("");
                tc5.setText("");

                tOutput = queryContainer.findByModel_All();

                for (TableOutput t: tOutput) {
                    list.add(t);
                }

                tc1.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("model_name"));
                tc2.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("record_book"));
                tc3.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("FIO"));

                tvOutput.setItems(list);
            } else {

                tc1.setText("Сущность 1");
                tc2.setText("Связь");
                tc3.setText("Сущность 2");
                tc4.setText("Мощность");
                tc5.setText("");

                tOutput = queryContainer.findByModel_Model(chbData.getValue());

                for (TableOutput t: tOutput) {
                    list.add(t);
                }

                tc1.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("left_entity"));
                tc2.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("relation_name"));
                tc3.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("right_entity"));
                tc4.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("power_left_right"));

                tvOutput.setItems(list);
            }

        }
        if (chbParametr.getValue() == "Сущность") {
            if (chbData.getValue() == "Всех") {

                tc1.setText("Сущность");
                tc2.setText("Атрибут");
                tc3.setText("Связь");
                tc4.setText("Модель");
                tc5.setText("");

                tOutput = queryContainer.findByEntity_All();

                for (TableOutput t: tOutput) {
                    list.add(t);
                }

                tc1.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("entity"));
                tc2.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("attribute"));
                tc3.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("relation_name"));
                tc4.setCellValueFactory(new PropertyValueFactory<TableOutput, String>("model_name"));

                tvOutput.setItems(list);
            }
        }

    }

    private void showCondition(ActionEvent event) {
//
//        if (chbCondition.getValue() == "Всех студентов") {
//            tc1.setText("Номер зачётки");
//            tc2.setText("Фамилия");
//            tc3.setText("Имя");
//            tc4.setText("Отчество");
//            tc5.setText("Группа");
//        }
//
//        if (chbCondition.getValue() == "Модель и студент") {
//            tc1.setText("Модель");
//            tc2.setText("Зачётка");
//            tc3.setText("ФИО");
//            tc4.setText("Группа");
//            tc5.setText("");
//        }
//
//        if (chbCondition.getValue() == "Все модели") {
//            tc1.setText("Модель");
//            tc2.setText("");
//            tc3.setText("");
//            tc4.setText("");
//            tc5.setText("");
//        }
//
//        if (chbCondition.getValue() == "Все сущности") {
//            tc1.setText("Сущность");
//            tc2.setText("Атрибут сущности");
//            tc3.setText("");
//            tc4.setText("");
//            tc5.setText("");
//        }
    }

    public void showParametr(ActionEvent event) {
        if (chbParametr.getValue() == "Студент") {
            student_manager = new Student_Manager();
            ArrayList<Student> listStudent = student_manager.getAll();
            ArrayList<String> list = new ArrayList<>();
            list.add("Всех");
            for (Student s: listStudent) {
                list.add(s.getId_S());
            }
            chbData.getItems().setAll(list);
        }
        if (chbParametr.getValue() == "Модель") {
            model_manager = new Model_Manager();
            ArrayList<Model> listModel = model_manager.getAll();
            ArrayList<String> list = new ArrayList<>();
            list.add("Всех");
            for (Model m: listModel) {
                list.add(m.getName_M());
            }
            chbData.getItems().setAll(list);
        }
        if (chbParametr.getValue() == "Сущность") {
            entity_manager = new Entity_Manager();
            ArrayList<Entity> listEntity = entity_manager.getAll();
            ArrayList<String> list = new ArrayList<>();
            list.add("Всех");
            //for (Entity e: listEntity) {
            //    list.add(e.getName_E());
            //}
            chbData.getItems().setAll(list);
        }

    }

    public void bFind(ActionEvent event) {

        //if (chbParametr.getValue() == "Студент") {
        //    student_manager = new Student_Manager();
        //    model_manager = new Model_Manager();
        //    //Model model = student_manager.getByKey();
        //}
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void btnBackToMainPage (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
