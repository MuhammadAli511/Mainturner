package sms.model;

import sms.services.fileHandler;
import sms.services.persistenceHandler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "employerID")
    private String employerID;
    @Column(name = "employeeID")
    private String employeeID;
    @Column(name = "serviceID")
    private String serviceID;
    @Column(name = "timeData")
    private String time;

    public persistenceHandler ph = new fileHandler();
    public Booking(){}
    public Booking(String employeeID,String employerID,String serviceID,String time)
    {
        this.employerID = employerID;
        this.employeeID = employeeID;
        this.serviceID = serviceID;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployerID() {
        return employerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Boolean addBooking(String user) {
        Boolean status = ph.saveBooking(user);
        return status;
    }
}
