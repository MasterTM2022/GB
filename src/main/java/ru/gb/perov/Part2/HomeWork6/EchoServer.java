package ru.gb.perov.Part2.HomeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.*;

public class EchoServer {
    public static void main(String[] args) throws InterruptedException {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            out.println("Ждём подключение клиента...");
            final Socket socket = serverSocket.accept();
            out.println("Клиент подключился");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Runnable echoThread = () -> listenEcho(socket, in, out);
            Thread threadEcho = new Thread(echoThread);
            threadEcho.start();

            Scanner scanner = new Scanner(System.in);
            try {
                final Thread threadConsole = new Thread(() -> {
                    while (!threadEcho.isInterrupted()) {
                        String message = scanner.nextLine();
                        try {
                            out.writeUTF(message);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (message.equalsIgnoreCase("/end")) {
                            System.out.println("Сообщение от сервера: " + message);
                            System.out.println("Сеанс связи закончен. Сервер и/или клиент будут закрыты.");
                            threadEcho.interrupt();
                            break;
                        } else if (threadEcho.isInterrupted()) {
                            if (message != "") {
                                System.out.println("Клиент отключился. Ваше последнее сообщение (" + message + ") не будет отправлено");
                                System.out.println("Сеанс связи закончен.Сервер будет закрыт.");
                                break;
                            } else {
                                System.out.println("Клиент отключился.");
                                System.out.println("Сеанс связи закончен.Сервер будет закрыт.");
                                break;
                            }
                        }
                        System.out.println("Сообщение от сервера: " + message);
                    }
                });
                threadConsole.setDaemon(true);
                threadConsole.start();
                threadConsole.sleep(2000);

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void listenEcho(Socket socket, DataInputStream in, DataOutputStream out) {
        try {
            while (!socket.isClosed()) {
                final String message;
                message = in.readUTF();
                System.out.println("Сообщение от клиента: " + message);
                out.writeUTF("[echo] " + message);
                if ("/end".equalsIgnoreCase(message)) {
                    System.out.println("Клиент отключился. Сервер также будет закрыт.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Сервер закрыт");
        }
    }
}