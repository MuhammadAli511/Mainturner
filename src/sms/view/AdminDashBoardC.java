package sms.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashBoardC {
    @FXML
    public Label bookings;
    public Label services;
    public Label accountL;
    public Pane home;

    public void logout(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }
    public void servicesBox(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(mainPage));
    }
    public void accountBox(MouseEvent click) throws IOException
    {
       /* Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent mainPage = FXMLLoader.load(getClass().getResource("DeleteAccountByAdmin.fxml"));
        Stage window = (Stage) accountL.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(mainPage));*/
    }
    public void bookingsBox(MouseEvent click) throws IOException
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(mainPage));
    }
}
