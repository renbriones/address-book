package com.exercise;

import java.util.List;

import com.exercise.comparator.PersonDOBComparator;
import com.exercise.filter.MaleFilter;
import com.exercise.filter.NameFilter;

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
            PersonDOBComparator dobComparator = new PersonDOBComparator();
            addressBook.sort(dobComparator);
            System.out.println("Q: Who is the oldest person in the address book?");
            System.out.println("A: " + addressBook.getPersons().get(0).getName());

            // 3. compare two date of birth
            List<Person> personsNameBill = addressBook.filter(new NameFilter("Bill"));
            List<Person> personsNamePaul = addressBook.filter(new NameFilter("Paul"));

            if (!personsNameBill.isEmpty() && !personsNamePaul.isEmpty())
            {
                int days =
                        dobComparator.getDifferenceOfDOBByDays(
                                personsNameBill.get(0),
                                personsNamePaul.get(0));

                System.out.println("Q: How many days older is Bill than Paul?");
                System.out.println("A: " + days);
            }
        }

    }
}
