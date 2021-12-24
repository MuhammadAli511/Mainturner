package sms.model;

import sms.services.fileHandler;
import sms.services.persistenceHandler;

public class Service {
    private String serviceName;
    private String serviceDescription;
    private String experience;
    private String charges;
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
}
