import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SqServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }
    private static void serverClient(Socket socket) throws IOException {
        System.out.println("Сервисный клиент" + socket.getInetAddress());
        DataInputStream inputStream = new DataInputStream (socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream (socket.getOutputStream());
        String mess;
        mess = inputStream.readUTF();
        System.out.println("Результат:" + mess);
        outputStream.writeUTF(mess);

    }
}