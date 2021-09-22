package com.example.exercise3_3;

public class PersonalInfo {
    private String name_ = "Not Available";
    private String description_ = "Not Available";
    private Integer id_ = 0;

    public PersonalInfo(String name, String description, Integer id )
    {
        this.name_ = name;
        this.description_ = description;
        this.id_ = id;
    }

    public String getName()
    {
        return name_;
    }

    public String getDescription()
    {
        return description_;
    }

    public Integer getId()
    {
        return id_;
    }

}
