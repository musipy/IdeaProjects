package com.company;

public class A {
    public static int a=1;
    private static int b=2;
    public int c;
    private int d;
    public A(int a, int b, int c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public static void foo(int a, int b, int c, int d){
        // A
    }
    private static void foo2(int a, int b, int c, int d){
        // B
    }
    public void goo(int a, int b, int c, int d){
        // C
    }
    private void goo2(int a, int b, int c, int d){
        // D
    }
}
