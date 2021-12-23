package sms.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	public Pane adminDashboard;
    public maintenanceOffice moc = new maintenanceOffice();

	
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
        Boolean status = moc.accountObj.loginUser(user);
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
			Parent adminDashboardPage = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));
			Stage window = (Stage) adminDashboard.getScene().getWindow();
			window.setScene(new Scene(adminDashboardPage));
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

	public void employeeClick(MouseEvent click) throws IOException
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
		Boolean status = moc.accountObj.loginUser(user);
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
			Parent adminDashboardPage = FXMLLoader.load(getClass().getResource("employeeWelcome.fxml"));
			Stage window = (Stage) adminDashboard.getScene().getWindow();
			window.setScene(new Scene(adminDashboardPage));
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

	public void employerClick(MouseEvent click) throws IOException
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
		Boolean status = moc.accountObj.loginUser(user);
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
			Parent adminDashboardPage = FXMLLoader.load(getClass().getResource("employerWelcome.fxml"));
			Stage window = (Stage) adminDashboard.getScene().getWindow();
			window.setScene(new Scene(adminDashboardPage));
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
