package com.exercise.comparator;

import java.util.Comparator;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.exercise.Person;

/**
 * Comparator class for Person.<br/>
 * This compares two persons' date of birth.
 * 
 * @author IBriones
 * 
 */
public class PersonDOBComparator implements Comparator<Person>
{
    @Override
    public int compare(Person person1, Person person2)
    {
        if (person1.getDateOfBirth() == null && person2.getDateOfBirth() == null)
        {
            return 0;
        }
        if (person1.getDateOfBirth() == null)
        {
            return 1;
        }
        if (person2.getDateOfBirth() == null)
        {
            return -1;
        }

        return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
    }

    /**
     * Compare the date of birth and return the difference in days
     * <p>
     * Return 0 if any of the passed parameter is null or any of the date of birth is null
     * else it returns the days between two date of birth. Negative value indicates that
     * second person/parameter is older than first person/parameter.
     * 
     * @param person1
     * @param person2
     * @return
     */
    public int getDifferenceOfDOBByDays(Person person1, Person person2)
    {
        if (person1 == null || person2 == null)
        {
            return 0;
        }
        if (person1.getDateOfBirth() == null || person2.getDateOfBirth() == null)
        {
            return 0;
        }

        return Days.daysBetween(
                new DateTime(person1.getDateOfBirth()),
                new DateTime(person2.getDateOfBirth())).getDays();
    }
}
