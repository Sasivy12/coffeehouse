package com.example.coffeehouse.Menu;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import com.example.coffeehouse.MenuItem.MenuItem;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "coffeehouse_id")
    private CoffeeHouse coffeeHouse;

    @OneToMany(mappedBy = "menu")
    private Set<MenuItem> menuItems;

    //constructors, getters, setters

    public Menu(Long menuId, String name, CoffeeHouse coffeeHouse)
    {
        this.menuId = menuId;
        this.name = name;
        this.coffeeHouse = coffeeHouse;
    }

    public Menu(String name, CoffeeHouse coffeeHouse)
    {
        this.name = name;
        this.coffeeHouse = coffeeHouse;
    }

    public Menu()
    {

    }

    public Long getMenuId()
    {
        return menuId;
    }

    public void setMenuId(Long menuId)
    {
        this.menuId = menuId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CoffeeHouse getCoffeeHouse()
    {
        return coffeeHouse;
    }

    public void setCoffeeHouse(CoffeeHouse coffeeHouse)
    {
        this.coffeeHouse = coffeeHouse;
    }

    public Set<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }
}