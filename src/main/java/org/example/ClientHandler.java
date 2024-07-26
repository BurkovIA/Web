package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(clientSocket.getInputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (in.hasNextLine()) {
                String message = in.nextLine();
                System.out.println("Received message from client: " + message);
                out.println("Message received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
