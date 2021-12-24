package sms.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;

import java.io.IOException;

public class aboutC {
    public Pane home;
    public Pane contact;


    public void homeClick(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }

    public void contactClick(MouseEvent click) throws IOException
    {
        Parent contactPage = FXMLLoader.load(getClass().getResource("contact.fxml"));
        Stage window = (Stage) contact.getScene().getWindow();
        window.setScene(new Scene(contactPage));
    }
}
