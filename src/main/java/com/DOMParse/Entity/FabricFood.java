package com.DOMParse.Entity;

public class FabricFood {
    public Food createFood(String food){
        switch (food){
            case "Dish":return new Dish();
            case "Soup":return new Soup();
            case "Drink":return new Drink();
            default:return null;
        }
    }
}
