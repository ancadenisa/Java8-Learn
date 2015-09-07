package DateTimeApi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Usages.java
 * Created by Anca.Barbu on 8/26/2015.
 */
public class Usages {
    public static void main(String[] args) {

        //today's date
        LocalDate today = LocalDate.now();
        System.out.println("Today's local date J8 :" + today);

        System.out.println("Today's local date J7 :" + new Date());

        //get time
        LocalTime time = LocalTime.now(); System.out.println("local time now : " + time);


        //get date, time and year
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

        //get a particular date
        //***dates are represented in the way you write, not like in J7
        //where for example months start from 0
        LocalDate dateOfBirth = LocalDate.of(1993, 11, 11);
        System.out.println("I was born on " + dateOfBirth);

        //MonthDay usage -- especially for checking for recuring events
        MonthDay birthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        if(birthDay.equals(MonthDay.of(birthDay.getMonth(), birthDay.getDayOfMonth()))) {
            System.out.println("Tadaaam ... this code is working as i excpected");
        }

        //YearMonth usage
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY); System.out.printf("Your credit card expires on %s %n", creditCardExpiry);


        //add hours to time
        //remember that these method return a reference of new LocalTime instance because LocalTime is immutable
        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);

        // Date after 1 year
        LocalDate nextYear = today.plus(1, YEARS); System.out.println("Date after 1 year : " + nextYear);

        //Java 8 has not only separated date from time, but allso timezone
        //represent a particular timezone
        ZoneId istanbul =  ZoneId.of("Turkey");
        ZoneId america  =  ZoneId.of("America/New_York");
        ZoneId london  =  ZoneId.of("Europe/London");

        //get local date and time
        LocalDateTime localDateTime = LocalDateTime.now();

        //convert local date time to specific timezone
        ZonedDateTime dateTimeNY = ZonedDateTime.of(localDateTime, america);
        ZonedDateTime dateTimeIst = ZonedDateTime.of(localDateTime, istanbul);
        ZonedDateTime dateTimeLon = ZonedDateTime.of(localDateTime, london);

        System.out.println("Current date and time in a NY : " + dateTimeNY);
        System.out.println("Current date and time in a Istanbul : " + dateTimeIst);
        System.out.println("Current date and time in a London : " + dateTimeLon);

        //Persiod class Usage
        LocalDate mihaiDateOfBirth = LocalDate.of(1993, Month.NOVEMBER, 5);
        Period betweenBirthdays = Period.between(dateOfBirth, mihaiDateOfBirth);
        System.out.println("Days between our birthdays " + betweenBirthdays.getDays());

        //Formating with butilt in formatter
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);



    }
}
