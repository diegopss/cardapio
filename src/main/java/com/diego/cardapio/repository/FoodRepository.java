package com.diego.cardapio.repository;

import com.diego.cardapio.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
