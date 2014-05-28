package com.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author IBriones
 * 
 */
public class AddressBook
{

    private List<Person> persons;

    public AddressBook()
    {

    }

    public AddressBook(List<Person> persons)
    {
        this.persons = persons;
    }

    public List<Person> getPersons()
    {
        return persons;
    }

    /**
     * Read AddressBook file and parse content
     * 
     * @throws Exception
     */
    public void initAddressBook(String filename) throws Exception
    {
        try
        {

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            InputStream in = classloader.getResourceAsStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            this.persons = new ArrayList<Person>();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                String[] personStr = line.split(",");
                if (personStr.length < 3)
                {
                    // missing data
                    // LOG warning
                    continue;
                }

                try
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date dob = dateFormat.parse(personStr[2]);
                    persons.add(new Person(personStr[0].trim(), personStr[1].trim(), dob));
                }
                catch (ParseException pe)
                {
                    // LOG warning
                    continue;
                }
            }
        }
        catch (IOException ioe)
        {
            // LOG error
            throw ioe;
        }
    }

    /**
     * Find person with passed name
     * 
     * @param name
     * @return the Person
     */
    public Person find(String name)
    {
        if (persons == null || name == null)
        {
            return null;
        }

        for (Person person : persons)
        {
            if (person.getName() != null && person.getName().contains(name))
            {
                return person;
            }
        }

        return null;
    }

    /**
     * Filter List
     * 
     * @param filter
     * @return the filtered list
     */
    public List<Person> filter(Filter filter)
    {
        return filter.filterList(persons);
    }

    /**
     * Sorts List of Person
     * 
     * @param comparator
     */
    public void sort(Comparator<Person> comparator)
    {
        if (persons != null)
        {
            Collections.sort(persons, new PersonDOBComparator());
        }
    }
}
