package sms.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainPageC {
	
	@FXML
	public Pane login_Page;
	
	
	public void loadLoginPage() throws IOException
	{
		Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
		Stage window = (Stage) login_Page.getScene().getWindow();
		window.setScene(new Scene(loginPage));
	}
	
}