package sms.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import sms.model.Employer;

import java.io.IOException;

public class employerWelcomeC {
    public Pane home;
    public Label accountL;
    public Label hireL;
    public Label bookingsL;

    public void logout(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }
    public void accountBox(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent accountPage = FXMLLoader.load(getClass().getResource("accountR.fxml"));
        Stage window = (Stage) accountL.getScene().getWindow();
        window.setScene(new Scene(accountPage));
    }
    public void hireBox(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent hirePage = FXMLLoader.load(getClass().getResource("hireR.fxml"));
        Stage window = (Stage) hireL.getScene().getWindow();
        window.setScene(new Scene(hirePage));
    }
    public void bookingsBox(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent bookingsPage = FXMLLoader.load(getClass().getResource("bookingsR.fxml"));
        Stage window = (Stage) bookingsL.getScene().getWindow();
        window.setScene(new Scene(bookingsPage));
    }
}
