package com.exercise;

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
        AddressBook addressBook = new AddressBook();
        try
        {
            // read content from file
            addressBook.initAddressBook("AddressBook");
        }
        catch (Exception e)
        {
            System.out.println("Failed to initialise address book : "
                    + e.getLocalizedMessage());
        }

        if (addressBook.getPersons() != null)
        {
            // 1. filter all male persons
            List<Person> male = addressBook.filter(new MaleFilter());
            System.out.println("Q: How many males are in the address book?");
            System.out.println("A: " + male.size());

            // 2. sort list by date of birth, oldest comes first
            addressBook.sort(new PersonDOBComparator());
            System.out.println("Q: Who is the oldest person in the address book?");
            System.out.println("A: " + addressBook.getPersons().get(0).getName());

            Days days =
                    getDays(
                            addressBook.find("Bill").getDateOfBirth(),
                            addressBook.find("Paul").getDateOfBirth());
            System.out.println("Q: How many days older is Bill than Paul?");
            System.out.println("A: " + days.getDays());
        }

    }

    private static Days getDays(Date date1, Date date2)
    {
        return Days.daysBetween(new DateTime(date1), new DateTime(date2));
    }
}
