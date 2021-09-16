package com.hyejineee.design.decorator;

public class AudiDecorator implements ICar {

    protected ICar car;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(String modelName, ICar car, int modelPrice){
        this.modelName = modelName;
        this.car = car;
        this.modelPrice = modelPrice;
    }


    @Override
    public int getPrice() {
        return car.getPrice() + this.modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName +"의 가격은 "+ getPrice() + "원 입니다.");
    }
}
