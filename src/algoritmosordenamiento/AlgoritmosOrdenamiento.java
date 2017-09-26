/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenamiento;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miros
 */
public class AlgoritmosOrdenamiento {

    /**
     * @param args the command line arguments
     */
    //Selection sort
    
    
    public static int compa=0;
    
    public static <T extends Comparable<T>> int selectionSort(T[] data) {

        int min;
        T temp;
        
         int comparaciones = 0;
        
        for (int index = 0; index < data.length - 1; index++) {
            
            min = index;
                  
            for (int scan = index + 1; scan < data.length; scan++) {
                
                if (data[scan].compareTo(data[min]) < 0) {   // > 0 para inverso
                    min = scan;
                    
                    comparaciones++;
                } 
               
            }

            //intercambiar valores
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
            
        }
        
        return comparaciones;
    }

    public static<T extends Comparable<T>> int insertionSort(T[] data) {

        int comparaciones = 0;
        
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;

            //Desplazar los valores mayores hacia la derecha
            while (position > 0 && data[position - 1].compareTo(key) > 0) {

                data[position] = data[position - 1];
                position--;
            }
            comparaciones++;
            
            data[position] = key;

        }
        
        return comparaciones;
    }

    public static <T extends Comparable<T>> int bubbleSort(T[] data) {

        int position, scan;
        T temp;
        

        int comparaciones = 0;
        

        for (position = data.length - 1; position >= 0; position--) {          
            for (scan = 0; scan <= position - 1; scan++) {
              
           if (data[scan].compareTo(data[scan + 1]) > 0) {
                    //intercambiar los valores
                     
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                    
                }
               comparaciones++;
            }
             
        }
       
        return comparaciones;
    }

    
public static <T extends Comparable <T>> void quickSort(T[] data, int min, int max) {

        int indexofpartition;
        

        if (max - min > 0) {
            
           
            
            //crea particiones
            indexofpartition = findPartition(data, min, max);

            //ordena el lado izquierdo
            quickSort(data, min, indexofpartition - 1);

            //ordena el lado derecho
            quickSort(data, indexofpartition + 1, max);

        }
        
       
    }

    private static <T extends Comparable<T>> int findPartition(T[] data, int min, int max) {

        int left, right;
        T temp, partitionelement;
        
        int comparaciones = 0;

        //utilizar el primer elemento como el elemento de partición
        partitionelement = data[min];

        left = min;
        right = max;

        while (left < right) {
            //buscar un elemento que sea mayor que el elemento de partición

            while (data[left].compareTo(partitionelement) <= 0 && left < right) {
                left++;
            }

            //buscar un elemento que sea menor que el elemento de partición
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }

            //intercambiar los elementos
            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
     
    //mover el elemento de partición hasta el indice de partición
    temp = data[min];
    data[min]=data[right];
    data[right]=temp;

    return right;

}

    public static <T extends Comparable<T>>void mergeSort(T[]data, int min, int max){
        
        T[]temp;
        int index1, left, right;
        
    
        
        //volver al encontrarse una lista de longitud uno
        if(min==max) 
            return;
        
        //calcular la longitud y el punto medio de la lista
        int size = max - min +1;
        int pivot = (min+max)/2;
        
        temp=(T[])(new Comparable[size]);
        
        //ordenar la mitad izquierda de la lista
        mergeSort(data,min,pivot);
        
        //ordenar la mitad derecha de la lista
        mergeSort(data,pivot+1,max);
        
        //copiar los datos ordenados al espacio de trabajo
        for(index1=0; index1<size; index1++)
            temp[index1]=data[min+index1];
        
        //mexclar las dos listas ordenadas 
        left=0;
        right=pivot-min+1;
        
        for(index1=0; index1<size; index1++)
        {
            if(right<= max-min)
                if(left<= pivot-min)
                    if(temp[left].compareTo(temp[right]) >0)
                        data[index1 + min]= temp[right++];
                    else
                        data[index1 + min] = temp[left++];
                else
                    data[index1 + min] = temp[right++];
            else
                data[index1 + min] = temp[left++];
        }
        
}
    
    public static <T extends Comparable<T>> Pelicula[] getRandomArray(Pelicula[]arr){
    
        Set<Pelicula> set = new HashSet<Pelicula>();
        
            for(int i = 0; i < arr.length; i++){ 
            set.add(arr[i]);
            
            }
            
            List<Pelicula> list = new LinkedList<Pelicula>(set);
            Collections.shuffle(list);
            Set<Pelicula> randomSet = new HashSet<Pelicula>(list.subList(0, 1));    
        
            Pelicula[] randy = randomSet.toArray(new Pelicula[randomSet.size()]);
            
            return randy;
    
    
    }
    
  

        public static void main(String[] args) {
  

     
        try {
            
         
            Censo c = new Censo();
            Pelicula [] arr = c.getPeliculas();
            
            Pelicula [] randy = getRandomArray(arr);
           
            
            System.out.println(Arrays.toString(randy));
                    
                    
            //Get Random set        
            
            long startTime = System.nanoTime();
            
            //selectionSort(randy);
            insertionSort(randy);
            //bubbleSort(randy);
            //quickSort(randy,0,randy.length-1);
            //mergeSort(randy,0,randy.length-1);
            
             System.out.println(Arrays.toString(randy));
            
            //PrintStream out = new PrintStream(new FileOutputStream( "./src/algoritmosordenamiento/inversosprueba.txt"));
            //System.setOut(out);
            //Arrays.stream(arr).forEach(System.out::println); 
           

            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); 
            
            double seconds = (double)duration / 1000000.0;
            
            System.out.println("That took " + (seconds) + " milliseconds");
            
            
           
        } catch (IOException ex) {
            Logger.getLogger(AlgoritmosOrdenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
  }
    
}