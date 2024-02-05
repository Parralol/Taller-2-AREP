package edu.escuelaing.arem.ASE.app;

import java.net.*;
import java.util.Arrays;
import java.io.*;

 
public class HttpServer {
     
    public static void main(String[] args) throws IOException {
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
            String context = HttpContext.getHtml();

            String[] urisp = uriStr.split("\\.");
            System.out.println(Arrays.toString(urisp));
            if(urisp.length >1){
                if(urisp[1].equals("jpg") || urisp[1].equals("webp")){
                     context = HttpContext.getImg();
                }
           }
            String res = "HTTP/1.1 200 OK\r\n"
            + "Content-Type:" + context +"\r\n";
            OutputStream output = clientSocket.getOutputStream();
            byte[] webpContent = {};
            FileInputStream fin = null;
            BufferedInputStream bin= null;
            BufferedOutputStream bout= null;
            if(!uriStr.equals("/favicon.ico")){
                
            try{
                String filename ="TALLER2_AREP/src/main/resources/public"+ uriStr;
                System.out.println(filename);
                if(context.equals(HttpContext.getHtml())){
                    BufferedReader reader = new BufferedReader(new FileReader(filename));
                    String linea = null;
                    while((linea = reader.readLine()) != null ){
                        res += linea;
                    }
                    reader.close();
                }else{
                   fin = new FileInputStream(filename);
                   bin = new BufferedInputStream(fin);
                   bout = new BufferedOutputStream(output);
                }
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
           
            if(!uriStr.equals("/favicon.ico") && context.equals(HttpContext.getHtml())){
                    try (BufferedOutputStream bos = new BufferedOutputStream(output)) {
                        bos.write(res.getBytes());
                        bos.write(webpContent);
                        bos.flush();
                    }
            }else{
                if(!uriStr.equals("/favicon.ico")){
                out.println(res);
                int ch =0; ;  
                while((ch=bin.read())!=-1)  
                {  
                bout.write(ch);  
                }  
                  
                bin.close();  
                fin.close();  
                bout.close(); 
                }
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
    
}