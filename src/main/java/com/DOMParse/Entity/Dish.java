package com.DOMParse.Entity;

public class Dish extends Food {


    public int weight;

    public Dish(int id,String name,float cost,int timeCook,int weight){
    super(id,name,cost,timeCook);
    this.weight = weight;
}
    public Dish(){super();};
@Override
    public String getTypeProduct(){
     return "Dish";
}
    public int getCreteriy() {
        return weight;
    }

    @Override
    public void EatProduct(){};

    @Override
    public void setCriteriy(int weight) {
        this.weight = weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Масса = "+ getCreteriy());
    }



}
