/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author vasim
 */
public class StreamUtil {
    
         
       public static void CopyFileToFile(String sourceFile, String destinationFile){
     
            try{
                InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(destinationFile);
                copy(inputStream, outputStream);
                   
               }catch(IOException ex){
                       
               }
                
        }
       
       public  static void URLToFile(String url, String destinationFile){
           
                
        URLConnection urlConnection=null;
        try{
        OutputStream outputStream = new FileOutputStream(destinationFile);
        URL urlOfData = new URL(url);
        urlConnection = urlOfData.openConnection();
        InputStream responseStream = urlConnection.getInputStream();
        copy(responseStream, outputStream);
          
       }catch(IOException ex){
           System.err.print("Error occured while reading data from url");
       }
           
       }
       private static void copy(InputStream inputStream, OutputStream outputStream){
           
           byte[] buffer = new byte[512];
           try{
           int bytesRead = inputStream.read(buffer);
           while(bytesRead != -1){
               outputStream.write(buffer, 0 , bytesRead);
               bytesRead = inputStream.read(buffer);
           }
           
           }catch(IOException ex){
               
              System.err.print("Error occured while reading source file");
           }
           
           
       }
       
    
}
