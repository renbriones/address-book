package com.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter implementation to retrieve list of males
 * 
 * @author IBriones
 * 
 */
public class MaleFilter implements Filter
{

    @Override
    public List<Person> filterList(List<Person> persons)
    {
        List<Person> male = new ArrayList<Person>();

        if (persons != null)
        {
            for (Person person : persons)
            {
                if ("MALE".equalsIgnoreCase(person.getGender()))
                {
                    male.add(person);
                }
            }
        }

        return male;
    }
}
