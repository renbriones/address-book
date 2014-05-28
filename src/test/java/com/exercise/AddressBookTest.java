package com.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class AddressBookTest
{

    @Test
    public void testFind()
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "female", new Date()));
        persons.add(new Person("third person", "female", new Date()));

        AddressBook aBook = new AddressBook(persons);
        Person person = aBook.find("second");

        assertEquals("Found the person", "second person", person.getName());
    }

    @Test
    public void testFindWhenPersonsIsNull()
    {

        AddressBook aBook = new AddressBook(null);
        Person person = aBook.find("second");
        assertNull("Found nothing", person);
    }

    @Test
    public void testFindWhenNameQueryIsNull()
    {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "female", new Date()));
        persons.add(new Person("third person", "female", new Date()));

        AddressBook aBook = new AddressBook(persons);
        Person person = aBook.find(null);
        assertNull("Found nothing", person);
    }

    @Test
    public void testFindWhenOnePersonNameIsNull()
    {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person(null, "female", new Date()));
        persons.add(new Person("third person", "female", new Date()));

        AddressBook aBook = new AddressBook(persons);
        Person person = aBook.find("third");
        assertEquals("Found the person", "third person", person.getName());
    }

    @Test
    public void testFindWhenMoreThanTwoNames()
    {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("first person", "female", new Date()));
        persons.add(new Person("third person", "female", new Date()));

        AddressBook aBook = new AddressBook(persons);
        Person person = aBook.find("first");
        assertEquals("Found the person", "first person", person.getName());
        assertEquals("Found the person", "male", person.getGender());
    }
}
