import java.io.*;
import java.net.*;
import java.util.Vector;

public class ChatServer {
    ServerSocket serverSocket;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                Socket s = serverSocket.accept();
                String ClientName = "Client " + (ChatHandler.clientsVector.size() + 1);
                new ChatHandler(s, ClientName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ChatServer();
    }
}

class ChatHandler extends Thread {
    BufferedReader dis;
    PrintStream ps;
    String clientName;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    public ChatHandler(Socket cs,String clientName) {
        this.clientName = clientName;
        try {
            dis = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            ps = new PrintStream(cs.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientsVector.add(this);
        start();
    }

    public void run() {
        
        try {
            while (true) {
                String str = dis.readLine();
                if (str.equals("@closing")){
                    clientsVector.remove(this);
                    break;
                }
                sendMessageToAll(str);   
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendMessageToAll(String msg) {
        for (ChatHandler ch : clientsVector) {
            ch.ps.println(clientName + ": " + msg);
        }
    }
}