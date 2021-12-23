package sms.services;
import java.io.*;
import java.util.*;
import sms.model.Account;

public class fileHandler extends persistenceHandler{
    public void checkUser(Account acc)
    {
        try{
            BufferedReader in = new BufferedReader(new FileReader("Account.txt"));
            String str;
            while ((str = in.readLine())!= null) {
                System.out.println(str);
                String[] data_Arr = str.split(",");
                if (data_Arr[1].equals(acc.getEmail()) == true && data_Arr[2].equals(acc.getPassword()) == true) {
                    System.out.println("Logged In");
                    break;
                }
                System.out.println("Clicked");
            }
            in.close();
        } catch(IOException error){}
    }

}
