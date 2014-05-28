package com.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author IBriones
 * 
 */
public class AddressBook
{

    private List<Person> persons;

    public AddressBook(List<Person> persons)
    {
        this.persons = persons;
    }

    public List<Person> getPersons()
    {
        return persons;
    }

    /**
     * 
     * @param name
     * @return
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

    public List<Person> filter(Filter filter)
    {
        return filter.filterList(persons);
    }

    public void sort(Comparator<Person> comparator)
    {
        Collections.sort(persons, new PersonDOBComparator());
    }
}
