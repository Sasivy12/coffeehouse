package com.example.coffeehouse.CoffeeHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CoffeeHouseService
{
    @Autowired
    private CoffeeHouseRepository coffeeHouseRepository;

    public List<CoffeeHouse> getAllCoffeeHouses()
    {
        return coffeeHouseRepository.findAll();
    }

    public CoffeeHouse createCoffeeHouse(CoffeeHouse coffeeHouse)
    {
        LocalDate dateCreated = LocalDate.now();
        coffeeHouse.setDateCreated(dateCreated);
        return coffeeHouseRepository.save(coffeeHouse);
    }

    public Optional<CoffeeHouse> getASpecificCoffeeHouse(Long id)
    {
        return coffeeHouseRepository.findById(id);
    }

    public CoffeeHouse updateTheCoffeeHouse(Long id, CoffeeHouse updatedCoffeeHouse)
    {
        Optional<CoffeeHouse> existingCoffeeHouse = coffeeHouseRepository.findById(id).stream().findFirst();

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
            throw new RuntimeException("CoffeeHouse with id " + id + " not found");
        }

        return updatedCoffeeHouse;
    }

    public Optional<CoffeeHouse> deleteTheCoffeeHouse(Long id)
    {
        Optional<CoffeeHouse> coffeeHouse = coffeeHouseRepository.findById(id);

        if(coffeeHouse.isPresent())
        {
            coffeeHouseRepository.deleteById(id);
        }

        return coffeeHouse;
    }
}
