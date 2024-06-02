package com.example.coffeehouse.Menu;

import com.example.coffeehouse.MenuItem.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController
{
    @Autowired
    private MenuItemService menuItemService;
}
