package sms.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.model.Employee;

import java.io.IOException;

public class servicesEC {
    public Pane home;
    public Label view;
    public Label create;

    public void logout(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }

    public void loadcreatePage(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent createPage = FXMLLoader.load(getClass().getResource("createService.fxml"));
        Stage window = (Stage) create.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(createPage));
    }
    public void loadviewPage(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent viewPage = FXMLLoader.load(getClass().getResource("viewService.fxml"));
        Stage window = (Stage) view.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(viewPage));
    }

}
