package com.hyejineee.design.adapter;

public class HairDryer implements Electronic110v {
    @Override
    public void powerOn() {
        System.out.println("헤어드라이기 on :110v");
    }
}
