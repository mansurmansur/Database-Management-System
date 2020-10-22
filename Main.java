//import com.sun.java.util.jar.pack.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;


/**
 * Class name: Main.java
 * Description: the class acts as the user interface for the database PHRC_DBMS.db. this is dabasemanagement
 *              system that gives the user simple instructions to interact with the database.
 * Project: COIS 3400H  Database Management System
 * author: Mansur Mansur
 * Student Id: 0632850
 * */
public class Main {


    //main method
    public static void main(String args[]) throws ClassNotFoundException
    {
      
        //establish the connection
        try{
            //variables
            String table = "", dName = "",hName = "PHRC", sName = "", sPosition = "", dID = "", roomType = "",
                    pName = "", pAddress = " ",filename = "C:\\Sqlite\\db\\PHRC_DBMS.db";
            int  tableNum = 0, dNumStaff = 0, EmployeeId = 0, dnum = 0, roomId = 0, count = 0, i = 0;
            long sContact = 0;

            //scanner
            Scanner scanner, scan, scan1, scan2, scan3;

            Class.forName("org.sqlite.JDBC");
            // connection variable
            Connection c = null;

            //establish the connection
            c = DriverManager.getConnection("jdbc:sqlite:"+filename);


            //create a statement
            Statement statement = c.createStatement();
            ResultSet rs;

            //program name
            System.out.println("***Welcome to PHRC hospital Database Management System***\n");

            while (i != 5) {


                //ask the user for queries
                System.out.println("Choose from the following commands:\n");
                System.out.println("Enter 1 to select all items in a certain table");
                System.out.println("Enter 2 to insert an item into a certain table");
                System.out.println("Enter 3 to Update an item from a certain table ");
                System.out.println("Enter 4 to Delete an item from a certain table");
                System.out.println("Enter 5 to Quit the program");

                //assigning the scanner
                scanner = new Scanner(System.in);


                //validation of entry
                if(!scanner.hasNextInt()){
                    System.out.println("Please enter a number not a letter");
                    scanner.next();
                }else{
                    String name = scanner.nextLine();
                    i = Integer.parseInt(name);
                }




                //correct choice
                if (i == 1) {

                    //choose from the tables
                    System.out.println("to see list of Departments enter 1");
                    System.out.println("to see list of Staff enter 2");
                    System.out.println("to see list of Doctors enter 3");
                    System.out.println("to see list of Nurses enter 4");
                    System.out.println("to see list of Rooms enter 5");
                    System.out.println("to see list of Patients enter 6");
                    System.out.println("to see list of Records enter 7");
                    System.out.println("to see list of Bills enter 8");
                    System.out.println("to see list of Treats enter 9");
                    System.out.println("to see list of Attends enter 10\n");

                    //scanner
                    scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    tableNum = Integer.parseInt(input);

                    //tables
                    if (tableNum == 1) {
                        table = "Department";
                    } else if (tableNum == 2) {
                        table = "Staff";
                    } else if (tableNum == 3) {
                        table = "Doctor";
                    } else if (tableNum == 4) {
                        table = "Nurse";
                    } else if (tableNum == 5) {
                        table = "Room";
                    } else if (tableNum == 6) {
                        table = "Patient";
                    } else if (tableNum == 7) {
                        table = "Record";
                    } else if (tableNum == 8) {
                        table = "Bill";
                    } else if (tableNum == 9) {
                        table = "Treat";
                    } else if (tableNum == 10) {
                        table = "Attend";
                    }

                } else if (i == 2) {
                    //insert an item into a table
                    System.out.println("to insert into a certain table choose from the list below\n");
                    System.out.println("for Department enter 1, for Staff enter 2, for Doctor enter 3, for Nurse enter 4\n" +
                            "for Room enter 5, for Patient enter 6");


                    //scanner
                    scan1 = new Scanner(System.in);
                    String input1 = scan1.nextLine();
                    tableNum = Integer.parseInt(input1);

                    //tables
                    if (tableNum == 1) {
                        table = "Department";
                        //ask the user to enter the columns
                        System.out.println("Enter department Name : ");
                        scan3 = new Scanner(System.in);
                        String input2 = scan3.nextLine();
                        dName = input2;
                        System.out.println("Enter department Number of staff : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        dNumStaff = Integer.parseInt(input3);

                    } else if (tableNum == 2) {
                        table = "Staff";
                        //ask the user to enter the columns
                        System.out.println("Enter staff Name : ");
                        scan3 = new Scanner(System.in);
                        String input2 = scan3.nextLine();
                        sName = input2;
                        System.out.println("Enter staff Position : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        sPosition = input3;
                        System.out.println("Enter which Id of department that staff belongs to: ");
                        scan3 = new Scanner(System.in);
                        String input5 = scan3.nextLine();
                        dID = input5;
                    } else if (tableNum == 3) {
                        table = "Doctor";
                        System.out.println("Enter EmployeeId : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        EmployeeId = Integer.parseInt(input3);
                    } else if (tableNum == 4) {
                        table = "Nurse";
                        System.out.println("Enter EmployeeId : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        EmployeeId = Integer.parseInt(input3);
                    } else if (tableNum == 5) {
                        table = "Room";
                        System.out.println("Enter Room type : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        roomType = input3;
                    } else if (tableNum == 6) {
                        table = "Patient";
                        //ask the user to enter the columns
                        System.out.println("Enter Patient Name : ");
                        scan3 = new Scanner(System.in);
                        String input2 = scan3.nextLine();
                        pName = input2;
                        System.out.println("Enter Patient Address : ");
                        scan3 = new Scanner(System.in);
                        String input3 = scan3.nextLine();
                        pAddress = input3;

                    }
                } else if (i == 4) {
                    System.out.println("to Delete from a certain table choose from the list below\n");
                    System.out.println("for Department enter 1, for Staff enter 2, for Doctor enter 3, for Nurse enter 4\n" +
                            "for Room enter 5, for Patient enter 6");

                    //scanner
                    scan1 = new Scanner(System.in);
                    String input1 = scan1.nextLine();
                    tableNum = Integer.parseInt(input1);

                    //tables
                    if (tableNum == 1) {
                        table = "Department";
                        System.out.println("to Delete from Department choose one item from dName column from the list below\n");

                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        dName = input2;


                    } else if (tableNum == 2) {
                        table = "Staff";
                        System.out.println("to Delete from Staff choose one item from sName column from the list below\n");


                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input3 = scan1.nextLine();
                        sName = input3;

                    } else if (tableNum == 3) {
                        table = "Doctor";
                        System.out.println("to Delete from Doctor choose one item from EmployeeId column from the list below\n");

                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        EmployeeId = Integer.parseInt(input2);
                    } else if (tableNum == 4) {
                        table = "Nurse";
                        System.out.println("to Delete from Nurse choose one item from EmployeeId column from the list below\n");
                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        EmployeeId = Integer.parseInt(input2);
                    } else if (tableNum == 5) {
                        table = "Room";
                        System.out.println("to Delete from Room choose one item from RoomId column from the list below\n");
                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        roomId = Integer.parseInt(input2);
                    } else if (tableNum == 6) {
                        table = "Patient";
                        System.out.println("to Delete from PatientId choose one item from pName column from the list below\n");
                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        pName = input2;
                    }

                } else if (i == 3) {
                    System.out.println("to Update from a certain table choose from the list below\n");
                    System.out.println("for Department enter 1, for Staff enter 2, for Doctor enter 3, for Nurse enter 4\n" +
                            "for Room enter 5, for Patient enter 6");

                    //scanner
                    scan1 = new Scanner(System.in);
                    String input1 = scan1.nextLine();
                    tableNum = Integer.parseInt(input1);

                    //tables
                    if (tableNum == 1) {
                        table = "Department";
                        System.out.println("to Update from Department choose one item from dName column from the list below\n");

                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        dName = input2;


                    } else if (tableNum == 2) {
                        table = "Staff";
                        System.out.println("to Update from Staff choose one item from sName column from the list below\n");


                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input3 = scan1.nextLine();
                        sName = input3;

                    } else if (tableNum == 5) {
                        table = "Room";
                        System.out.println("to Update from Room choose one item from RoomId column from the list below\n");
                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        roomId = Integer.parseInt(input2);
                    } else if (tableNum == 6) {
                        table = "Patient";
                        System.out.println("to Update from PatientId choose one item from pName column from the list below\n");
                        //print out all
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }

                        System.out.println(" ");

                        //scanner
                        scan1 = new Scanner(System.in);
                        String input2 = scan1.nextLine();
                        pName = input2;
                    }


                }


                //switch cases
                switch (i) {

                    case 1:
                        //print out
                        String sql = "SELECT * FROM " + table;
                        rs = statement.executeQuery(sql);

                        //while the result set has a next row set values equal to the variables below and print
                        while (rs.next()) {
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
                            int colNum = resultSetMetaData.getColumnCount();


                            //loop that goes through each column
                            for (int a = 1; a <= colNum; a++) {

                                String colVal = rs.getString(a);
                                System.out.print(resultSetMetaData.getColumnName(a) + ": " + colVal + " ");
                            }

                            System.out.println(" ");
                        }
                        break;
                    case 2:
                        if (tableNum == 1) {
                            String insert = "INSERT INTO " + table + "(dName, dNumStaff, hName) VALUES (?,?,?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, dName);
                            pr.setString(2, " " + dNumStaff);
                            pr.setString(3, hName);

                            pr.execute();

                            //print out
                            System.out.print("The department is successfully added");

                        } else if (tableNum == 2) {
                            String insert = "INSERT INTO " + table + "(sName, sPosition, dID) VALUES (?,?,?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, sName);
                            pr.setString(2, sPosition);
                            pr.setString(3, dID);

                            pr.execute();

                            //print out
                            System.out.print("The staff is successfully added");
                        } else if (tableNum == 3) {
                            String insert = "INSERT INTO " + table + "(EmployeeId) VALUES (?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, "" + EmployeeId);

                            pr.execute();
                            //print out
                            System.out.print("The doctor is successfully added");
                        } else if (tableNum == 4) {
                            String insert = "INSERT INTO " + table + "(EmployeeId) VALUES (?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, "" + EmployeeId);

                            pr.execute();
                            //print out
                            System.out.print("The Nurse is successfully added");
                        } else if (tableNum == 5) {
                            String insert = "INSERT INTO " + table + "(rType, rHname) VALUES (?,?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, "" + roomType);
                            pr.setString(2, "" + hName);

                            pr.execute();
                            //print out
                            System.out.print("The Room is successfully added");
                        } else if (tableNum == 6) {
                            String insert = "INSERT INTO " + table + "(pName, pAddress, pHName) VALUES (?,?,?)";
                            PreparedStatement pr = c.prepareStatement(insert);
                            pr.setString(1, pName);
                            pr.setString(2, pAddress);
                            pr.setString(2, hName);

                            pr.execute();
                            //print out
                            System.out.print("The Patient is successfully added");
                        }
                        break;
                    case 3:
                        if (tableNum == 1) {
                            String delete = "UPDATE " + table + " SET dNumStaff = '10' WHERE dName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, dName);

                            pr.execute();
                        } else if (tableNum == 2) {
                            String delete = "UPDATE " + table + " SET sPosition = 'nurse' WHERE sName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, sName);

                            pr.execute();

                        } else if (tableNum == 5) {
                            String delete = "UPDATE " + table + " SET rType = double WHERE RoomId == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, "" + roomId);

                            pr.execute();
                        } else if (tableNum == 6) {
                            String delete = "UPDATE " + table + " SET pRoom = '109' WHERE pName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, pName);

                            pr.execute();

                        }
                        break;
                    case 4:
                        if (tableNum == 1) {
                            String delete = "DELETE FROM " + table + " WHERE dName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, dName);

                            pr.execute();
                        } else if (tableNum == 2) {
                            String delete = "DELETE FROM " + table + " WHERE sName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, sName);

                            pr.execute();
                        } else if (tableNum == 3) {
                            String delete = "DELETE FROM " + table + " WHERE EmployeeId == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, "" + EmployeeId);

                            pr.execute();

                        } else if (tableNum == 4) {
                            String delete = "DELETE FROM " + table + " WHERE EmployeeId == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, "" + EmployeeId);

                            pr.execute();
                        } else if (tableNum == 5) {
                            String delete = "DELETE FROM " + table + " WHERE RoomId == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, "" + roomId);

                            pr.execute();
                        } else if (tableNum == 6) {
                            String delete = "DELETE FROM " + table + " WHERE pName == ?";
                            PreparedStatement pr = c.prepareStatement(delete);
                            pr.setString(1, pName);

                            pr.execute();

                        }
                        break;


                }
            }

            c.close();
        } catch (SQLException e){

            System.err.println(e.getMessage());
        }
    }

}
