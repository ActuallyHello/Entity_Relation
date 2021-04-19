package controller;

import Repository.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addController {

    @FXML
    ChoiceBox<String> chbOption, chbRelationToEntity, chbStudents, chbLeftEntity, chbRightEntity, chbPower, chbModels, chbFind;

    @FXML
    Button btnAddEntity, btnAddAttribute, btnAddToModel, btnAddRelation, btnAddModel, btnAddStudent, btnRemoveFromModel, btnFindForm;

    @FXML
    TextField tfNameEntity, tfNameAttribute, tfNameRelation, tfNameModel, tfNumberStud, tfLname, tfFname, tfMname, tfGroup,tfCondition;

    private final ArrayList<String> options = new ArrayList<String>() {{
        add("Сущности");
        add("Атрибут сущности");
        add("Связь между сущностями");
        add("Модель");
        add("Студент");
    }};

    private final ArrayList<String> power = new ArrayList<String>() {{
       add("1-1");
       add("1-N");
       add("N-1");
       add("N-M");
    }};

    private ArrayList<String> entityList, relationList, studentList, attributeList, modelList;

    private Entity_Attribute_Manager attribute_manager;
    private Entity_Manager entity_manager;
    private Between_Relation_Manager relation_manager;
    private Model_Manager model_manager;
    private Student_Manager student_manager;

    public void initialize(ActionEvent event) {
        chbOption.getItems().setAll(options);
        chbPower.getItems().setAll(power);
        chbOption.setOnAction(this::showOptions);

        entityList = new ArrayList<>();
        relationList = new ArrayList<>();
        studentList = new ArrayList<>();
        attributeList = new ArrayList<>();
        modelList = new ArrayList<>();
    }

    public void showOptions(ActionEvent event) {
        //TODO
        // 1. Протестить и забить данными
    }

    public void bAddAttribute(ActionEvent event) {
        attributeList.add(tfNameAttribute.getText() + "; "
                          + chbRelationToEntity.getValue());
        update_data(event);
    }

    public void bAddEntity(ActionEvent event) {
        entityList.add(tfNameEntity.getText());
        update_data(event);
    }

    public void bAddRelations(ActionEvent event) {
        relationList.add(tfNameRelation.getText() + "; "
                         + chbPower.getValue() + "; "
                         + chbLeftEntity.getValue() + "; "
                         + chbRightEntity.getValue() + "; "
                         + chbModels.getValue());
        update_data(event);
    }

    public void bAddModel(ActionEvent event) {
        modelList.add(tfNameModel.getText() + "; "
                      + chbStudents.getValue());
        update_data(event);
    }

    public void bAddStudent(ActionEvent event) {
        studentList.add(tfNumberStud.getText() + "; "
                        + tfFname.getText() + "; "
                        + tfLname.getText() + "; "
                        + tfMname.getText() + "; "
                        + tfGroup.getText());
        update_data(event);
    }

    public void update_data(ActionEvent event) {

        ArrayList<String> models = new ArrayList<>();
        for (String m: modelList) {
            List<String> list = new ArrayList<String>(Arrays.asList(m.split("; ")));
            models.add(list.get(0));
        }

        ArrayList<String> students = new ArrayList<>();
        for (String s: studentList) {
            List<String> list = new ArrayList<String>(Arrays.asList(s.split("; ")));
            students.add(list.get(0) + "; " + list.get(1) + "; " + list.get(2));
        }

        chbLeftEntity.getItems().setAll(entityList);
        chbRightEntity.getItems().setAll(entityList);
        chbStudents.getItems().setAll(students);
        chbRelationToEntity.getItems().setAll(entityList);
        chbModels.getItems().setAll(models);
    }

    public void bAccept(ActionEvent event) {
        attribute_manager = new Entity_Attribute_Manager();
        entity_manager = new Entity_Manager();
        relation_manager = new Between_Relation_Manager();
        model_manager = new Model_Manager();
        student_manager = new Student_Manager();


        List<String> values;
        for (String line: studentList) {
            values = new ArrayList<String>(Arrays.asList(line.split("; ")));
            student_manager.add_node(new Student(values.get(0),
                                                 values.get(1), values.get(2), values.get(3),
                                                 values.get(4)));
        }

        for (String line: modelList) {
            values = new ArrayList<String>(Arrays.asList(line.split("; ")));
            model_manager.add_node(new Model(model_manager.max_id() + 1,
                                             values.get(0),
                                             values.get(1)));
        }

        for (String line: entityList) {
            entity_manager.add_node(new Entity(entity_manager.max_id() + 1,
                                               line));
        }

        for (String line: attributeList) {
            values = new ArrayList<String>(Arrays.asList(line.split("; ")));
            attribute_manager.add_node(new Entity_Attribute(attribute_manager.max_id() + 1, // next id
                                                            values.get(0), // name of attribute
                                                            entity_manager.getByKey(values.get(1), "byName").getId_E())); // fk entity
        }

        for (String line: relationList) {
            values = new ArrayList<String>(Arrays.asList(line.split("; ")));
            relation_manager.add_node(new Between_relation(relation_manager.max_id() + 1,
                                                            values.get(0),
                                                            values.get(1),
                                                            entity_manager.getByKey(values.get(2), "byName").getId_E(), // fk left entity
                                                            entity_manager.getByKey(values.get(3), "byName").getId_E(), // fk right entity
                                                            model_manager.getByKey(values.get(4), "byName").getId_M())); // fk model
        }
    }
}