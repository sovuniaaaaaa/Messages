import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SqClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите фразу: ");
            String messages = sc.nextLine();
            DataOutputStream outputStream = new DataOutputStream (socket.getOutputStream());
            outputStream.writeUTF(messages);
            DataInputStream inputStream = new DataInputStream (socket.getInputStream());
            messages = inputStream.readUTF();
            System.out.println("Результат:" + messages);
            outputStream.writeUTF(messages);

        }
    }
}