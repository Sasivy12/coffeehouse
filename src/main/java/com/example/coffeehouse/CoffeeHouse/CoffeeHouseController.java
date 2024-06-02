package com.example.coffeehouse.CoffeeHouse;

import com.example.coffeehouse.Menu.Menu;
import com.example.coffeehouse.Menu.MenuService;
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

    @GetMapping("/{id}")
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

    @PostMapping("/{coffeeHouseId}/menus")
    public Menu createMenu(@PathVariable Long coffeeHouseId, @RequestBody Menu menu) {
        return menuService.createMenu(coffeeHouseId, menu);

    }
}