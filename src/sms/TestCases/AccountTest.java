package sms.TestCases;

import org.junit.Test;
import sms.controller.maintenanceOffice;
import sms.model.Account;

import static org.junit.Assert.*;

public class AccountTest {
    public maintenanceOffice moc = new maintenanceOffice();

    @Test
    public void logInPassed() {
        Account user = new Account();
        String[] expected = new String[2];
        expected[0] = "saroosh@gmail.com";
        expected[1] = "saroosh123";
        user.setEmail(expected[0]);
        user.setPassword(expected[1]);
        Boolean status;
        assertTrue(status = moc.accountObj.loginAdmin(user));
    }

    @Test
    public void logInfailed() {
        Account user = new Account();
        String[] expected = new String[2];
        expected[0] = "saroosh@gmail.com";
        expected[1] = "saroosh321";         //wrong password
        user.setEmail(expected[0]);
        user.setPassword(expected[1]);
        Boolean status;
        assertTrue(status = moc.accountObj.loginAdmin(user));
    }

    @Test
    public void signUpPassed() {
        Account user = new Account();
        String[] expected = new String[2];
        expected[0] = "hamza@gmail.com";
        expected[1] = "hamza123";
        user.setEmail(expected[0]);
        user.setPassword(expected[1]);
        Boolean status;
        assertTrue(status = moc.accountObj.signUpUser(user));
    }

    @Test
    public void signUpFailed() {
        Account user = new Account();
        String[] expected = new String[2];
        expected[0] = "ali123@gmail.com";      //Already have account with this email
        expected[1] = "ali123";
        user.setEmail(expected[0]);
        user.setPassword(expected[1]);
        Boolean status;
        assertTrue(status = moc.accountObj.signUpUser(user));
    }
}