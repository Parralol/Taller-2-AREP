package edu.escuelaing.arem.ASE.app;

import java.net.*;
import java.io.*;
 
public class HttpServer {
     
    public static void main(String[] args) throws IOException {
        String res = "HTTP/1.1 200 OK\r\n"
        + "Content-Type:text/html\r\n" + "\r\n";


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
 
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
 
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine;
            
            boolean firstLine = true;
            String uriStr = "";
 
            while ((inputLine = in.readLine()) != null) {
                if(firstLine){
                    uriStr = inputLine.split(" ")[1];
                    firstLine = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            if(!uriStr.equals("/favicon.ico")){
            try{
                BufferedReader reader = new BufferedReader(new FileReader("TALLER2_AREP/src/main/resources/public/"+ uriStr));
                String linea = null;
                while((linea = reader.readLine()) != null ){
                    res += linea;
                }
                reader.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
                BufferedReader reader = new BufferedReader(new FileReader("TALLER2_AREP/src/main/resources/public/error.html"));
                String linea = null;
                while((linea = reader.readLine()) != null ){
                    res += linea;
                }
                reader.close();
            }
        }
            out.println(res);
 
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
    

}