package sms.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import sms.model.Account;
import sms.model.Employee;
import sms.model.Employer;

import java.io.IOException;

public class personalDetailsC {
    @FXML
    public Label signUpB;
    public Pane home;
    public Pane about;
    public Pane contact;
    public ToggleGroup type;
    public TextField name;
    public TextField cnic;
    public TextField age;
    public TextField phoneno;
    public TextField address;

    public maintenanceOffice moc = new maintenanceOffice();

    public void homeClick(MouseEvent click) throws IOException
    {
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(mainPage));
    }

    public void aboutClick(MouseEvent click) throws IOException
    {
        Parent aboutPage = FXMLLoader.load(getClass().getResource("about.fxml"));
        Stage window = (Stage) about.getScene().getWindow();
        window.setScene(new Scene(aboutPage));
    }

    public void contactClick(MouseEvent click) throws IOException
    {
        Parent contactPage = FXMLLoader.load(getClass().getResource("contact.fxml"));
        Stage window = (Stage) contact.getScene().getWindow();
        window.setScene(new Scene(contactPage));
    }


    public void signupClick(MouseEvent click) throws IOException
    {
        String post = "";
        String nameText = name.getText();
        String cnicText = cnic.getText();
        String ageText = age.getText();
        String phoneText = phoneno.getText();
        String addressText = address.getText();
        if (((RadioButton)type.getSelectedToggle()) == null)
        {
            Parent root = FXMLLoader.load(getClass().getResource("incompletePopup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Incomplete Info");
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            post = ((RadioButton)type.getSelectedToggle()).getText();
        }
        if (nameText.equals("") == true || cnicText.equals("") == true || ageText.equals("") == true || phoneText.equals("") == true || addressText.equals("") == true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("incompletePopup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Incomplete Info");
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Node node = (Node) click.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Account user = (Account) stage.getUserData();
            if (post.equals("Employer") == true)
            {
                Employer tempE = new Employer();
                tempE.setName(nameText);
                tempE.setAge(ageText);
                tempE.setPhone(phoneText);
                tempE.setCnic(cnicText);
                tempE.setAddress(addressText);
                Boolean status = moc.employerObj.addEmployer(tempE,user);


                Parent loginRP = FXMLLoader.load(getClass().getResource("loginR.fxml"));
                Stage window = (Stage) signUpB.getScene().getWindow();
                window.setScene(new Scene(loginRP));
            }
            else if (post.equals("Employee") == true)
            {
                Employee tempE = new Employee();
                tempE.setName(nameText);
                tempE.setAge(ageText);
                tempE.setPhone(phoneText);
                tempE.setCnic(cnicText);
                tempE.setAddress(addressText);
                Boolean status = moc.employeeObj.addEmployee(tempE,user);

                Parent loginP = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage window = (Stage) signUpB.getScene().getWindow();
                window.setScene(new Scene(loginP));
            }
        }
    }



}
