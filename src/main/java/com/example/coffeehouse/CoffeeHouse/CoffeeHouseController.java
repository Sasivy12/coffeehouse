package com.example.coffeehouse.CoffeeHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
