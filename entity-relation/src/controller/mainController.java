package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void bAddModel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/addView.fxml"));
        root = loader.load();

        addController addController = loader.getController();
        addController.initialize(event);

        //stage = (Stage)myMenuBar.getScene().getWindow();//((Node)event.getSource()).getScene().getWindow();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void bAddQuery(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/queryView.fxml"));
        root = loader.load();

        QueryController queryController = loader.getController();
        queryController.initialize(event);

        //stage = (Stage)myMenuBar.getScene().getWindow();//((Node)event.getSource()).getScene().getWindow();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
