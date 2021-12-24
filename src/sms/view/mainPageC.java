package sms.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainPageC {
	
	@FXML
	public Pane login_Page;
	public Pane login_Page_E;
	public Pane login_Page_R;
	public Pane about;
	public Pane contact;
	public Label sign;

	
	public void loadLoginPage() throws IOException
	{
		Parent loginPage = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
		Stage window = (Stage) login_Page.getScene().getWindow();
		window.setScene(new Scene(loginPage));
	}
	public void loadEmployerLoginPage() throws IOException
	{
		Parent loginPage = FXMLLoader.load(getClass().getResource("loginR.fxml"));
		Stage window = (Stage) login_Page_R.getScene().getWindow();
		window.setScene(new Scene(loginPage));
	}
	public void loadEmployeeLoginPage() throws IOException
	{
		Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
		Stage window = (Stage) login_Page_E.getScene().getWindow();
		window.setScene(new Scene(loginPage));
	}

	public void contactClick(MouseEvent click) throws IOException
	{
		Parent contactPage = FXMLLoader.load(getClass().getResource("contact.fxml"));
		Stage window = (Stage) contact.getScene().getWindow();
		window.setScene(new Scene(contactPage));
	}

	public void aboutClick(MouseEvent click) throws IOException
	{
		Parent aboutPage = FXMLLoader.load(getClass().getResource("about.fxml"));
		Stage window = (Stage) about.getScene().getWindow();
		window.setScene(new Scene(aboutPage));
	}
	public void signclick(MouseEvent click) throws IOException
	{
		Parent signPage = FXMLLoader.load(getClass().getResource("signUp.fxml"));
		Stage window = (Stage) about.getScene().getWindow();
		window.setScene(new Scene(signPage));
	}
	
}