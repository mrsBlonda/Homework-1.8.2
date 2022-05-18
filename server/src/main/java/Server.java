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
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                    out.println("Write your name");

                    final String name = in.readLine();

                    out.println("Are you child? (yes/no)");

                    String age = in.readLine();

                    if (age.equals("yes")) {
                        out.printf("Welcome to the kids area, %s Let's play!", name);
                    } else {
                        out.printf("Welcome to the adult zone, %s Have a good rest, or a good working day!", name);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
