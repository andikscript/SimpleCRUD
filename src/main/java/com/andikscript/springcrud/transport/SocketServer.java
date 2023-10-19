package com.andikscript.springcrud.transport;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class SocketServer {

    private DataInputStream dataInputStream;

    private DataOutputStream dataOutputStream;

    public void run(Integer port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("listener port : " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("connected : " + clientSocket);

            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            String message = null;
            while (true) {
                message = dataInputStream.readLine();

                if (!message.isEmpty()) {
                    System.out.println("message : " + message);
                    dataOutputStream.writeUTF("data already received server");
                }

                if (message.equals("exit()")) {
                    break;
                }
            }

            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }
}
