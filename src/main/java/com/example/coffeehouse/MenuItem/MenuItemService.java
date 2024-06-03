package com.example.coffeehouse.MenuItem;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import com.example.coffeehouse.CoffeeHouse.CoffeeHouseRepository;
import com.example.coffeehouse.Menu.Menu;
import com.example.coffeehouse.Menu.MenuRepository;
import com.example.coffeehouse.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemService
{
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CoffeeHouseRepository coffeeHouseRepository;

    @Autowired
    private MenuRepository menuRepository;

    public MenuItem createMenuItem(Long coffeeHouseId, Long menuId, MenuItem menuItem)
    {
        Optional<CoffeeHouse> coffeeHouse = coffeeHouseRepository.findById(coffeeHouseId);

        if(coffeeHouse.isPresent())
        {
            Optional<Menu> menuOptional = menuRepository.findById(menuId);

            if(menuOptional.isPresent())
            {
                Menu menu = menuOptional.get();
                menuItem.setMenu(menu);

                menuItemRepository.save(menuItem);

                menu.getMenuItems().add(menuItem);
                return menuItem;
            }
            else
            {
                throw new RuntimeException("Menu with id " + menuId + " not found");
            }
        }
        else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }
    }

    public MenuItem deleteMenuItem(Long coffeeHouseId, Long menuId, Long menuItemId)
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
                    Optional<MenuItem> menuItemOptional = menuItemRepository.findById(menuItemId);

                    if (menuItemOptional.isPresent())
                    {
                        MenuItem menuItem = menuItemOptional.get();

                        if (menuItem.getMenu().equals(menu))
                        {
                            menuItemRepository.delete(menuItem);

                            return menuItem;
                        }
                        else
                        {
                            throw new RuntimeException("MenuItem does not belong to the specified Menu");
                        }
                    }
                    else
                    {
                        throw new RuntimeException("MenuItem with id " + menuItemId + " not found");
                    }
                }
                else
                {
                    throw new RuntimeException("Menu does not belong to the specified CoffeeHouse");
                }
            }
            else
            {
                throw new RuntimeException("Menu with id " + menuId + " not found");
            }
        }
        else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }
    }

    public MenuItem updateMenuItem(Long coffeeHouseId, Long menuId, Long menuItemId, MenuItem updatedMenuItem)
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
                    Optional<MenuItem> menuItemOptional = menuItemRepository.findById(menuItemId);

                    if (menuItemOptional.isPresent())
                    {
                        MenuItem menuItem = menuItemOptional.get();

                        if (menuItem.getMenu().equals(menu))
                        {
                            menuItem.setName(updatedMenuItem.getName());
                            menuItem.setUnits(updatedMenuItem.getUnits());
                            menuItem.setMeasure_unit(updatedMenuItem.getMeasure_unit());
                            menuItem.setImage(updatedMenuItem.getImage());

                            menuItemRepository.save(menuItem);
                        }
                        else
                        {
                            throw new RuntimeException("MenuItem does not belong to the specified Menu");
                        }
                    }
                    else
                    {
                        throw new RuntimeException("MenuItem with id " + menuItemId + " not found");
                    }
                }
                else
                {
                    throw new RuntimeException("Menu does not belong to the specified CoffeeHouse");
                }
            }
            else
            {
                throw new RuntimeException("Menu with id " + menuId + " not found");
            }
        }
        else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }

        return updatedMenuItem;
    }

}
