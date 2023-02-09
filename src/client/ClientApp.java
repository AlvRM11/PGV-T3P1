package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import shared.Constants;

public class ClientApp {
    public static void main(String[] args) {

        try {

            InetAddress myIp = InetAddress.getLocalHost();
            Socket socket = new Socket(myIp, Constants.SERVER_PORT);

            Scanner sc = new Scanner(System.in);
            DataOutputStream toServerStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Introduce un mensaje para el servidor:");
            String message = sc.nextLine();
            toServerStream.writeUTF(message);
            toServerStream.close();

            sc.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("====================");
            System.out.println("ERROR EN LA CONEXIÓN");
            System.out.println("====================");
        }
    }
}