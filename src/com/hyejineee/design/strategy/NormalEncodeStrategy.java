package com.hyejineee.design.strategy;

public class NormalEncodeStrategy implements EncodingStrategy{
    @Override
    public String encode(String msg) {
        return msg;
    }
}
