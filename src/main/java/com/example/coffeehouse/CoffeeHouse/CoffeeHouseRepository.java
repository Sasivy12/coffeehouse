package com.example.coffeehouse.CoffeeHouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeHouseRepository extends JpaRepository<CoffeeHouse, Long>
{

}
