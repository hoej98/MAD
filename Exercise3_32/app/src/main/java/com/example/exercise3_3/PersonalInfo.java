package com.example.exercise3_3;

public class PersonalInfo {
    private String name_ = "Not Available";
    private String description_ = "Not Available";
    private Integer id_ = 0;
    public int imageResourceId;

    public PersonalInfo(String name, String description, int imgResourceId, Integer id )
    {
        this.name_ = name;
        this.description_ = description;
        this.imageResourceId = imgResourceId;
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
