package sms.TestCases;

import static org.junit.Assert.*;

import javafx.scene.control.RadioButton;
import org.junit.Test;
import sms.model.Account;
import sms.model.Employer;
import sms.controller.maintenanceOffice;

public class EmployerTest {
    public maintenanceOffice moc = new maintenanceOffice();

    @Test
    public void addEmployerPassed(){
        String[] expected = new String[7];
        Account user = new Account();
        Employer tempEmp = new Employer();
        expected[0]="ahmed@gmail.com";
        expected[1]="ahmed123";
        expected[2]="ahmed";
        expected[3]="20";
        expected[4]="0335";
        expected[5]="34205";
        expected[6]="jhelum";
        Boolean status;
        status = moc.accountObj.signUpUser(user);
        if(status){
            tempEmp.setName(expected[2]);
            tempEmp.setAge(expected[3]);
            tempEmp.setPhone(expected[4]);
            tempEmp.setCnic(expected[5]);
            tempEmp.setAddress(expected[6]);
            Boolean status2 = false;
            if(tempEmp.checkPersonalDetails(tempEmp)) {
                assertTrue(status2 = moc.employerObj.addEmployer(tempEmp, user));
            }
            else{
                assertTrue(status2);
            }
        }
    }

    @Test
    public void addEmployerFailed(){
        String[] expected = new String[7];
        Account user = new Account();
        Employer tempEmp = new Employer();
        expected[0]="ahmed@gmail.com";
        expected[1]="ahmed123";
        expected[2]="ahmed";
        expected[3]="20";
        expected[4]="0324";
        expected[5]="";             //CNIC missing
        expected[6]="jhelum";
        Boolean status;
        status = moc.accountObj.signUpUser(user);
        if(status){
            tempEmp.setName(expected[2]);
            tempEmp.setAge(expected[3]);
            tempEmp.setPhone(expected[4]);
            tempEmp.setCnic(expected[5]);
            tempEmp.setAddress(expected[6]);
            Boolean status2 = false;
            if(tempEmp.checkPersonalDetails(tempEmp)) {
                assertFalse(status2 = moc.employerObj.addEmployer(tempEmp, user));
            }
            else{
                assertTrue(status2);
            }
        }
    }
}