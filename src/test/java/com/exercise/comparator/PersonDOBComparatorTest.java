package com.exercise.comparator;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.exercise.Person;
import com.exercise.comparator.PersonDOBComparator;

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

    @Test
    public void testGetDOBDifferenceInDays() throws Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Person person1 =
                new Person("second person", "female", dateFormat.parse("01/01/81"));
        Person person2 =
                new Person("second person", "female", dateFormat.parse("06/01/81"));

        PersonDOBComparator comparator = new PersonDOBComparator();
        int days = comparator.getDifferenceOfDOBByDays(person1, person2);

        assertEquals("Get date difference", 5, days);
    }

    @Test
    public void testGetDOBDifferenceInDaysWhenPersonIsNull() throws Exception
    {

        PersonDOBComparator comparator = new PersonDOBComparator();
        int days =
                comparator.getDifferenceOfDOBByDays(null, new Person("second person",
                        "female", new Date()));

        assertEquals("No date difference when first person is null", 0, days);

        days =
                comparator.getDifferenceOfDOBByDays(new Person("first person",
                        "female", new Date()), null);

        assertEquals("No date difference when second persion is null", 0, days);

        days =
                comparator.getDifferenceOfDOBByDays(null, null);

        assertEquals("No date difference when both person are null", 0, days);
    }

    @Test
    public void testGetDOBDifferenceInDaysWhenDOBIsNull() throws Exception
    {

        PersonDOBComparator comparator = new PersonDOBComparator();
        int days =
                comparator.getDifferenceOfDOBByDays(new Person("first person",
                        "female", null), new Person("second person",
                        "female", new Date()));

        assertEquals("No date difference when first person DOB is null", 0, days);

        days =
                comparator.getDifferenceOfDOBByDays(new Person("first person",
                        "female", new Date()), new Person("second person",
                        "female", null));

        assertEquals("No date difference when second persion DOB is null", 0, days);

        days =
                comparator.getDifferenceOfDOBByDays(new Person("first person",
                        "female", null), new Person("second person",
                        "female", null));

        assertEquals("No date difference when both DOB are null", 0, days);
    }
}
