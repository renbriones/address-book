package com.exercise;

import java.util.Comparator;

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
}
