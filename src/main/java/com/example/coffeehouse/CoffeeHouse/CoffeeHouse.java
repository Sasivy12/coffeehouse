package com.example.coffeehouse.CoffeeHouse;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "coffeehouse")
public class CoffeeHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String schedule;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(columnDefinition = "TEXT")
    private String info;

    public CoffeeHouse(Long id, String name, String schedule, LocalDate dateCreated, String info)
    {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.dateCreated = dateCreated;
        this.info = info;
    }

    public CoffeeHouse(String name, String schedule, LocalDate dateCreated, String info)
    {
        this.name = name;
        this.schedule = schedule;
        this.dateCreated = dateCreated;
        this.info = info;
    }

    public CoffeeHouse()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSchedule()
    {
        return schedule;
    }

    public void setSchedule(String schedule)
    {
        this.schedule = schedule;
    }

    public LocalDate getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }
}