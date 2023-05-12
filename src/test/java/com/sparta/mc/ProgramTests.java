package com.sparta.mc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import org.junit.
public class ProgramTests {


    @Test
    @DisplayName("check that it returns lastnames")
    void checkForLastNames(){
        int numOfEmp = 20;
        String[] lastNamesToSearch = {"Bumgarner","Rojo"};
        Assertions.assertArrayEquals(lastNamesToSearch, App.startProcess(numOfEmp,lastNamesToSearch));
    }

    @Test
    @DisplayName("check that test fails as not returning all lastnames")
    void checkForLastNamesNotFound(){
        int numOfEmp = 20;
        String[] lastNamesToSearch = {"Bumgarner","Jason","Abernathy","Rojo"};
        Assertions.assertArrayEquals(lastNamesToSearch, App.startProcess(numOfEmp,lastNamesToSearch));
    }
}
