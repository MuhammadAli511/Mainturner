package sms.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sms.model.Account;
import sms.services.persistenceFactory;

import java.io.IOException;

public class loginC {
	
	@FXML
	public TextField email_Box;
	public TextField password_Box;
	public Label loginB;
	public Pane home;
	public Pane about;
	public Pane contact;
	public ToggleGroup value;

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
	
	public void loginClick(MouseEvent click) throws IOException
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
        Boolean status = moc.accountObj.loginEmployee(user);
		if (status == null)
		{
			Parent root = FXMLLoader.load(getClass().getResource("emailPopup.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Invalid Email");
			stage.setScene(scene);
			stage.show();
		}
		else if (status == true)
		{
			System.out.println("User Logged In");
			Parent loginPage = FXMLLoader.load(getClass().getResource("employeeWelcome.fxml"));
			Stage window = (Stage) loginB.getScene().getWindow();
			window.setScene(new Scene(loginPage));
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
