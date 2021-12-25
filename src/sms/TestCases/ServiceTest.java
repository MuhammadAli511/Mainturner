package sms.TestCases;
import sms.model.Service;

import static org.junit.Assert.*;

import org.junit.Test;
import sms.controller.maintenanceOffice;

public class ServiceTest {
    public maintenanceOffice moc = new maintenanceOffice();

    @Test
    public void registerServicePassed(){
        String[] expected = new String[4];
        Service ser = new Service();
        expected[0]="Plumber";
        expected[1]="I'm a plumber";
        expected[2]="5";
        expected[3]="1000";
        ser.setServiceName(expected[0]);
        ser.setServiceDescription(expected[1]);
        ser.setExperience(expected[2]);
        ser.setCharges(expected[3]);
        Boolean status = false;
        if(ser.checkServiceDetails(ser)) {
            assertTrue(status = moc.serviceObj.registerService(ser, "1"));
        }
        else{
            assertTrue(status);
        }
    }

    @Test
    public void registerServiceFailed(){
        String[] expected = new String[4];
        Service ser = new Service();
        expected[0]="Plumber";
        expected[1]="I'm a plumber";
        expected[2]="5";
        expected[3]="";         //Charges Missing
        ser.setServiceName(expected[0]);
        ser.setServiceDescription(expected[1]);
        ser.setExperience(expected[2]);
        ser.setCharges(expected[3]);
        Boolean status = false;
        if(ser.checkServiceDetails(ser)) {
            assertFalse(status = moc.serviceObj.registerService(ser, "1"));
        }
        else{
            assertTrue(status);
        }
    }
}