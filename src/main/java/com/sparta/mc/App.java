package com.sparta.mc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class App {
    public static void main(String[] args) {
        try {
            String[] employees = EmployeeFactory.getEmployees(20);
            //logger    --  logHowManyEmployeeRecordsRetrieved

            List<Employee> loe = createListofEmployees(employees);
            createEmployeeRecords(loe, employees);
            BinaryTree binaryTree = createBinaryTree(loe);
            String[] lastNamesToSearch = {"Bumgarner", "Rojo", "Jason"};
            searchInBinaryTree(binaryTree, lastNamesToSearch);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

            } else {
                //logger    --  Add_Line_BADRECORD_HeaderRecord_Exist_in_csv
            }
        }
    }

    private static BinaryTree createBinaryTree(List<Employee> employeeList) {
        // Convert the list to a binary tree using BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        for (Employee employee : employeeList) {
            binaryTree.insert(employee);
            //logger    --  logLastNamesOfEmployeeRecordsAddedToBinaryTree
        }
        return binaryTree;
    }

    private static void searchInBinaryTree(BinaryTree binaryTree, String[] lastNamesToSearch) {

        for (int i = 0; i < lastNamesToSearch.length; i++) {
            Employee foundEmployee = binaryTree.search(lastNamesToSearch[i]);

            if (foundEmployee != null) {
                System.out.println("Employee found: " + foundEmployee.toString());
            } else {
                System.out.println("Employee not found.");
                //logger    --  SearchRetrievedNoRecords
            }
        }
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
