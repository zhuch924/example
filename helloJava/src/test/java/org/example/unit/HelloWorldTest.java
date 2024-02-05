package org.example.unit;

import org.example.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testAddition() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int result = HelloWorld.add(a, b);

        // Assert
        assertEquals(8, result);
    }


    @Test
    public void testHandleRequest() throws IOException {
        String testData = "Test message from client";
        byte[] testDataBytes = testData.getBytes();

        // 模拟输入流和输出流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testDataBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // 调用被测试的方法
        HelloWorld.handleRequest(inputStream, outputStream);

        // 验证输出流的内容
        String receivedData = outputStream.toString();
        assertEquals("Hello, client! I received your message.", receivedData.trim());
    }
}
