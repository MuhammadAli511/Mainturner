package sms.view;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sms.controller.maintenanceOffice;
import sms.model.Booking;
import sms.model.Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class employeeInfoC {

    @FXML
    public Label nameU;
    public Label base_Charges;
    public Label total_Charges;
    public Button viewD;
    public Button proceed;
    public Label book;
    public maintenanceOffice moc = new maintenanceOffice();

    ObservableList<String> hoursList = FXCollections.observableArrayList();
    ObservableList<String> ap = FXCollections.observableArrayList();
    public JFXComboBox<String> hourSBox;
    public JFXComboBox<String> apSBox;
    public JFXComboBox<String> hourEBox;
    public JFXComboBox<String> apEBox;

    @FXML
    public void initialize()
    {
        for (int i = 1 ; i <= 12 ; i++)
        {
            String hour = Integer.toString(i);
            hoursList.add(hour);
        }
        ap.add("am");
        ap.add("pm");
        hourSBox.setItems(hoursList);
        hourEBox.setItems(hoursList);
        apSBox.setItems(ap);
        apEBox.setItems(ap);
    }

    @FXML
    public void viewDet(MouseEvent click)
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        String[] splitted = user.split(",");
        Employee det = moc.employeeObj.getEmployee2(splitted[5]);

        nameU.setText(det.getName());
        base_Charges.setText(splitted[2]);

    }
    public void proceedPrice(MouseEvent click)
    {
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();
        String[] splitted = user.split(",");


        DateTimeFormatter format = DateTimeFormatter.ofPattern("h:m:s a");

        String temp = hourSBox.getValue();
        temp += ":00:00 ";
        temp += apSBox.getValue();
        LocalTime time1 = LocalTime.parse(temp, format);

        temp = hourEBox.getValue();
        temp += ":00:00 ";
        temp += apEBox.getValue();
        LocalTime time2 = LocalTime.parse(temp, format);
        Duration dur = Duration.between(time1, time2);


        int ho = dur.toHoursPart();
        if (ho < 0)
        {
            ho = ho * (-1);
        }
        String charg = splitted[2];
        int charge = Integer.valueOf(charg);
        int tota = charge * ho;
        String total = Integer.toString(tota);
        total_Charges.setText(total);
    }

    public void bookService(MouseEvent click) throws IOException {
        /*Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String user = (String) stage.getUserData();*/
        String jdbUrl = "jdbc:mysql://sdaap.cfmxryk2j8qq.us-east-2.rds.amazonaws.com:3306/testDB?useSSL=false";
        String user = "admin";
        String pass = "UqaKCKi1A8tr2Mc2e5Xr";
        try{
            Connection myConn = DriverManager.getConnection(jdbUrl,user,pass);
            System.out.println("Connection Successfull");
        } catch(Exception exc){};
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Booking.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            Booking book = new Booking("4","4","4","8:00am-10:00am,28/12/2021");
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            System.out.println("Object Added");
        } finally{
            factory.close();
        }

        Parent ma = FXMLLoader.load(getClass().getResource("employerWelcome.fxml"));
        Stage window = (Stage) book.getScene().getWindow();
        window.setScene(new Scene(ma));

    }


}
