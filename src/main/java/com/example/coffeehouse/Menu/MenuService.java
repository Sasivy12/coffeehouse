package com.example.coffeehouse.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class MenuService
{
    @Autowired
    private MenuRepository menuRepository;

    public Optional<Menu> getMenu(Long id, Long m_id)
    {
        return menuRepository.findByIdAndCoffeeHouseId(id, m_id);
    }

    public Menu updateMenu(Long id, Menu updatedMenu)
    {
        Optional<Menu> existingMenu = menuRepository.findById(id);

        if(existingMenu.isPresent())
        {
            Menu menu = existingMenu.get();

            menu.setName(updatedMenu.getName());
            menu.setCoffeeHouse(updatedMenu.getCoffeeHouse());
        }

        return updatedMenu;
    }

    public Menu addMenu(Menu menu)
    {
        return menuRepository.save(menu);
    }
}
