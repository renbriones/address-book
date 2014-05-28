package com.exercise.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.exercise.Person;
import com.exercise.filter.NameFilter;

/**
 * 
 * @author IBriones
 * 
 */
public class NameFilterTest
{

    @Test
    public void testFilterList() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "female", new Date()));
        persons.add(new Person("third person", "male", new Date()));

        NameFilter nameFilter = new NameFilter("second");

        List<Person> result = nameFilter.filterList(persons);

        assertNotNull("Found person in list", result);
        assertEquals(1, result.size());
        assertEquals("second person", result.get(0).getName());

    }

    @Test
    public void testFilterListWithPersonSharingAName() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "female", new Date()));
        persons.add(new Person("third person", "male", new Date()));
        persons.add(new Person("third person2", "male", new Date()));

        NameFilter nameFilter = new NameFilter("third");

        List<Person> result = nameFilter.filterList(persons);

        assertNotNull("Found persons in list", result);
        assertEquals(2, result.size());
        assertEquals("third person", result.get(0).getName());
        assertEquals("third person2", result.get(1).getName());
    }

    @Test
    public void testFilterListWhenPersonsIsNull() throws Exception
    {
        List<Person> persons = null;

        NameFilter nameFilter = new NameFilter("third");

        List<Person> result = nameFilter.filterList(persons);

        assertEquals("No person found", 0, result.size());
    }

    @Test
    public void testFilterListWhenPersonsIsEmpty() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();

        NameFilter nameFilter = new NameFilter("third");

        List<Person> result = nameFilter.filterList(persons);

        assertEquals("No person found", 0, result.size());
    }

    @Test
    public void testFilterListWhenStringQueryIsNull() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));

        NameFilter nameFilter = new NameFilter(null);

        List<Person> result = nameFilter.filterList(persons);

        assertEquals("No person found", 0, result.size());
    }
}
