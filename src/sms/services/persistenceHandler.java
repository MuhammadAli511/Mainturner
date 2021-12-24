package sms.services;
import sms.model.Account;
import sms.model.Employee;
import sms.model.Employer;

public abstract class persistenceHandler {
    public abstract Boolean findEmployee(Account acc);
    public abstract Boolean findEmployer(Account acc);
    public abstract Boolean findAdmin(Account acc);
    public abstract Boolean checkUser(Account acc);
    public abstract Boolean saveEmployer(Employer acc,Account acc1);
    public abstract Boolean saveEmployee(Employee acc,Account acc1);
    public abstract String saveEmployerAccount(Account acc);
    public abstract String saveEmployeeAccount(Account acc);
}
