package com.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class AddressBookTest
{

    @Test
    public void testInitAddressBook() throws Exception
    {
        AddressBook aBook = new AddressBook();
        aBook.initAddressBook("AddressBookTest");

        List<Person> personNamedGemma = aBook.filter(new NameFilter("Gemma"));
        List<Person> personNamedPaul = aBook.filter(new NameFilter("Paul"));
        List<Person> personNamedSarah = aBook.filter(new NameFilter("Sarah"));

        assertNotNull(aBook.getPersons());
        assertEquals("Found the person", "Gemma Lane", personNamedGemma.get(0).getName());
        assertTrue("Error in date, Will not find Paul", personNamedPaul.isEmpty());
        assertTrue("With missing data, Will not find Sarah", personNamedSarah.isEmpty());
    }
}
