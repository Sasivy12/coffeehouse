package com.example.coffeehouse.CoffeeHouse;

import com.example.coffeehouse.Menu.Menu;
import com.example.coffeehouse.Menu.MenuService;
import com.example.coffeehouse.MenuItem.MenuItem;
import com.example.coffeehouse.MenuItem.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoffeeHouseController
{
    @Autowired
    private CoffeeHouseService coffeeHouseService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemService menuItemService;


    @GetMapping("/")
    public List<CoffeeHouse> getAllCoffeeHouses()
    {
        return coffeeHouseService.getAllCoffeeHouses();
    }

    @PostMapping("/add_coffee_house")
    public CoffeeHouse createCoffeeHouse(@RequestBody CoffeeHouse coffeeHouse)
    {
        return coffeeHouseService.createCoffeeHouse(coffeeHouse);
    }

    @GetMapping("/{coffeeHouseId}")
    public Optional<CoffeeHouse> getASpecificCoffeeHouse(@PathVariable Long coffeeHouseId)
    {
        return coffeeHouseService.getASpecificCoffeeHouse(coffeeHouseId);
    }

    @PutMapping("/{id}/edit")
    public CoffeeHouse updateTheCoffeeHouse(@PathVariable Long coffeeHouseId, @RequestBody CoffeeHouse updatedCoffeeHouse)
    {
        return coffeeHouseService.updateTheCoffeeHouse(coffeeHouseId, updatedCoffeeHouse);
    }

    @DeleteMapping("/{id}")
    public Optional<CoffeeHouse> deleteTheCoffeeHouse(@PathVariable Long coffeeHouseId)
    {
        return coffeeHouseService.deleteTheCoffeeHouse(coffeeHouseId);
    }

    @GetMapping("/{coffeeHouseId}/menu/{menuId}")
    public Optional<Menu> getMenu(@PathVariable Long coffeeHouseId, @PathVariable Long menuId)
    {
        return coffeeHouseService.getMenuByCoffeeHouse(coffeeHouseId, menuId);
    }

    @PostMapping("/{coffeeHouseId}/menu/add")
    public Menu createMenu(@PathVariable Long coffeeHouseId, @RequestBody Menu menu)
    {
        return menuService.createMenu(coffeeHouseId, menu);
    }

    @DeleteMapping("/{coffeeHouseId}/edit/{menuId}")
    public Menu deleteMenu(@PathVariable Long coffeeHouseId, @PathVariable Long menuId)
    {
        return menuService.deleteMenu(coffeeHouseId, menuId);
    }

    @PutMapping("/{coffeeHouseId}/edit/{menuId}")
    public Menu updateMenu(@PathVariable Long coffeeHouseId, @PathVariable Long menuId, @RequestBody Menu updatedMenu)
    {
        return menuService.updateMenu(coffeeHouseId, menuId, updatedMenu);
    }

    @GetMapping("/{coffeeHouseId}/menu/{menuId}/items/{menuItemId}")
    public Optional<MenuItem> getMenuItem(@PathVariable Long coffeeHouseId, @PathVariable Long menuId, @PathVariable Long menuItemId)
    {
        return coffeeHouseService.getMenuItem(coffeeHouseId, menuId, menuItemId);
    }

    @PostMapping("/{coffeeHouseId}/menu/{menuId}/items/add")
    public MenuItem createMenuItem(@PathVariable Long coffeeHouseId, @PathVariable Long menuId, @RequestBody MenuItem menuItem)
    {
        return menuItemService.createMenuItem(coffeeHouseId, menuId, menuItem);
    }

    @DeleteMapping("/{coffeeHouseId}/menu/{menuId}/items/{menuItemId}/edit")
    public MenuItem deleteMenuItem(@PathVariable Long coffeeHouseId, @PathVariable Long menuId,@PathVariable Long menuItemId)
    {
        return menuItemService.deleteMenuItem(coffeeHouseId, menuId, menuItemId);
    }
}