package ru.gb.perov.Part2.HomeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        try {
            new EchoClient().start();
        } catch (NullPointerException | InterruptedException e) {
            System.out.println("Сервер не принимает сообщения...");
        }
    }

    private void start() throws InterruptedException {
        Runnable connectionThread = () -> {
            try {
                openConnection();
            } catch (IOException e) {
                System.out.println("Сервер отключён...");
            }
        };
        Thread thread = new Thread(connectionThread);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        final Thread threadConsole = new Thread(() -> {
            try {
                while (!socket.isClosed()) {
                    final String message = scanner.nextLine();
                    sendMessage(message);
                    if (message.equalsIgnoreCase("/end")) {
                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Сеанс связи закончен со стороны клиента. Сервер и клиент будут закрыты.");
                        break;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Соккет не принимает сообщения");
            }
        });
        threadConsole.setDaemon(true);
        threadConsole.start();
        threadConsole.sleep(2000);
    }



    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
            System.out.println("Сообщение от клиента: " + message);
        } catch (IOException e) {
            if (message != "") {
                System.out.println("Сообщение от клиента: (" + message + ") не будет отправлено");
            }
            System.out.println("Сервер отключён... Клиент также будет отключён");
        }
    }

    private void openConnection() throws IOException {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                final String message = in.readUTF();
                System.out.println("Сообщение от сервера: " + message);
                if ("/end".equalsIgnoreCase(message)) {
                    System.out.println("Сервер отключился. Клиент также будет закрыт");
                    Thread.currentThread().interrupt();
                    break;
                } else if ("[echo] /end".equalsIgnoreCase(message)) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}