package sms.services;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import sms.model.Account;



public class fileHandler extends persistenceHandler {
    public Boolean checkUser(Account acc) {
        try {
            File myObj = new File("Account.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if (dataArr[1].equals(acc.getEmail()) == true && dataArr[2].equals(acc.getPassword()) == true){
                    return true;
                }
                else if (dataArr[1].equals(acc.getEmail()) == true && dataArr[2].equals(acc.getPassword()) == false)
                {
                    return false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
