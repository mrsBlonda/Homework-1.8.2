import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int port = 8079;
        String host = "127.0.0.1";
        Scanner scan = new Scanner(System.in);
        try (Socket clientsocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);

            out.println(scan.nextLine());

            String age = in.readLine();
            System.out.println(age);

            out.println(scan.nextLine());

            String welcome = in.readLine();
            System.out.println(welcome);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
