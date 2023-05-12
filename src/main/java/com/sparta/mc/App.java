package com.sparta.mc;

import com.sparta.mc.logging.config.CustomFormatter;
import com.sparta.mc.logging.config.FileHandlerConfig;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        int numOfEmp = 20;
        String[] lastNamesToSearch = {"Rojo"};
        String[] lastNamesFound=startProcess(numOfEmp,lastNamesToSearch);
    }
    public static String[] startProcess(int numOfEmp,String[] lastNamesToSearch) {
        try {
            employeeLogger();
            String[] employees = EmployeeFactory.getEmployees(numOfEmp);
            //logger    --  logHowManyEmployeeRecordsRetrieved
            logger.log(Level.INFO, "Employee Records Retrieved: "+employees.length);
            List<Employee> loe = createListofEmployees(employees);
            createEmployeeRecords(loe, employees);
            BinaryTree binaryTree = createBinaryTree(loe);
            //String[] lastNamesToSearch = {"Bumgarner", "Rojo1", "Jason1","Abernathy","Rojo"};
            //String[] lastNamesToSearch = {"Rojo"};
            String[] lastNamesFound = searchInBinaryTree(binaryTree, lastNamesToSearch);
            return lastNamesFound;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void employeeLogger(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.setUseParentHandlers(false);

        //logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.addHandler(FileHandlerConfig.getFileHandler());
    }
    private static List<Employee> createListofEmployees(String[] employees) {
        List<Employee> employeeList = new ArrayList<>();
        return employeeList;
    }

    private static void createEmployeeRecords(List<Employee> employeeList, String[] employees) {
        for (int i = 0; i < employees.length; i++) {
            String[] emp = employees[i].split(",");
            int EmpID = 0;
            int Salary = 0;
            String NamePrefix = "";
            String FirstName = "";
            char MiddleInitial;
            String LastName = "";
            char Gender;
            String EMail= "";

            if (!emp[0].equals("Emp ID")) {
                try {
                EmpID = Integer.parseInt(emp[0]);
                NamePrefix = emp[1];
                FirstName = emp[2];
                MiddleInitial = emp[3].charAt(0);
                LastName = emp[4];
                Gender = emp[5].charAt(0);
                EMail = emp[6];
                Integer.parseInt(emp[9]);

                String DateofBirth = applyDateFormat(emp[7]);
                String DateofJoining = applyDateFormat(emp[8]);
                Employee e = new Employee(EmpID, NamePrefix, FirstName, MiddleInitial, LastName, Gender, EMail, DateofBirth, DateofJoining, Salary);
                employeeList.add(e);
                }catch (NumberFormatException e) {
                    System.err.println("Invalid input format: " + e.getMessage()); //try-catch exception for invalid input format

                }
            } else {
                //logger    --  Add_Line_BADRECORD_HeaderRecord_Exist_in_csv
                logger.log(Level.WARNING, "Employee Records Contain Bad Record: "+emp[0]);
            }
        }
    }

    private static BinaryTree createBinaryTree(List<Employee> employeeList) {
        // Convert the list to a binary tree using BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        for (Employee employee : employeeList) {
            binaryTree.insert(employee);
            //logger    --  logLastNamesOfEmployeeRecordsAddedToBinaryTree
            logger.log(Level.INFO, "Added Employee Record in Binary Tree for: "+employee.getLastName());
        }
        return binaryTree;
    }

    private static String[] searchInBinaryTree(BinaryTree binaryTree, String[] lastNamesToSearch) {
        String[] lastNamesFound =new String [lastNamesToSearch.length];
        for (int i = 0; i < lastNamesToSearch.length; i++) {
            try{
            Employee foundEmployee = binaryTree.search(lastNamesToSearch[i]);

            if (foundEmployee != null) {
                System.out.println("Employee found: " + foundEmployee.toString());
                lastNamesFound[i]=foundEmployee.getLastName();
            } else {
                //System.out.println("Employee not found.");
                //logger    --  SearchRetrievedNoRecords
                logger.log(Level.WARNING, "Not Found in Binary Tree,  Employee: "+lastNamesToSearch[i]);
            }
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid argument passed to search method: " + e.getMessage());//Illegal Argument exception
            }
        }
        return lastNamesFound;
    }

    private static String applyDateFormat(String d1) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        String newDateString;

        try {
            Date d = sdf.parse(d1);
            sdf.applyPattern("yyyy-mm-dd");
            newDateString = sdf.format(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return newDateString;
    }
}
