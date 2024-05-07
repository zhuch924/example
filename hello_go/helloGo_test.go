package main

import (
	"io"
	"net"
	"testing"
	"time"
)

func TestAddition(t *testing.T) {
	// Arrange
	a := 3
	b := 5

	// Act
	result := add(a, b)

	// Assert
	expectedResult := 8
	if result != expectedResult {
		t.Errorf("Addition test failed. Expected: %d, Got: %d", expectedResult, result)
	}
}

func TestHandleRequest(t *testing.T) {
	// Create a mock connection
	conn := &mockConn{
		input:  "Test message from client",
		output: "",
	}

	// Call the function being tested
	handleRequest(conn)

	// Validate the output
	expectedOutput := "Hello, client! I received your message."
	if conn.output != expectedOutput {
		t.Errorf("HandleRequest test failed. Expected: %s, Got: %s", expectedOutput, conn.output)
	}
}

type mockConn struct {
	input  string
	output string
}

func (c *mockConn) LocalAddr() net.Addr {
	//TODO implement me
	panic("implement me")
}

func (c *mockConn) RemoteAddr() net.Addr {
	//TODO implement me
	panic("implement me")
}

func (c *mockConn) SetDeadline(t time.Time) error {
	//TODO implement me
	panic("implement me")
}

func (c *mockConn) SetReadDeadline(t time.Time) error {
	//TODO implement me
	panic("implement me")
}

func (c *mockConn) SetWriteDeadline(t time.Time) error {
	//TODO implement me
	panic("implement me")
}

func (c *mockConn) Read(buffer []byte) (int, error) {
	copy(buffer, []byte(c.input))
	return len(c.input), io.EOF
}

func (c *mockConn) Write(data []byte) (int, error) {
	c.output = string(data)
	return len(data), nil
}

func (c *mockConn) Close() error {
	return nil
}
