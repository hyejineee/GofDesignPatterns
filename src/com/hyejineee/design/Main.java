package com.hyejineee.design;

import com.hyejineee.design.singleton.Aclazz;
import com.hyejineee.design.singleton.Bclazz;
import com.hyejineee.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
        Aclazz a = new Aclazz();
        Bclazz b = new Bclazz();

        SocketClient aClient = a.getSocketClient();
        SocketClient bClient = b.getSocketClient();

        System.out.println("두 개의 객체 동일성 비교 :  "+ aClient.equals(bClient));
    }
}
