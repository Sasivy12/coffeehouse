package com.example.coffeehouse.Menu;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>
{
    Optional<Menu> findByMenuIdAndCoffeeHouse(Long menuId, CoffeeHouse coffeeHouse);
}