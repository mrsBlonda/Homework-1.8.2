import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Начало соединения");
        int port = 8079;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

            out.println("Write your name");

            final String name = in.readLine();


            out.println("Are you child? (yes/no)");

            String age = in.readLine();

            if (age.equals("yes")) {
                out.println("Welcome to the kids area, " + name + " Let's play!");
            } else {
                out.println("Welcome to the adult zone, " + name +
                        " Have a good rest, or a good working day!");
            }
        }
    }
}
