package com.hyejineee.design.decorator;

public class A3 extends AudiDecorator{
    public A3(String modelName, ICar car) {
        super(modelName, car, 1000);
    }
}
