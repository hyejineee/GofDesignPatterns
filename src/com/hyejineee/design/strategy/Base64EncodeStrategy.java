package com.hyejineee.design.strategy;

import java.util.Base64;

public class Base64EncodeStrategy implements EncodingStrategy{
    @Override
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
