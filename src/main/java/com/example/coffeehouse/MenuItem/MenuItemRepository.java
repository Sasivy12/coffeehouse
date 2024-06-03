package com.example.coffeehouse.MenuItem;

import com.example.coffeehouse.CoffeeHouse.CoffeeHouse;
import com.example.coffeehouse.Menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>
{
    Optional<MenuItem> findByMenuItemIdAndMenuAndMenuCoffeeHouse(Long menuItemId, Menu menu, CoffeeHouse coffeeHouse);
}
