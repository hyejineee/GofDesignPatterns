package com.hyejineee.design.decorator;

public class Main {
    public static void main(String[] args) {
        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar a3 = new A3( "A3", audi);
        a3.showPrice();

        //a4
        ICar a4 = new A4( "A4", audi);
        a4.showPrice();

        //a5
        ICar a5 = new A5( "A5", audi);
        a5.showPrice();


    }
}
