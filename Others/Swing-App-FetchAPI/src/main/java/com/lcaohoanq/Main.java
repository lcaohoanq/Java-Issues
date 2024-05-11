package com.lcaohoanq;

import com.sun.jdi.event.ExceptionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JFrame implements ActionListener {

    public Main() {

        this.setVisible(true);
        this.setTitle("Fetch API");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());

        JButton button = new JButton("Click me \uD83D\uDC4D");
        button.setBackground(Color.GREEN);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.addActionListener(this);

        panel.add(button, BorderLayout.CENTER);

        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fetchAPI();
    }

    private void fetchAPI() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://web-snake-game-backend.vercel.app/users/account"))
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
//                System.out.println(response.body());
                response.body().lines().forEach(System.out::println);
                JOptionPane.showMessageDialog(null, "Ok", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed", "Failed to fetch data from API",
                    JOptionPane.ERROR_MESSAGE);
                throw new Exception("Failed to fetch data from API");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

