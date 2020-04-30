/*Roisin McPhillips OOP CA6*/
package ClientServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

public class Client
{
 public static void main(String[] args)
    {
        Client client = new Client();
        client.start();
    }

    public void start()
    {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket, and open new socket

            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            System.out.println("Client: This Client is running and has connected to the server");

            System.out.println("[Commands: \"HearBeat\" to get heartbeat, \"Time\" to get time, or \"Echo message\" to get echo)]");
            System.out.println("Please enter a command: ");
            
            String command = in.nextLine();  // read a command from the user

            OutputStream os = socket.getOutputStream();

            PrintWriter socketWriter = new PrintWriter(os, true);// true=> auto flush buffers
            socketWriter.println(command);  // write command to socket
          
            Scanner socketReader = new Scanner(socket.getInputStream()); //Read Messages 

            ///HeartBeat Message
            if (command.startsWith("HeartBeat")) //expect server to return a time (in milliseconds)
            {
                //We prepare the heartbeat message
                 JsonBuilderFactory factory = Json.createBuilderFactory(null);

                //Wrap the JsonArray in a JsonObject & give the JsonArray a key name
                JsonObject jsonRootObject = Json.createObjectBuilder()
                        .add("PacketType", "HearBeat") //"PacketType" = Key, "HeartBeat" = Value
                        .build();

                String message = jsonRootObject.toString();
                
                socketWriter.println(message); //Writes the command to a socket
            }
            ///End Of HeartBeat Message
            
            if (command.startsWith("Time")) // we expect the server to return a time (in milliseconds)
            {
                long time = socketReader.nextLong();  // wait for, and read time (as we expect time reply)
                Date date = new Date(time);
                System.out.println("Client: Response from server: Time: " + date.toString());
            } 
            else // the user has entered the Echo command or an invalid command
            {
                String input = socketReader.nextLine();// wait for, and retrieve the echo ( or other message)
                System.out.println("Client: Response from server: \"" + input + "\"");
            }
            socketWriter.close();
            socketReader.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }
}
