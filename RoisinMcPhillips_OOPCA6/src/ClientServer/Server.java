/*Roisin McPhillips OOP CA6*/
package ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import javax.json.JsonBuilderFactory;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Server
{
    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();
    }

    public void start()
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection, 
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                      // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    //Constructor
    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber)
        {
            try
            {
               InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream()); //Gets input stream from client socket
               this.socketReader = new BufferedReader(isReader);

               OutputStream os = clientSocket.getOutputStream();
               this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

               this.clientNumber = clientNumber;  // ID number that we are assigning to this client

               this.socket = clientSocket;  // store socket ref for closing 

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() //Run Method - go round in a loop
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    //HeartBeat Message - Message is in Json formate - need to parse the JSON
                    JsonBuilderFactory factory = Json.createBuilderFactory(null);

                    JsonObject jsonRootObject = Json.createObjectBuilder()
                            .add("PacketType", "HearBeat Response") //Message may be {"PacketType":"HearBeat Response"}
                            .build();

                    //Parse JSON - Convert message into input stream
                    InputStream in = in();
                    
                    System.out.println(in);  // print the JSON string

                    JsonReader reader = Json.createReader(in);

                    JsonObject object = reader.readObject();  

                    String value = object.getString("PacketType"); 

                    if (value.equalsIgnoreCase("HeartBeat"))
                    {
                        //reply - send over socket to client
                        socketWriter.println(value);
                    }
                    //End Of HeartBeat Message

                    else if (message.startsWith("Time"))
                    {
                        socketWriter.println(System.currentTimeMillis());  // sends current time to client as long int
                    }
                    else if (message.startsWith("Echo"))
                    {
                        message = message.substring(5); // strip off the 'Echo ' part
                        socketWriter.println(message);  // send message to client
                    }
                    else
                    {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }

                socket.close();

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }
}
