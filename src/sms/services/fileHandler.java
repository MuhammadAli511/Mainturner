package sms.services;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import sms.model.Account;
import sms.model.Employee;
import sms.model.Employer;
import sms.model.Service;


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
                if (data_Arr[0].equals(null) || data_Arr[0].equals(""))
                {
                    return "1";
                }
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
    public String getEmployee1(Account acc)
    {
        String acc_email = acc.getEmail();
        String index = "";
        String ret = "";
        Employee send = new Employee();
        try {
            File read_File = new File("AccountEmployee.txt");
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                if (data_Arr[1].equals(acc_email) == true)
                {
                    index = data_Arr[0];
                }
            }
        } catch (FileNotFoundException error) {}


        try {
            File read_File = new File("Employee.txt");
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                if (data_Arr[6].equals(index) == true)
                {
                    ret = data_Arr[0];
                }
            }
        } catch (FileNotFoundException error) {}
        return ret;
    }

    public Employee getEmployee2(String id)
    {
        try {
            File read_File = new File("Employee.txt");
            Employee em = new Employee();
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                if (data_Arr[0].equals(id) == true)
                {
                    em.setName(data_Arr[1]);
                    em.setCnic(data_Arr[2]);
                    em.setAge(data_Arr[3]);
                    em.setAddress(data_Arr[4]);
                    em.setPhone(data_Arr[5]);
                    return em;
                }
            }
        } catch (FileNotFoundException error) {}
        return null;
    }



    public String getEmployer1(Account acc)
    {
        String acc_email = acc.getEmail();
        String index = "";
        String ret = "";
        Employer send = new Employer();
        try {
            File read_File = new File("AccountEmployer.txt");
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                if (data_Arr[1].equals(acc_email) == true)
                {
                    index = data_Arr[0];
                }
            }
        } catch (FileNotFoundException error) {}


        try {
            File read_File = new File("Employer.txt");
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                if (data_Arr[6].equals(index) == true)
                {
                    ret = data_Arr[0];
                }
            }
        } catch (FileNotFoundException error) {}
        return ret;
    }

    public Boolean addService(Service serv,String id)
    {
        try {
            String index;
            FileWriter write_Data = new FileWriter("Services.txt",true);
            index = getIndex("Services.txt");
            String writing_Data = "";
            writing_Data = index+","+serv.getServiceName()+","+serv.getCharges()+","+serv.getExperience()+","+serv.getServiceDescription()+","+id;
            writing_Data += "\n";
            write_Data.write(writing_Data);
            write_Data.close();
        } catch (IOException error) {
            System.out.println("File Writting error");
        }
        return true;
    }

    public List getAllData(String serviceName)
    {
        List serv = new ArrayList<>();
        try {
            File read_File1 = new File("Services.txt");
            Scanner read_Input1 = new Scanner(read_File1);
            while (read_Input1.hasNextLine()) {
                String read_Line1 = read_Input1.nextLine();
                String[] sep1 = read_Line1.split(",");
                if (sep1[1].equals(serviceName) == true)
                {
                    serv.add(sep1[5]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        List ret = new ArrayList<>();
        try {
            File read_File = new File("Employee.txt");
            Scanner read_Input = new Scanner(read_File);
            while (read_Input.hasNextLine()) {
                String read_Line = read_Input.nextLine();
                String[] data_Arr = read_Line.split(",");
                for (int i = 0 ; i < serv.size() ; i++)
                {
                    if (serv.get(i).equals(data_Arr[0]))
                    {
                        Employee send = new Employee();
                        send.setId(data_Arr[0]);
                        send.setName(data_Arr[1]);
                        send.setCnic(data_Arr[2]);
                        send.setAge(data_Arr[3]);
                        send.setAddress(data_Arr[4]);
                        send.setPhone(data_Arr[5]);
                        send.setAccountID(data_Arr[6]);
                        ret.add(send);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Service empCosts(String serv,String user)
    {
        List serv2 = new ArrayList<>();
        Service ser = new Service();
        try {
            File read_File1 = new File("Services.txt");
            Scanner read_Input1 = new Scanner(read_File1);
            while (read_Input1.hasNextLine()) {
                String read_Line1 = read_Input1.nextLine();
                String[] sep3 = read_Line1.split(",");
                if (sep3[1].equals(serv) == true && sep3[5].equals(user) == true)
                {
                    ser.setId(sep3[0]);
                    ser.setServiceName(sep3[1]);
                    ser.setCharges(sep3[2]);
                    ser.setExperience(sep3[3]);
                    ser.setServiceDescription(sep3[4]);
                    ser.setEmpID(sep3[5]);
                    return ser;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
