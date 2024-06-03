package com.example.coffeehouse.Menu;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import com.example.coffeehouse.CoffeeHouse.CoffeeHouseRepository;
import com.example.coffeehouse.MenuItem.MenuItem;
import com.example.coffeehouse.MenuItem.MenuItemRepository;
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

    @Autowired
    private MenuItemRepository menuItemRepository;

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
        }
        else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }
    }

    public Menu deleteMenu(Long coffeeHouseId, Long menuId)
    {
        Optional<CoffeeHouse> coffeeHouseOptional = coffeeHouseRepository.findById(coffeeHouseId);

        if (coffeeHouseOptional.isPresent())
        {
            CoffeeHouse coffeeHouse = coffeeHouseOptional.get();
            Optional<Menu> menuOptional = menuRepository.findById(menuId);

            if (menuOptional.isPresent())
            {
                Menu menu = menuOptional.get();

                if (menu.getCoffeeHouse().equals(coffeeHouse))
                {
                    menuRepository.delete(menu);
                }
                else
                {
                    throw new IllegalArgumentException("Menu with ID " + menuId + " does not belong to CoffeeHouse with ID " + coffeeHouseId);
                }
            }
        }
        return null;
    }

    public Menu updateMenu(Long coffeeHouseId, Long menuId, Menu updatedMenu)
    {
        Optional<CoffeeHouse> coffeeHouseOptional = coffeeHouseRepository.findById(coffeeHouseId);

        if (coffeeHouseOptional.isPresent())
        {
            CoffeeHouse coffeeHouse = coffeeHouseOptional.get();
            Optional<Menu> menuOptional = menuRepository.findById(menuId);

            if (menuOptional.isPresent())
            {
                Menu menu = menuOptional.get();

                if(menu.getCoffeeHouse().equals(coffeeHouse))
                {
                    menu.setName(updatedMenu.getName());
                    menu.setCoffeeHouse(updatedMenu.getCoffeeHouse());

                    menuRepository.save(menu);
                }
            }
        }
        return updatedMenu;
    }


}