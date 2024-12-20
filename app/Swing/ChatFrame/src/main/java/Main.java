import socket.Server;
import view.GreetingForm;
import view.ServerView;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException{
        initClientForm();
        initServerForm();
    }

    public static void initClientForm(){
        EventQueue.invokeLater(() -> {
            GreetingForm greetingForm = new GreetingForm();
            greetingForm.setVisible(true);
        });
    }

    public static void initServerForm() throws IOException{
        ServerSocket serverSocket = new ServerSocket(1234); //create a server for listening to the client requests at port 1234
        Server server = new Server(serverSocket);

        EventQueue.invokeLater(() -> {
            ServerView serverView = new ServerView(server);
            serverView.setVisible(true);
        });
    }

}
