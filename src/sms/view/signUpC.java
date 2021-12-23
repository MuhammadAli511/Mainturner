package sms.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import sms.model.Account;
import sms.services.persistenceFactory;

import java.io.IOException;

public class signUpC {
    @FXML
    public TextField email_Box;
    public TextField password_Box;
    public Pane personalDetails;
    public maintenanceOffice moc = new maintenanceOffice();

    public void signUpClick(MouseEvent click) throws IOException
    {
        // Fetching data from UI
        String email = email_Box.getText();
        String password = password_Box.getText();

        // Creating Account object and setting fetched data as its parameters
        Account user = new Account();
        user.setEmail(email);
        user.setPassword(password);

        // Sending data to Account class through Maintenance Office ( Main Controller )
        persistenceFactory pf = new persistenceFactory();
        Boolean status = moc.accountObj.signUpUser(user);
        if (status == true)
        {
            Parent personalDetailsPage = FXMLLoader.load(getClass().getResource("personalDetails.fxml"));
            Stage window = (Stage) personalDetails.getScene().getWindow();
            window.setScene(new Scene(personalDetailsPage));
        }
        else if (status == false)
        {
            Parent root = FXMLLoader.load(getClass().getResource("passwordPopup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Incorrect Password");
            stage.setScene(scene);
            stage.show();
        }
    }
}
