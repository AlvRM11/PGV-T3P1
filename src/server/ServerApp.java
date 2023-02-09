package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import shared.Constants;

public class ServerApp {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT);

            System.out.println("Esperando por cliente...");
            Socket clientSocket = serverSocket.accept();

            String msg = "La conexión se ha realizado con ";
            msg += clientSocket.getInetAddress().toString();
            System.out.println(msg);

            DataInputStream fromClientStream = new DataInputStream(clientSocket.getInputStream());
            String clientMessage = fromClientStream.readUTF();
            System.out.println("El cliente dice: " + clientMessage);

            System.out.println("================");
            System.out.println("Servidor cerrado");
            System.out.println("================");
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
