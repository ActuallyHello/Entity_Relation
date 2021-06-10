package controller;

import Repository.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Upd_DelController {

    @FXML ChoiceBox<String> chbOptions; @FXML ChoiceBox<String> chbObjects;@FXML ChoiceBox<String> chbList;
    @FXML ChoiceBox<String> chb1;@FXML ChoiceBox<String> chb2;@FXML ChoiceBox<String> chb3;@FXML ChoiceBox<String> chb4;
    @FXML TextField tf1;@FXML TextField tf2;@FXML TextField tf3;@FXML TextField tf4;@FXML TextField tf5;
    @FXML Label l1;@FXML Label l2;@FXML Label l3;@FXML Label l4;@FXML Label l5;@FXML Label l6;

    ArrayList<String> options = new ArrayList<>() {{
       add("Удалить");
       add("Отредактировать");
    }};

    ArrayList<String> list = new ArrayList<>() {{
        add("Студент");
        add("Модель");
        add("Сущность");
        add("Атрибут");
        add("Связь");
    }};

    private Student_Manager student_manager;
    private Model_Manager model_manager;
    private Entity_Manager entity_manager;
    private Entity_Attribute_Manager attribute_manager;
    private Between_Relation_Manager relation_manager;

    public void initialize(ActionEvent event) {
        chbOptions.getItems().setAll(options);
        chbList.getItems().setAll(list);

        chbOptions.setOnAction(this::setUpd_Del);
        chbList.setOnAction(this::setList);
        chbObjects.setOnAction(this::setObjects);
    }

    public void setUpd_Del(ActionEvent event) {

        if (chbOptions.getValue() == "Удалить") {

        } else {

        }
    }

    public void setObjects(ActionEvent event) {
        if (chbList.getValue() == "Студент") {
            tf1.setText("");
        }
        if (chbList.getValue() == "Модель") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(true);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название модели");l2.setText("");l3.setText("Студент");l4.setText("");l5.setText("");l6.setText("");
        }
        if (chbList.getValue() == "Сущность") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(false);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(false);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название сущности");l2.setText("");l3.setText("");l4.setText("");l5.setText("");l6.setText("");
        }
        if (chbList.getValue() == "Атрибут") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(true);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название атрибута");l2.setText("");l3.setText("Сущность");l4.setText("Фамилия");l5.setText("Отчество");l6.setText("Модель");
        }
        if (chbList.getValue() == "Связь") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(true);chb3.setVisible(true);chb4.setVisible(true);
            l1.setVisible(true);l2.setVisible(true);l3.setVisible(true);l4.setVisible(true);l5.setVisible(true);l6.setVisible(true);
            l1.setText("Название связи");l2.setText("");l3.setText("Левая сущность");l4.setText("Мощность");l5.setText("Правая сущность");l6.setText("Модель");
        }
    }

    public void setList(ActionEvent event) {
        if (chbList.getValue() == "Студент") {
            tf1.setVisible(true);tf2.setVisible(true);tf3.setVisible(true);tf4.setVisible(true);tf5.setVisible(true);
            chb1.setVisible(false);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(true);l3.setVisible(true);l4.setVisible(true);l5.setVisible(true);l6.setVisible(true);
            l1.setText("Зачётка");l2.setText("Группа");l3.setText("Имя");l4.setText("Фамилия");l5.setText("Отчество");l6.setText("Модель");
        }
        if (chbList.getValue() == "Модель") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(true);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название модели");l2.setText("");l3.setText("Студент");l4.setText("");l5.setText("");l6.setText("");
        }
        if (chbList.getValue() == "Сущность") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(false);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(false);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название сущности");l2.setText("");l3.setText("");l4.setText("");l5.setText("");l6.setText("");
        }
        if (chbList.getValue() == "Атрибут") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(false);chb3.setVisible(false);chb4.setVisible(false);
            l1.setVisible(true);l2.setVisible(false);l3.setVisible(true);l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
            l1.setText("Название атрибута");l2.setText("");l3.setText("Сущность");l4.setText("Фамилия");l5.setText("Отчество");l6.setText("Модель");
        }
        if (chbList.getValue() == "Связь") {
            tf1.setVisible(true);tf2.setVisible(false);tf3.setVisible(false);tf4.setVisible(false);tf5.setVisible(false);
            chb1.setVisible(true);chb2.setVisible(true);chb3.setVisible(true);chb4.setVisible(true);
            l1.setVisible(true);l2.setVisible(true);l3.setVisible(true);l4.setVisible(true);l5.setVisible(true);l6.setVisible(true);
            l1.setText("Название связи");l2.setText("");l3.setText("Левая сущность");l4.setText("Мощность");l5.setText("Правая сущность");l6.setText("Модель");
        }
    }

    public void bAccept(ActionEvent event) {
        if (chbOptions.getValue() == "Удалить") {
            if (chbList.getValue() == "Студент") {
                student_manager = new Student_Manager();
                List<String> list = new ArrayList<String>(Arrays.asList(chbObjects.getValue().split("; ")));
                student_manager.delete_node(list.get(0));
            }
            if (chbList.getValue() == "Модель") {
                model_manager = new Model_Manager();
                List<String> list = new ArrayList<String>(Arrays.asList(chbObjects.getValue().split("; ")));
                model_manager.delete_node(list.get(0));
            }
            if (chbList.getValue() == "Сущность") {
                entity_manager = new Entity_Manager();
                List<String> list = new ArrayList<String>(Arrays.asList(chbObjects.getValue().split("; ")));
                entity_manager.delete_node(list.get(0));
            }
            if (chbList.getValue() == "Атрибут") {
                attribute_manager = new Entity_Attribute_Manager();
                List<String> list = new ArrayList<String>(Arrays.asList(chbObjects.getValue().split("; ")));
                student_manager.delete_node(list.get(0));
            }
            if (chbList.getValue() == "Связь") {
                relation_manager = new Between_Relation_Manager();
                List<String> list = new ArrayList<String>(Arrays.asList(chbObjects.getValue().split("; ")));
                relation_manager.delete_node(list.get(0));
            }
        } else {
            if (chbList.getValue() == "Студент") {
                student_manager = new Student_Manager();
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Student> slist = student_manager.getAll();
                for (Student s: slist) {
                    list .add(s.getId_S() + "; " + s.getFname() + "; " + s.getLname());
                }
                chbObjects.getItems().setAll(list);
            }
            if (chbList.getValue() == "Модель") {
                model_manager = new Model_Manager();
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Model> mlist = model_manager.getAll();
                for (Model m: mlist) {
                    list.add(m.getId_M() + "; " + m.getName_M());
                }
                chbObjects.getItems().setAll(list);
            }
            if (chbList.getValue() == "Сущность") {
                entity_manager = new Entity_Manager();
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Entity> elist = entity_manager.getAll();
                for (Entity e: elist) {
                    list.add(e.getId_E() + "; " + e.getName_E());
                }
                chbObjects.getItems().setAll(list);
            }
            if (chbList.getValue() == "Атрибут") {
                attribute_manager = new Entity_Attribute_Manager();
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Entity_Attribute> alist = attribute_manager.getAll();
                for (Entity_Attribute a: alist) {
                    list.add(a.getId_EA() + "; " + a.getName_EA());
                }
                chbObjects.getItems().setAll(list);
            }
            if (chbList.getValue() == "Связь") {
                relation_manager = new Between_Relation_Manager();
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Between_relation> rlist = relation_manager.getAll();
                for (Between_relation r: rlist) {
                    list.add(r.getId_BE() + "; " + r.getName_BE() + "; " + r.getId_M() + "-idModel");
                }
                chbObjects.getItems().setAll(list);
            }
        }
    }

}
