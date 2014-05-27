package com.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author IBriones
 * 
 */
public class MaleFilterTest
{

    @Test
    public void testFilterList() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "female", new Date()));
        persons.add(new Person("third person", "male", new Date()));

        MaleFilter maleFilter = new MaleFilter();

        List<Person> male = maleFilter.filterList(persons);

        assertNotNull("Found male in list", male);
        assertEquals(2, male.size());
        assertEquals("first person", male.get(0).getName());
        assertEquals("third person", male.get(1).getName());
    }

    @Test
    public void testFilterListWhenGenderIsDifferentCase() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", new Date()));
        persons.add(new Person("second person", "MALE", new Date()));
        persons.add(new Person("third person", "Male", new Date()));

        MaleFilter maleFilter = new MaleFilter();

        List<Person> male = maleFilter.filterList(persons);

        assertNotNull("Found male in list", male);
        assertEquals(3, male.size());
        assertEquals("first person", male.get(0).getName());
        assertEquals("second person", male.get(1).getName());
        assertEquals("third person", male.get(2).getName());
    }

    @Test
    public void testFilterListWhenPersonsIsNull() throws Exception
    {
        List<Person> persons = null;

        MaleFilter maleFilter = new MaleFilter();
        
        List<Person> male = maleFilter.filterList(persons);

        assertEquals("No male in list", 0, male.size());
    }

    @Test
    public void testFilterListWhenPersonsIsEmpty() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        
        MaleFilter maleFilter = new MaleFilter();
        
        List<Person> male = maleFilter.filterList(persons);
        
        assertEquals("No male in list", 0, male.size());
    }

    @Test
    public void testFilterListWhenGenderIsNull() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", null, new Date()));
        
        MaleFilter maleFilter = new MaleFilter();
        
        List<Person> male = maleFilter.filterList(persons);

        assertEquals("No male in list", 0, male.size());
    }
}
