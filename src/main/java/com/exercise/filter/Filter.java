package com.exercise.filter;

import java.util.List;

import com.exercise.Person;

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
