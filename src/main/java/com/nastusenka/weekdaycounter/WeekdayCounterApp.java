package com.nastusenka.weekdaycounter;

import com.nastusenka.weekdaycounter.exceptions.InvalidDateException;

import java.util.Scanner;

public class WeekdayCounterApp {

    public static void main(String args[]) throws InvalidDateException {
        Scanner in = new Scanner(System.in);
        String firstParam,secondParam;
        System.out.println("Enter two dates in following format YYYY-MM-DD: \n" + "Date 1: ");
        firstParam = in.nextLine();
        System.out.println("Date 2: ");
        secondParam = in.nextLine();

        try {
            DayCountUtility dayCountUtility = new DayCountUtility(firstParam, secondParam);
            int count = dayCountUtility.countSundays();
            System.out.println("Number of Sundays which are the first days of the month: " + count);
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }
}
