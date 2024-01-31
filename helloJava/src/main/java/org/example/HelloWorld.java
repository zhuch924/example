package org.example;

public class HelloWorld {

    public static void main(String[] args) {
        // 打印 Hello, World!
        System.out.println("Hello, World!");

        // 模拟一些逻辑，可以在这里添加更多的代码
        int result = add(3, 5);
        System.out.println("Result of addition: " + result);
    }

    // 简单的加法函数
    public static int add(int a, int b) {
        return a + b;
    }
}