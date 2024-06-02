package com.example.coffeehouse.CoffeeHouse;

import com.example.coffeehouse.Menu.Menu;
import com.example.coffeehouse.Menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeHouseService
{
    @Autowired
    private CoffeeHouseRepository coffeeHouseRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<CoffeeHouse> getAllCoffeeHouses()
    {
        return coffeeHouseRepository.findAll();
    }

    public CoffeeHouse createCoffeeHouse(CoffeeHouse coffeeHouse)
    {
        LocalDate currDate = LocalDate.now();
        coffeeHouse.setDateCreated(currDate);
        return coffeeHouseRepository.save(coffeeHouse);
    }

    public Optional<CoffeeHouse> getASpecificCoffeeHouse(Long coffeeHouseId)
    {
        return coffeeHouseRepository.findById(coffeeHouseId);
    }

    public CoffeeHouse updateTheCoffeeHouse(Long coffeeHouseId, CoffeeHouse updatedCoffeeHouse)
    {
        Optional<CoffeeHouse> existingCoffeeHouse = coffeeHouseRepository.findById(coffeeHouseId).stream().findFirst();

        if(existingCoffeeHouse.isPresent())
        {
            CoffeeHouse coffeeHouse = existingCoffeeHouse.get();

            coffeeHouse.setName(updatedCoffeeHouse.getName());
            coffeeHouse.setDateCreated(updatedCoffeeHouse.getDateCreated());
            coffeeHouse.setSchedule(updatedCoffeeHouse.getSchedule());
            coffeeHouse.setInfo(updatedCoffeeHouse.getInfo());

            coffeeHouseRepository.save(coffeeHouse);
        }
        else
        {
            throw new RuntimeException("CoffeeHouse with id " + coffeeHouseId + " not found");
        }

        return updatedCoffeeHouse;
    }

    public Optional<CoffeeHouse> deleteTheCoffeeHouse(Long coffeeHouseId)
    {
        Optional<CoffeeHouse> coffeeHouse = coffeeHouseRepository.findById(coffeeHouseId);

        if(coffeeHouse.isPresent())
        {
            coffeeHouseRepository.deleteById(coffeeHouseId);
        }

        return coffeeHouse;
    }

    public Optional<Menu> getMenuByCoffeeHouse(Long coffeeHouseId, Long menuId)
    {
        Optional<CoffeeHouse> coffeeHouse = coffeeHouseRepository.findById(coffeeHouseId);

        if(coffeeHouse.isPresent())
        {
            return menuRepository.findByMenuIdAndCoffeeHouse(menuId, coffeeHouse.get());
        }
        else
        {
            return Optional.empty();
        }
    }

}
