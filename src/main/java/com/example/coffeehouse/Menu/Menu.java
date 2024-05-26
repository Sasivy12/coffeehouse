package com.example.coffeehouse.Menu;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    private String name;

    @OneToOne
    @JoinColumn(name = "coffeehouse_id", referencedColumnName = "id")
    private CoffeeHouse coffeeHouse;

    public Menu(Long m_id, String name, CoffeeHouse coffeeHouse)
    {
        this.m_id = m_id;
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

    public Long getM_id()
    {
        return m_id;
    }

    public void setM_id(Long id)
    {
        this.m_id = m_id;
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
}
