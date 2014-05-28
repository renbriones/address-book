package com.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Read AddressBook file and answer the following questions:<br/>
 * <br/>
 * 
 * 1 How many males are in the address book?<br/>
 * 2 Who is the oldest person in the address book?<br/>
 * 3 How many days older is Bill than Paul?<br/>
 * 
 * 
 * @author IBriones
 * 
 */
public class AddressBookMain
{
    public static void main(String[] args)
    {
        List<Person> persons = getTestData();
        AddressBook addressBook = new AddressBook(persons);

        // 1. filter all male persons
        List<Person> male = addressBook.filter(new MaleFilter());
        System.out.println("Q: How many males are in the address book?");
        System.out.println("A: " + male.size());

        // 2. sort list by date of birth, oldest comes first
        addressBook.sort(new PersonDOBComparator());
        System.out.println("Q: Who is the oldest person in the address book?");
        System.out.println("A: " + persons.get(0).getName());

        Days days =
                getDays(
                        addressBook.find("Bill").getDateOfBirth(),
                        addressBook.find("Paul").getDateOfBirth());
        System.out.println("Q: How many days older is Bill than Paul?");
        System.out.println("A: " + days.getDays());
    }

    private static Days getDays(Date date1, Date date2)
    {
        return Days.daysBetween(new DateTime(date1), new DateTime(date2));
    }

    // temporary test data
    // TODO:change to retrieve data from file
    private static List<Person> getTestData()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        List<Person> persons = new ArrayList<Person>();
        try
        {
            persons.add(new Person("Paul Robinson", "male", dateFormat.parse("05/01/71")));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        try
        {
            persons.add(new Person("second person", "female",
                    dateFormat.parse("01/01/91")));
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            persons.add(new Person("Bill McKnight", "male", dateFormat.parse("01/01/71")));
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Bill McKnight, Male, 16/03/77
        // Paul Robinson, Male, 15/01/85
        // Gemma Lane, Female, 20/11/91
        // Sarah Stone, Female, 20/09/80
        // Wes Jackson, Male, 14/08/74
        return persons;
    }
}
