package sms.services;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import sms.model.Account;
import sms.model.Employee;
import sms.model.Employer;


public class fileHandler extends persistenceHandler {
    public Boolean findEmployee(Account acc) {
        try {
            File myObj = new File("AccountEmployee.txt");
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
    public Boolean findEmployer(Account acc) {
        try {
            File myObj = new File("AccountEmployer.txt");
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

    public Boolean findAdmin(Account acc) {
        try {
            File myObj = new File("AccountAdmin.txt");
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

    public Boolean checkUser(Account acc) {
        try {
            File myObj = new File("AccountAdmin.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if (dataArr[1].equals(acc.getEmail()) == true){
                    return false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("AccountEmployer.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if (dataArr[1].equals(acc.getEmail()) == true){
                    return false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("AccountEmployee.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArr = data.split(",");
                if (dataArr[1].equals(acc.getEmail()) == true){
                    return false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }
    public String getIndex(String filename)
    {
        try {
            File read_File = new File(filename);
            Scanner read_Input = new Scanner(read_File);
            int index = 0;
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                index = Integer.valueOf(data_Arr[0]);
            }
            index++;
            String indexS = Integer.toString(index);
            return indexS;
        } catch (FileNotFoundException error) {
            return "1";
        }
    }
    public String saveEmployerAccount(Account acc) {
        String index = "";
        try {
            FileWriter write_Data = new FileWriter("AccountEmployer.txt",true);
            index = getIndex("AccountEmployer.txt");
            String writing_Data = "";
            writing_Data = index+","+acc.getEmail()+","+acc.getPassword();
            writing_Data += "\n";
            write_Data.write(writing_Data);
            write_Data.close();
        } catch (IOException error) {
            System.out.println("File Writting error");
        }
        return index;
    }
    public String saveEmployeeAccount(Account acc) {
        String index = "";
        try {
            FileWriter write_Data = new FileWriter("AccountEmployee.txt",true);
            index = getIndex("AccountEmployee.txt");
            String writing_Data = "";
            writing_Data = index+","+acc.getEmail()+","+acc.getPassword();
            writing_Data += "\n";
            write_Data.write(writing_Data);
            write_Data.close();
        } catch (IOException error) {
            System.out.println("File Writting error");
        }
        return index;
    }

    public Boolean saveEmployer(Employer acc,Account acc1) {
        try {
            acc.setAccountID(saveEmployerAccount(acc1));
            String index;
            FileWriter write_Data = new FileWriter("Employer.txt",true);
            index = getIndex("Employer.txt");
            String writing_Data = "";
            writing_Data = index+","+acc.getName()+","+acc.getCnic()+","+acc.getAge()+","+acc.getAddress()+","+acc.getPhone()+","+acc.getAccountID();
            writing_Data += "\n";
            write_Data.write(writing_Data);
            write_Data.close();
        } catch (IOException error) {
            System.out.println("File Writting error");
        }
        return true;
    }
    public Boolean saveEmployee(Employee acc,Account acc1) {
        try {
            String index;
            acc.setAccountID(saveEmployeeAccount(acc1));
            FileWriter write_Data = new FileWriter("Employee.txt",true);
            index = getIndex("Employee.txt");
            String writing_Data = "";
            writing_Data = index+","+acc.getName()+","+acc.getCnic()+","+acc.getAge()+","+acc.getAddress()+","+acc.getPhone()+","+acc.getAccountID();
            writing_Data += "\n";
            write_Data.write(writing_Data);
            write_Data.close();
        } catch (IOException error) {
            System.out.println("File Writting error");
        }
        return true;
    }
}
