// This example uses ObjectInputStream to deserialize a Java object from user input. The problem is that it does not validate or sanitize the object data, making it vulnerable to malicious objects.


package com.example.insecuredeserialization;

import java.io.*;
import java.net.*;

public class DeserializationVulnerable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        // Vulnerable: Deserializing an untrusted object
        Object object = objectInputStream.readObject();
        System.out.println("Object deserialized: " + object);

        socket.close();
        serverSocket.close();
    }
}
