package sms.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sms.controller.maintenanceOffice;
import sms.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hireRC {
	@FXML
	public GridPane empGrid;
	public List<Employee> emps;
	public List<Pane> paneArr = new ArrayList<>();



	public maintenanceOffice moc = new maintenanceOffice();
	
	public void initialize() throws IOException
	{
		int col = 0;
		int rows = 1;
		List<Employee> list2 = employees();
		emps = new ArrayList(list2);
		try {
			for (int i = 0 ; i < emps.size() ; i++)
			{
				FXMLLoader fl = new FXMLLoader();
				fl.setLocation(getClass().getResource("thumbnail.fxml"));
				Pane pan = fl.load();
				paneArr.add(pan);
				thumbnailC tc = fl.getController();
				tc.setData(emps.get(i));

				if (col == 4)
				{
					col = 0;
					++rows;
				}
				empGrid.add(pan, col++, rows);
				empGrid.setMargin(pan,new Insets(10));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public List<Employee> employees()
	{
		List<Employee> list1 = moc.employeeObj.getEmployees();
		for (int i = 0 ; i < list1.size() ; i++)
		{
			//System.out.println(list1.get(i).getName());
		}
		return list1;
	}
}
