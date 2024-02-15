package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringRevese {

    public static void main(String[] args) {
        String name = "nikola";

        StringBuilder stringBuilder = new StringBuilder(name);
        var reversed = stringBuilder.reverse();
        System.out.println("reversed:  " + reversed);
    }
}
