package com.meretskiy.stream.api;

public class Test {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        class Test$1 implements Runnable {
            @Override
            public void run() {

            }
        }
        Runnable runnable1 = new Test$1();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();

        new Thread(() -> System.out.println(1)).start();

        MyFuncInt funcInt = new MyFuncInt() {
            @Override
            public void doSomething(int a, String b, char c) {
                System.out.println(1);
            }
        };

        MyFuncInt funcInt1 = ((a, b, c) -> System.out.println(1));

    }
}
