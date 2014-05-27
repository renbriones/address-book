package com.exercise;

import java.util.Date;

/**
 * 
 * @author IBriones
 * 
 */
public class Person
{
    private String name;
    private String gender;
    private Date dateOfBirth;

    public Person(String name, String gender, Date dateOfBirth)
    {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

}
