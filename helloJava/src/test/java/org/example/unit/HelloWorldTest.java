package org.example.unit;

import org.example.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;
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
}