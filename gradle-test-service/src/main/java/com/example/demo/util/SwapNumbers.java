package com.example.demo.util;

public class SwapNumbers {
    public static void main(String[] args) {
        var a = 1;
        var b = 1000;

        a= a + b;

        b = a - b;
        a = a-b;

        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }
}
