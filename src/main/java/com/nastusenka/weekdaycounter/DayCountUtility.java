package com.nastusenka.weekdaycounter;

import com.nastusenka.weekdaycounter.exceptions.InvalidDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayCountUtility {

    private LocalDate initialDate;
    private LocalDate finalDate;

    /**
     * Constructor with parameters validation
     *
     * @param firstParam Date in format YYYY-MM-DD
     * @param secondParam Date in format YYYY-MM-DD
     * @throws InvalidDateException when date is invalid
     */
    public DayCountUtility(String firstParam, String secondParam) throws InvalidDateException {
        firstParam = firstParam.trim();
        secondParam = secondParam.trim();
        LocalDate date1, date2;

        try {
            date1 = LocalDate.parse(firstParam, DateTimeFormatter.ISO_LOCAL_DATE);
            date2 = LocalDate.parse(secondParam, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException(e.getMessage());
        }
        if (date1.isBefore(date2)) {
            this.initialDate = date1;
            this.finalDate = date2;
        } else {
            this.initialDate = date2;
            this.finalDate = date1;
        }
    }

    /**
     * Counts number of Sundays which are the first day of the month
     *
     * @return Number of days
     */
    public int countSundays() {
        LocalDate date = initialDate;
        if (initialDate.getDayOfMonth() != 1) {
            date = initialDate.withDayOfMonth(1).plusMonths(1);
        }

        int counter = 0;
        while (!date.isAfter(finalDate)) {
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                counter++;
            }
            date = date.plusMonths(1);
        }
        return counter;
    }
}
