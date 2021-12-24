package sms.model;

import sms.services.fileHandler;
import sms.services.persistenceHandler;
public class Account {

    private String email;
    private String password;
    public persistenceHandler ph = new fileHandler();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Boolean loginEmployer(Account user) {
        Boolean status = ph.findEmployer(user);
        return status;
    }
    public Boolean loginEmployee(Account user) {
        Boolean status = ph.findEmployee(user);
        return status;
    }

    public Boolean loginAdmin(Account user) {
        Boolean status = ph.findAdmin(user);
        return status;
    }

    public Boolean signUpUser(Account user) {
        Boolean status = ph.checkUser(user);
        return status;
    }

}
