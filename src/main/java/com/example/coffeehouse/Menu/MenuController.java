package com.example.coffeehouse.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MenuController
{
    @Autowired
    MenuService menuService;

    @GetMapping("/{id}/menu/{m_id}")
    public Optional<Menu> getMenu(@PathVariable Long id, @PathVariable Long m_id)
    {
        return menuService.getMenu(id, m_id);
    }

    @PutMapping("/{id}/menu/{m_id}")
    public Menu updateMenu(@PathVariable Long id, @PathVariable Long m_id, @RequestBody Menu updatedMenu)
    {
        return menuService.updateMenu(m_id, updatedMenu);
    }

    @PostMapping("/{id}/menu/add")
    public Menu addMenu(@RequestBody Menu menu)
    {
        return menuService.addMenu(menu);
    }
}
