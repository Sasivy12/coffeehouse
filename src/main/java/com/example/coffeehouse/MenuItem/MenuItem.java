package com.example.coffeehouse.MenuItem;

import com.example.coffeehouse.Menu.Menu;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_item")
public class MenuItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuItemId;
    private String name;
    private String measure_unit;
    private Integer units;

    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private com.example.coffeehouse.Menu.Menu menu;

    public MenuItem(Long menuItemId, String name, String measure_unit, Integer units, byte[] image, Menu menu)
    {
        this.menuItemId = menuItemId;
        this.name = name;
        this.measure_unit = measure_unit;
        this.units = units;
        this.image = image;
        this.menu = menu;
    }

    public MenuItem(String name, String measure_unit, Integer units, byte[] image, Menu menu)
    {
        this.name = name;
        this.measure_unit = measure_unit;
        this.units = units;
        this.image = image;
        this.menu = menu;
    }

    public MenuItem()
    {

    }

    public Long getMenuItemId()
    {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId)
    {
        this.menuItemId = menuItemId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMeasure_unit()
    {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit)
    {
        this.measure_unit = measure_unit;
    }

    public Integer getUnits()
    {
        return units;
    }

    public void setUnits(Integer units)
    {
        this.units = units;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }
}
