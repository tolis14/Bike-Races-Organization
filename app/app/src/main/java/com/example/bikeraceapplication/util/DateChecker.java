package com.example.bikeraceapplication.util;

import java.util.Date;

public class DateChecker {

    public static boolean isValidateDate(String date,String delimiter){

        String[] dateComponents = date.split(delimiter);

        if(dateComponents.length != 3)
            return false;


        if(dateComponents[0].length() != 2 || dateComponents[1].length() != 2  || dateComponents[2].length() != 4)
            return false;

        int day = Integer.parseInt(dateComponents[0]);
        int month =Integer.parseInt(dateComponents[1]);
        int year = Integer.parseInt(dateComponents[2]);

        if(day < 1 || day > 31)
            return false;

        if(month < 1 || month > 12)
            return false;

        if(month % 2 == 0) {

            if (day > 30)
                return false;

            if(isLeapYear(year)){
                if(day > 29 && month == 2)
                    return false;
            }
            else {
                if (day > 28 && month == 2)
                    return false;
            }
        }
        return true;
    }

    public static boolean isBefore(Date dateBefore, Date dateAfter){

        return dateAfter.after(dateBefore);
    }

    private static boolean isLeapYear(int year){

        if (((year % 4 == 0) && (year % 100!= 0)) || (year % 400 == 0))
            return true;
        return false;
    }

}
