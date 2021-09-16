package com.hyejineee.design.observer;

public class Main {
    public static void main(String[] args) {
        Button b = new Button("button");

        b.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        b.click("click 1");
        b.click("click 2");
        b.click("click 3");
        b.click("click 4");
    }
}
