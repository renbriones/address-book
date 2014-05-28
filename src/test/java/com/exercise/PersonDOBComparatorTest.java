package com.exercise;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author IBriones
 * 
 */
public class PersonDOBComparatorTest
{
    @Test
    public void testCompare() throws Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", dateFormat.parse("01/01/81")));
        persons.add(new Person("second person", "female", dateFormat.parse("01/01/80")));

        Collections.sort(persons, new PersonDOBComparator());
        assertEquals("Second person is oldest", "second person", persons.get(0).getName());
    }

    @Test
    public void testCompareWithNullDateOfBirth() throws Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", dateFormat.parse("01/01/81")));
        persons.add(new Person("second person", "female", null));

        Collections.sort(persons, new PersonDOBComparator());
        assertEquals("First person is oldest", "first person", persons.get(0).getName());

        persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", null));
        persons.add(new Person("second person", "female", dateFormat.parse("01/01/81")));

        Collections.sort(persons, new PersonDOBComparator());
        assertEquals("Second person is oldest", "second person", persons.get(0).getName());

        persons = new ArrayList<Person>();
        persons.add(new Person("first person", "male", dateFormat.parse("01/01/81")));
        persons.add(new Person("second person", "female", null));
        persons.add(new Person("third person", "female", dateFormat.parse("01/01/70")));

        Collections.sort(persons, new PersonDOBComparator());
        assertEquals("Third person is oldest", "third person", persons.get(0).getName());
        assertEquals("first person", persons.get(1).getName());
    }
}
