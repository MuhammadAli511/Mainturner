package sms.TestCases;



import org.junit.Assert;
import sms.model.Account;
import sms.model.Employee;
import org.junit.Test;
import sms.controller.maintenanceOffice;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class EmployeeTest {
    public maintenanceOffice moc = new maintenanceOffice();

    @Test
    public void addEmployeePassed(){
        String[] expected = new String[7];
        Account user = new Account();
        Employee tempEmp = new Employee();
        expected[0]="bilal@gmail.com";
        expected[1]="bilal123";
        expected[2]="bilal";
        expected[3]="20";
        expected[4]="0321";
        expected[5]="34202";
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
                assertTrue(status2 = moc.employeeObj.addEmployee(tempEmp, user));
            }
            else{
                assertTrue(status2);
            }
        }
    }

    @Test
    public void addEmployeeFailed(){
        String[] expected = new String[7];
        Account user = new Account();
        Employee tempEmp = new Employee();
        expected[0]="bilal@gmail.com";
        expected[1]="bilal123";
        expected[2]="bilal";
        expected[3]="20";
        expected[4]="";         //Phone missing
        expected[5]="34202";
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
                assertFalse(status2 = moc.employeeObj.addEmployee(tempEmp, user));
            }
            else{
                assertTrue(status2);
            }
        }
    }
}