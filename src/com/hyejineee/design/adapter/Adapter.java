package com.hyejineee.design.adapter;

public class Adapter implements Electronic110v {

    private final Electronic220v product;

    public Adapter(Electronic220v product){
        this.product = product;
    }

    @Override
    public void powerOn() {
        product.powerOn();
    }
}
