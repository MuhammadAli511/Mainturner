package sms.model;

import sms.services.fileHandler;
import sms.services.persistenceHandler;

public class Service {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String serviceName;
    private String serviceDescription;
    private String experience;
    private String charges;
    private String empID;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public persistenceHandler ph = new fileHandler();

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public Boolean registerService(Service serv, String user) {
        Boolean status = ph.addService(serv,user);
        return status;
    }

    public Service empCost(String serv,String user){
        Service status = ph.empCosts(serv,user);
        return status;
    }
    public boolean checkServiceDetails(Service ser){
        if (ser.getServiceName().equals("") == true || ser.getServiceDescription().equals("") == true || ser.getExperience().equals("") == true || ser.getCharges().equals("") == true)
        {
            return false;
        }
        else{
            return true;
        }
    }
}
