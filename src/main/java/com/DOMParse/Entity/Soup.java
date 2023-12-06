package com.DOMParse.Entity;

public class Soup extends Food {
    public int volume;

    public Soup(int id,String name,float cost,int timeCook,int volume){
        super(id,name,cost,timeCook);
        this.volume = volume;
    }
    public Soup(){super();};
    @Override
    public String getTypeProduct(){
        return "Soup";
    }

    @Override
    public void EatProduct(){};

    @Override
    public void setCriteriy(int volume) {
        this.volume = volume;
    }
    @Override
    public int getCreteriy() {
        return volume;
    }
    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Объём = "+ getCreteriy());
    }
}
