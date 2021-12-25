package sms.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sms.controller.maintenanceOffice;
import sms.model.Employee;
import sms.model.Service;

public class thumbnailC {
	@FXML
	public ImageView thumb;
	public Label name1;
	public Label rating1;
	public RadioButton id1;
	public Label cost;
	public ToggleGroup selected = new ToggleGroup();
	public maintenanceOffice moc = new maintenanceOffice();

	public void setData(Employee em,String serv)
	{
		Image img1 = new Image(getClass().getResourceAsStream("images/person.jpg"));
		thumb.setImage(img1);
		name1.setText(em.getName());
		rating1.setText(em.getAddress());
		id1.setText(em.getId());
		Service ser = moc.serviceObj.empCost(serv,em.getId());
		cost.setText(ser.getCharges());
	}
	
}