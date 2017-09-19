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
public class Censo
{

    public static Pelicula[] peliculas = new Pelicula[17769];

      
    public Censo() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader("/Users/Miros/NetBeansProjects/AlgoritmosOrdenamiento/src/algoritmosordenamiento/ordenados.txt"))) {
            String line;
            int i = 0;
            while((line = in.readLine()) != null && i < 17769)
            {
                String[] tokens = line.split(",");

                Integer id = Integer.parseInt(tokens[0]);
                Integer anio = Integer.parseInt(tokens[1]);
                String nombre = (tokens[2]);
                
                Pelicula p = new Pelicula(id, anio,nombre);
                
                peliculas[i]= p;
                
                i++;
            }
        }
    }
    
    public static Pelicula[] getPeliculas(){
        return peliculas;
    }  
    

}