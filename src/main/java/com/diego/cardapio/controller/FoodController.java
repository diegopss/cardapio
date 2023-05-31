package com.diego.cardapio.controller;

import com.diego.cardapio.dto.FoodRequestDto;
import com.diego.cardapio.dto.FoodResponseDto;
import com.diego.cardapio.model.Food;
import com.diego.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;


    @PostMapping
    public ResponseEntity<Food> save(@RequestBody FoodRequestDto data) {
        Food food = new Food(data);
        repository.save(food);
        return ResponseEntity.ok(food);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody FoodRequestDto data) {
        Food food = new Food(data);
        food.setId(id);
        repository.save(food);
        return ResponseEntity.ok(food);
    }

    @GetMapping("/foods")
    public List<FoodResponseDto> getAll(){
        List<FoodResponseDto> foodList =  repository.findAll().stream().map(FoodResponseDto::new).collect(Collectors.toList());;
        return foodList;
    }

    @GetMapping("/{id}")
    public FoodResponseDto getById(@PathVariable Long id){
        Food food = repository.findById(id).get();
        return new FoodResponseDto(food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }



}
