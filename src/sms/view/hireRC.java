package sms.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import sms.model.Employee;
import sms.model.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hireRC {
	@FXML
	public GridPane empGrid;
	public List<Employee> displayEmp;
	ObservableList<String> serviceNameList = FXCollections.observableArrayList();
	public JFXComboBox<String> serviceNameBox;
	public Button search;
	public ToggleGroup selected = new ToggleGroup();
	public Button bookOne;
	public String saveName;

	public List<RadioButton> rdArr = new ArrayList<>();
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
		serviceNameBox.setItems(serviceNameList);
	}

	public void searchClick(MouseEvent click) throws IOException
	{
		int columns = 0;
		int rows = 1;
		String serviceName = serviceNameBox.getValue();
		saveName = serviceName;
		List<Employee> employeeList = moc.employeeObj.getEmployees(serviceName);
		displayEmp = new ArrayList(employeeList);
		try {
			for (int i = 0 ; i < displayEmp.size() ; i++)
			{
				FXMLLoader fl = new FXMLLoader();
				fl.setLocation(getClass().getResource("thumbnail.fxml"));
				Pane pan = fl.load();
				thumbnailC tc = fl.getController();
				tc.setData(displayEmp.get(i),serviceName);
				if (columns == 4)
				{
					columns = 0;
					++rows;
				}
				Pane temp = (Pane) pan.getChildren().get(1);
				RadioButton rd = (RadioButton) temp.getChildren().get(5);
				rdArr.add(rd);
				rd.setToggleGroup(selected);
				empGrid.add(pan, columns++, rows);
				empGrid.setMargin(pan,new Insets(10));
			}
		} catch (IOException e) {}
	}

	public void proceedClick(MouseEvent click) throws IOException
	{
		String id1 = "";
		Node node = (Node) click.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		String user = (String) stage.getUserData();
		for (int i = 0 ; i < rdArr.size() ; i++)
		{
			if (rdArr.get(i).isSelected() == true)
			{
				Service tempSer = moc.serviceObj.empCost(saveName,rdArr.get(i).getText());
				String send = tempSer.getId() + "," + tempSer.getServiceName() + "," + tempSer.getCharges() + "," + tempSer.getExperience() + ",";
				send += tempSer.getServiceDescription() + "," + tempSer.getEmpID() +","+user ;
				Parent empPage = FXMLLoader.load(getClass().getResource("employeeInfo.fxml"));
				Stage window = (Stage) bookOne.getScene().getWindow();
				window.setUserData(send);
				window.setScene(new Scene(empPage));
			}
		}
	}
}
