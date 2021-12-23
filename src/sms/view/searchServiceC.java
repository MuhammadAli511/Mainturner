package sms.view;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class searchServiceC {
	@FXML
	private GridPane empGrid;
	/*private List<Employee> emps;
	
	public void initialize()
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
				ThumbnailController tc = fl.getController();
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
		List<Employee> list1 = new ArrayList<>();
		for (int i = 0 ; i < 50 ; i++)
		{
			Employee emp = new Employee();
			emp.setThumbSrc("/img/elec.png");
			emp.setName("Arshad Qasim");
			emp.setRating("4.2");
			list1.add(emp);
		}
		return list1;
	}*/

}
