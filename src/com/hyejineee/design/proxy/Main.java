package com.hyejineee.design.proxy;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        // 프록시가 아닌 브라우저인 경우 show를 호출할 때마다 html 새로 로딩한다.
//        Browser b = new Browser("www.naver.com");
//        b.show();
//        b.show();
//        b.show();
//        b.show();

        //프록시인 브라우저인 경우 show를 한번 호출하고 나면 cache를 사용한다.
//        IBrowser proxyB = new ProxyBrowser("www.naver.com");
//        proxyB.show();
//        proxyB.show();
//        proxyB.show();
//        proxyB.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        //AopBrowser
        IBrowser aopB = new AopBrowser(
                "www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    System.out.println("after");
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopB.show();
        System.out.println("1loading time : " + end.get());

        aopB.show();
        System.out.println("2loading time : "+ end.get());

        aopB.show();
        System.out.println("3loading time : "+ end.get());
    }
}
