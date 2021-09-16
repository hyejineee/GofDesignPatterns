package com.hyejineee.design.strategy;

public class Main {
    public static void main(String[] args) {
        EncodingStrategy base = new Base64EncodeStrategy();
        EncodingStrategy n = new NormalEncodeStrategy();

        String m = "hello world";
        Encoder e = new Encoder();
        e.setEncodingStrategy(base);

        System.out.println(e.getMessage(m));

        e.setEncodingStrategy(n);
        System.out.println(e.getMessage(m));

    }
}
