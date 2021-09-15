package com.hyejineee.design.adapter;

public class VacuumCleaner implements Electronic220v {
    @Override
    public void powerOn() {
        System.out.println("청소기 on : 220v");
    }
}
