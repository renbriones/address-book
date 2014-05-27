package com.exercise;

import java.util.List;

/**
 * Filter interface for manipulating the List of Person.
 * 
 * @author IBriones
 * 
 */
public interface Filter
{
    List<Person> filterList(List<Person> persons);
}
