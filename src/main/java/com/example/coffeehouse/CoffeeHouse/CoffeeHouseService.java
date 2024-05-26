package com.example.coffeehouse.CoffeeHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoffeeHouseService
{
    @Autowired
    private CoffeeHouseRepository coffeeHouseRepository;

    public List<CoffeeHouse> getAllCoffeeHouses()
    {
        return coffeeHouseRepository.findAll();
    }
}
