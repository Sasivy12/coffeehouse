package com.example.coffeehouse.CoffeeHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoffeeHouseController
{
    @Autowired
    CoffeeHouseService coffeeHouseService;

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
    public Optional<CoffeeHouse> getASpecificCoffeeHouse(@PathVariable Long id)
    {
        return coffeeHouseService.getASpecificCoffeeHouse(id);
    }

    @PutMapping("/{id}/edit")
    public CoffeeHouse updateTheCoffeeHouse(@PathVariable Long id, @RequestBody CoffeeHouse updatedCoffeeHouse)
    {
        return coffeeHouseService.updateTheCoffeeHouse(id, updatedCoffeeHouse);
    }

    @DeleteMapping("/{id}")
    public Optional<CoffeeHouse> deleteTheCoffeeHouse(@PathVariable Long id)
    {
        return coffeeHouseService.deleteTheCoffeeHouse(id);
    }
}
