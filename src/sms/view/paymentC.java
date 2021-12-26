package sms.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class paymentC {
    public Pane home;
    public Label price;
    public Label next;
    ObservableList<String> priceList = FXCollections.observableArrayList();
    public ComboBox<String> priceeBox;

    public void initialize()
    {
        priceList.add("Easypaisa");
        priceList.add("JazzCash");
        priceeBox.setItems(priceList);
    }

    public void logout(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }
    public void nextPage(MouseEvent click) throws IOException
    {
        Parent nextP = FXMLLoader.load(getClass().getResource("employerWelcome.fxml"));
        Stage window = (Stage) next.getScene().getWindow();
        window.setScene(new Scene(nextP));
    }

}
