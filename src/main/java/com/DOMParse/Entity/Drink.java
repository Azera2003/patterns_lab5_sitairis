package com.DOMParse.Entity;

public class Drink extends Food{
    public int percentAlcohol;

    public Drink(int id,String name,float cost,int timeCook,int percentAlcohol){
        super(id,name,cost,timeCook);
        this.percentAlcohol = percentAlcohol;
    }
    public Drink(){super();};

    @Override
    public String getTypeProduct(){
        return "Drink";
    }
    @Override
    public void setCriteriy(int percentAlcohol) {
        this.percentAlcohol = percentAlcohol;
    }

    @Override
    public void EatProduct(){};
    @Override
    public int getCreteriy() {
        return percentAlcohol;
    }

    public int getPercentAlcohol(){
        return percentAlcohol;
    }
    public void setPercentAlcohol(int percentAlcohol){
        this.percentAlcohol = percentAlcohol;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Процент алкоголя = "+ getCreteriy());
    }
}
