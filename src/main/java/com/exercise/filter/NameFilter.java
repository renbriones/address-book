package com.exercise.filter;

import java.util.ArrayList;
import java.util.List;

import com.exercise.Person;

/**
 * Filter implementations to get list of person containing a specific name
 * 
 * @author IBriones
 * 
 */
public class NameFilter implements Filter
{
    private String queryStr;

    public NameFilter(String queryStr)
    {
        this.queryStr = queryStr;
    }

    @Override
    public List<Person> filterList(List<Person> persons)
    {
        List<Person> result = new ArrayList<Person>();

        if (persons != null && queryStr != null)
        {
            for (Person person : persons)
            {
                if (person.getName() != null && person.getName().contains(queryStr))
                {
                    result.add(person);
                }
            }
        }

        return result;
    }

}
