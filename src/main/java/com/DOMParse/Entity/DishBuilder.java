package com.DOMParse.Entity;

public interface DishBuilder {
    DishBuilder setName(String name);
    DishBuilder setCost(float cost);
    DishBuilder setTimeCook(int timeCook);
    DishBuilder setWeight(int weight);
    Dish builder();
}
