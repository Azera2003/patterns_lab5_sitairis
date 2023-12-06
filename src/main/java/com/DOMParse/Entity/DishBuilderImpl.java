package com.DOMParse.Entity;

public class DishBuilderImpl implements DishBuilder {
    Dish d1 = new Dish();

    @Override
    public DishBuilder setName(String name){
        d1.name = name;
        return this;
    }

    @Override
    public DishBuilder setCost(float cost){
        d1.cost = cost;
        return this;
    }
    @Override
    public DishBuilder setTimeCook(int timeCook){
        d1.timeCook = timeCook;
        return this;
    }
    @Override
    public     DishBuilder setWeight(int weight){
        d1.weight = weight;
        return this;
    }
    @Override
    public Dish builder(){
        return d1;
    }

}
