package main

import (
	"fmt"
	"io"
	"net"
	"time"
)

func main() {
	go sayHello()

	port := 10081
	serverSocket, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		fmt.Println("Failed to start server:", err)
		return
	}

	fmt.Println("Server is listening on port", port)

	for {
		clientSocket, err := serverSocket.Accept()
		if err != nil {
			fmt.Println("Failed to accept connection:", err)
			continue
		}

		fmt.Println("New connection accepted.")

		go handleClient(clientSocket)
	}
}

func add(a, b int) int {
	return a + b
}

func sayHello() {
	for {
		fmt.Println("Hello Go", time.Now())
		time.Sleep(3 * time.Second)
	}
}

func handleRequest(conn net.Conn) {
	defer conn.Close()

	buffer := make([]byte, 1024)

	for {
		bytesRead, err := conn.Read(buffer)
		if err != nil {
			if err != io.EOF {
				fmt.Println("Failed to read data from client:", err)
				return
			}
		}

		receivedData := string(buffer[:bytesRead])
		fmt.Println("Received from client:", receivedData)

		// 在这里可以添加自定义的处理逻辑

		// 回复客户端
		responseData := "Hello, client! I received your message."
		_, err = conn.Write([]byte(responseData))
		if err != nil {
			fmt.Println("Failed to write response to client:", err)
		}
		return
	}
}

func handleClient(clientSocket net.Conn) {
	handleRequest(clientSocket)
}
