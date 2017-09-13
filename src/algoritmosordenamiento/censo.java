/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenamiento;

import java.io.*;

/**
 *
 * @author Miros
 */
public class censo
{

    public static Integer[] id = new Integer[10000];
    //public int anio;
    //public String nombre; 
      
    public censo() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader("/Users/Miros/NetBeansProjects/AlgoritmosOrdenamiento/src/algoritmosordenamiento/movie_titles2.txt"))) {
            String line;
            int i = 0;
            while((line = in.readLine()) != null && i < 10000)
            {
                String[] tokens = line.split(",");

                id[i] = new Integer(tokens[0]);
                i++;
            }
        }
    }
    
    public static Integer[] getID(){
        return id;
    }  
    
}
