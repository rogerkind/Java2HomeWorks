package java2hwlesson6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. Разобраться с кодом классов SimpleServer и SimpleClient рассмотренных на занятии.
 * Дополнить код SimpleClient так, чтобы он мог принимать сообщения от сервера.
 * <p>
 * 2**. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения,
 * как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать "Привет",
 * нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли. Если сделать то же самое на
 * серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
 * Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд,
 * такую ситуацию необходимо корректно обработать
 * <p>
 * Разобраться с кодом с занятия, он является фундаментом проекта-чата
 * ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл,
 * который будет ожидать второго/третьего/n-го клиентов
 *
 * @author Slava Bugakov
 * @version 0.0.2 dated 14 Sep 2017
 */
public class SimpleServer{
    final int SERVER_PORT = 2048;
    final String SERVER_START = "Server is started...";
    final String SERVER_STOP = "Server stopped.";
    final String CLIENT_JOINED = " client joined.";
    final String CLIENT_DISCONNECTED = " disconnected";
    final String EXIT_COMMAND = "exit"; // command for exit

    int client_count = 0;
    ServerSocket server;
    Socket socket;

    SimpleServer(){
        System.out.println(SERVER_START);
        try{
            server = new ServerSocket(SERVER_PORT);
            while(true){
                socket = server.accept();
                client_count++;
                System.out.println("#" + client_count + CLIENT_JOINED);
                new Thread(new ClientHandler(socket)).start();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(SERVER_STOP);
    }

    public static void main(String[] args){
        new SimpleServer();
    }

    /**
     * ClientHandler: service requests of clients
     */
    class ClientHandler implements Runnable{
        BufferedReader reader;
        PrintWriter writer;
        Socket socket;
        String name;

        ClientHandler(Socket clientSocket){
            try{
                socket = clientSocket;
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
                name = "Client #" + client_count;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public void run(){
            String message;
            try{
                do{
                    message = reader.readLine();
                    System.out.println(name + ": " + message);
                    writer.println("echo: " + message);
                    writer.flush();
                }while(!message.equalsIgnoreCase(EXIT_COMMAND));
                socket.close();
                System.out.println(name + CLIENT_DISCONNECTED);
                server.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
