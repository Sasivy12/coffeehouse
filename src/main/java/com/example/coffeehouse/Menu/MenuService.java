package com.example.coffeehouse.Menu;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import com.example.coffeehouse.CoffeeHouse.CoffeeHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService
{
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CoffeeHouseRepository coffeeHouseRepository;


    public Menu createMenu(Long coffeeHouseId, Menu menu)
    {
        Optional<CoffeeHouse> coffeeHouseOptional = coffeeHouseRepository.findById(coffeeHouseId);

        if (coffeeHouseOptional.isPresent())
        {
            CoffeeHouse coffeeHouse = coffeeHouseOptional.get();
            menu.setCoffeeHouse(coffeeHouse);
            menu = menuRepository.save(menu);

            // Set the coffeeHouse reference to null to prevent loop
            coffeeHouse.getMenus().add(menu);
            return menu;
        } else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }
    }
}