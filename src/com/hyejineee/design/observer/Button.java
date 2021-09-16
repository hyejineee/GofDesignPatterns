package com.hyejineee.design.observer;

public class Button {

    private String name;
    private IButtonListener buttonListener;

    public Button(String name){
        this.name = name;
    }

    public void addListener(IButtonListener listener){
        this.buttonListener = listener;
    }

    public void click(String msg){
        buttonListener.clickEvent(msg);
    }
}
