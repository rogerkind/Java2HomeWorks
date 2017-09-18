package java2hwlesson6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1. Разобраться с кодом классов SimpleServer и SimpleClient рассмотренных на занятии.
 * Дополнить код SimpleClient так, чтобы он мог принимать сообщения от сервера.
 *
 * @author Slava Bugakov
 * @version 0.0.2 dated 18 Sep 2017
 */

public class SimpleClient{
    final String SERVER_ADDR = "127.0.0.1"; // or "localhost"
    final int SERVER_PORT = 2048;
    final String CLIENT_PROMPT = "> ";
    final String CONNECT_TO_SERVER = "Connection to server established.";
    final String CONNECT_CLOSED = "Connection closed.";
    final String EXIT_COMMAND = "exit"; // command for exit

    Socket socket;
    Scanner scanner;
    BufferedReader reader;
    PrintWriter writer;
    String message;

    SimpleClient(){
        scanner = new Scanner(System.in); // for keyboard input
        try{
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(CONNECT_TO_SERVER);
            do{
                System.out.print(CLIENT_PROMPT);
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                System.out.println(reader.readLine());
            }while(!message.equalsIgnoreCase(EXIT_COMMAND));
            writer.close();
            reader.close();
            socket.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(CONNECT_CLOSED);
    }

    public static void main(String[] args){
        new SimpleClient();
    }
}
