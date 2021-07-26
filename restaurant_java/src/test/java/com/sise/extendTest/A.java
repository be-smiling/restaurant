package com.sise.extendTest;

public class A extends B{

    public A() {
        super();
        super.testExtend();
    }

    public void testExtend2(){
        super.testExtend();
    }



    public static void main(String[] args) {
        A a = new A();
        a.testExtend2();
    }
}
