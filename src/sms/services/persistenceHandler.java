package sms.services;
import sms.model.Account;
import sms.model.Employee;
import sms.model.Employer;
import sms.model.Service;

import java.util.List;

public abstract class persistenceHandler {
    public abstract Boolean findEmployee(Account acc);
    public abstract Boolean findEmployer(Account acc);
    public abstract Boolean findAdmin(Account acc);
    public abstract Boolean checkUser(Account acc);
    public abstract Boolean saveEmployer(Employer acc,Account acc1);
    public abstract Boolean saveEmployee(Employee acc,Account acc1);
    public abstract String saveEmployerAccount(Account acc);
    public abstract String saveEmployeeAccount(Account acc);
    public abstract String getEmployee1(Account acc);
    public abstract String getEmployer1(Account user);
    public abstract Boolean addService(Service serv, String user);
    public abstract List getAllData(String serviceName);
    public abstract Service empCosts(String serv,String user);
    public abstract Employee getEmployee2(String id);
    public abstract Boolean saveBooking(String user);
}
