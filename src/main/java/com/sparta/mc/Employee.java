package com.sparta.mc;

public class Employee {
    int EmpID;
    String NamePrefix;
    String FirstName;
    char MiddleInitial;
    String LastName;
    char Gender;
    String EMail;
    String DateofBirth;
    String DateofJoining;
    int Salary;

    public Employee(int empID, String namePrefix, String firstName, char middleInitial, String lastName, char gender, String EMail, String dateofBirth, String dateofJoining, int salary) {
        EmpID = empID;
        NamePrefix = namePrefix;
        FirstName = firstName;
        MiddleInitial = middleInitial;
        LastName = lastName;
        Gender = gender;
        this.EMail = EMail;
        DateofBirth = dateofBirth;
        DateofJoining = dateofJoining;
        Salary = salary;
    }

    public Employee(String lastName) {
        LastName = lastName;
    }

    public int getEmpID() {
        return EmpID;
    }

    public String getNamePrefix() {
        return NamePrefix;
    }

    public String getFirstName() {
        return FirstName;
    }

    public char getMiddleInitial() {
        return MiddleInitial;
    }

    public String getLastName() {
        return LastName;
    }

    public char getGender() {
        return Gender;
    }

    public String getEMail() {
        return EMail;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public String getDateofJoining() {
        return DateofJoining;
    }

    public int getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmpID='" + EmpID + '\'' +
                ", NamePrefix='" + NamePrefix + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", MiddleInitial='" + MiddleInitial + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", EMail='" + EMail + '\'' +
                ", DateofBirth='" + DateofBirth + '\'' +
                ", DateofJoining='" + DateofJoining + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }
}
