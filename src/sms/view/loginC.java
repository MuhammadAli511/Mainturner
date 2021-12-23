package sms.view;

import sms.controller.maintenanceOffice;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sms.model.Account;
import sms.services.persistenceFactory;

public class loginC {
	
	@FXML
	public TextField email_Box;
	public TextField password_Box;
    public maintenanceOffice moc = new maintenanceOffice();

	
	public void loginClick(MouseEvent click)
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
        Boolean status = moc.accountObj.loginAdmin(user);
		if (status == true)
		{
			// todo: load admin dashboard
		}
		else if (status == false)
		{
			// todo: incorrect password popup
		}
		else if (status == null)
		{
			// todo: email not found
		}

	}
}
