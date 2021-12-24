package sms.view;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import sms.model.Employee;
import sms.model.Service;

import java.io.IOException;

public class createServiceC {
    @FXML
    public Pane home;
    public Label create;
    public TextField charges;
    public JFXTextArea description;
    ObservableList<String> serviceNameList = FXCollections.observableArrayList();
    public ChoiceBox<String> serviceNameBox;
    ObservableList<String> experienceList = FXCollections.observableArrayList();
    public ChoiceBox<String> experienceBox;

    public maintenanceOffice moc = new maintenanceOffice();

    @FXML
    public void initialize()
    {
        serviceNameList.add("Electrician");
        serviceNameList.add("Plumber");
        serviceNameList.add("Carpenter");
        serviceNameList.add("Mechanic");
        serviceNameList.add("Maid");
        serviceNameList.add("Babysitter");
        for (int i = 0 ; i <= 90 ; i++)
        {
            String year = Integer.toString(i);
            experienceList.add(year);
        }
        serviceNameBox.setItems(serviceNameList);
        experienceBox.setItems(experienceList);
    }

    public void logout(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }

    public void created(MouseEvent click) throws IOException
    {
        // todo: write to file
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        Service serv = new Service();
        serv.setServiceName(serviceNameBox.getValue());
        serv.setCharges(charges.getText());
        serv.setServiceDescription(description.getText());
        serv.setExperience(experienceBox.getValue());
        Boolean status = moc.serviceObj.registerService(serv,user);

        Parent mainPage = FXMLLoader.load(getClass().getResource("employeeWelcome.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setUserData(user);
        window.setScene(new Scene(mainPage));
    }
}
