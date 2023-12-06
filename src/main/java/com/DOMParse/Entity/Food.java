package com.DOMParse.Entity;

public abstract class Food {
    private int id;
    public String name;
    public float cost;
    public int timeCook;

    abstract void EatProduct();

    public int getCreteriy() {
        return 1;
    }

    public String getTypeProduct(){return "";};

    public void setCriteriy(int criteriy){};

    public Food(int id,String name,float cost,int timeCook){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.timeCook = timeCook;
    }
    public Food(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeCook() {
        return timeCook;
    }

    public void setTimeCook(int timeCook) {
        this.timeCook = timeCook;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void showInfo() {
        System.out.print ("id = " + getId() + ", Наименование = " + getName() + ", Стоимость = " + getCost() + ", Время приготовление = " + getTimeCook()+", ");
    }
}
