package sms.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sms.model.Employee;

public class thumbnailC {
	@FXML
	private ImageView thumb;
	@FXML
	private Label name1;
	@FXML
	private Label rating1;
	
	public void setData(Employee em)
	{
		Image img1 = new Image(getClass().getResourceAsStream("images/person.jpg"));
		thumb.setImage(img1);
		name1.setText(em.getName());
		rating1.setText(em.getAddress());
	}
	
}