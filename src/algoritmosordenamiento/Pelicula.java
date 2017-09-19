/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenamiento;

/**
 *
 * @author MRODRIGUSAN
 */
public class Pelicula implements Comparable <Pelicula> {
    
    public Integer id;
    public int anio;
    public String nombre;
    
    public Pelicula(Integer elid, int elanio, String elnombre){
    
        this.id=elid;
        this.anio=elanio;
        this.nombre=elnombre;
    
    }

    public int getId() {
        return id;
    }

    public int getAnio() {
        return anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public int compareTo(Pelicula otro){      
        return this.id.compareTo(otro.id);
    }
    
    

    @Override
    public String toString() {
        return + id + "," + anio + "," + nombre;
    }
	
    
}
