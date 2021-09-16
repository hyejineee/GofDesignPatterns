package com.hyejineee.design.decorator;

public class A4 extends AudiDecorator{
    public A4(String modelName, ICar car) {
        super(modelName, car, 2000);
    }
}
