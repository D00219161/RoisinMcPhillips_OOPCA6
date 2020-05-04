/*Roisin McPhillips OOP CA6*/
package ClientServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
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

            //Commands used for requesting data from server and for sending data over
            System.out.println("[Commands: \"GetRegisteredVehicles\" to get registered vehicles, "
                    + "\"HeartBeat\" to get heartbeat, "
                    + "\"RegisterValidTollEvent\" to register a valid toll event "
                    + "\"RegisterInvaildTollEvent\" to register an invalid toll event, "
                    + "\"Close\" to close the connection]");
            
            System.out.println("Please enter a command: ");
            
            String command = in.nextLine();  // read a command from the user

            OutputStream os = socket.getOutputStream();

            PrintWriter socketWriter = new PrintWriter(os, true);// true=> auto flush buffers
            socketWriter.println(command);  // write command to socket
          
            Scanner socketReader = new Scanner(socket.getInputStream()); //Read Messages over the server

            //Start of HeartBeat Message
            if (command.startsWith("HeartBeat")) //expect server to return a time (in milliseconds)
            {
                //We prepare the heartbeat message
                 JsonBuilderFactory factory = Json.createBuilderFactory(null);

                //Wrap the JsonArray in a JsonObject & give the JsonArray a key name
                JsonObject jsonRootObject = Json.createObjectBuilder()
                        .add("PacketType", "HeartBeat") //"PacketType" = Key, "HeartBeat" = Value
                        .build();

                String value = jsonRootObject.toString();
                socketWriter.println(value); //Writes the command to a socket
                
                System.out.println("Client Request: " + value);
                
                String response = socketReader.nextLine();
                System.out.println("Response from Server: \"" + response + "\"");
            }
            //End Of HeartBeat Message
            
            //Start of GetRegisteredVehicles Message
            else if (command.startsWith("GetRegisteredVehicles")) //expect server to return a time (in milliseconds)
            {
                //We prepare the heartbeat message
                 JsonBuilderFactory factory = Json.createBuilderFactory(null);

                //Wrap the JsonArray in a JsonObject & give the JsonArray a key name
                JsonObject jsonRootObject = Json.createObjectBuilder()
                        .add("PacketType", "GetRegisteredVehicles") //"PacketType" = Key, "GetRegisteredVehicles" = Value
                        .build();

                String value = jsonRootObject.toString();
                socketWriter.println(value); //Writes the command to a socket
                
                System.out.println("Client Request: " + value);
                
                String response = socketReader.nextLine();
                System.out.println("Response from Server: \"" + response + "\"");
            }
            //End Of GetRegisteredVehicles Message
            
            //Start of RegisterVaildTollEvent Message
            if (command.startsWith("RegisterVaildTollEvent"))
            {
                //We prepare the heartbeat message
                 JsonBuilderFactory factory = Json.createBuilderFactory(null);

                //Wrap the JsonArray in a JsonObject & give the JsonArray a key name
                JsonObject jsonRootObject = Json.createObjectBuilder()
                        .add("PacketType", "RegisterVaildTollEvent") //"PacketType" = Key, "RegisterVaildTollEvent" = Value
                        .build();

                String value = jsonRootObject.toString();
                socketWriter.println(value); //Writes the command to a socket
                
                System.out.println("Client Request: " + value);
                
                String response = socketReader.nextLine();
                System.out.println("Response from Server: \"" + response + "\"");
            }
            //End Of RegisterVaildTollEvent Message
                    
            //Start of RegisterInvaildTollEvent Message
             if (command.startsWith("RegisterInvaildTollEvent"))
            {
                //We prepare the heartbeat message
                 JsonBuilderFactory factory = Json.createBuilderFactory(null);

                //Wrap the JsonArray in a JsonObject & give the JsonArray a key name
                JsonObject jsonRootObject = Json.createObjectBuilder()
                        .add("PacketType", "RegisterInvaildTollEvent") //"PacketType" = Key, "RegisterInvaildTollEvent" = Value
                        .build();

                String value = jsonRootObject.toString();
                socketWriter.println(value); //Writes the command to a socket
                
                System.out.println("Client Request: " + value);
                
                String response = socketReader.nextLine();
                System.out.println("Response from Server: \"" + response + "\"");
            }
            //End Of RegisterInvaildTollEvent Message
                    
                    
            //Start of Close connection with client
            else if (command.startsWith("Close"))
            {
                System.out.println("GoodBye!"); //Closing connection with the server
            }
            //End Of Close Message
            
            else  // the user has entered close or an invalid command
            {
                String input = socketReader.nextLine();
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
