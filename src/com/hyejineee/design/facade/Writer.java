package com.hyejineee.design.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Reader %s로 연결합니다.", fileName);
        System.out.println(msg);
    }

    public void write(){
        String msg = String.format("Reader %s 에 내용을 입력합니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("Reader %s로 연결을 종료합니다.", fileName);
        System.out.println(msg);
    }
}
