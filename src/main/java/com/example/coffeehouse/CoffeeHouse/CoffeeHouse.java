package com.example.coffeehouse.CoffeeHouse;

import com.example.coffeehouse.Menu.Menu;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "coffeehouse")
public class CoffeeHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coffeeHouseId;
    private String name;
    private String schedule;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(columnDefinition = "TEXT")
    private String info;

    @OneToMany(mappedBy = "coffeeHouse")
    @JsonBackReference
    private Set<Menu> menus;

    //constructors, getters, setters

    public CoffeeHouse(Long coffeeHouseId, String name, String schedule, LocalDate dateCreated, String info)
    {
        this.coffeeHouseId = coffeeHouseId;
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

    public Long getCoffeeHouseId()
    {
        return coffeeHouseId;
    }

    public void setCoffeeHouseId(Long coffeeHouseId)
    {
        this.coffeeHouseId = coffeeHouseId;
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

    public Set<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(Set<Menu> menus)
    {
        this.menus = menus;
    }
}