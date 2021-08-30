/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author BRAYAN
 */
public class Excepciones {
    public String tipo;
    public String descripcion;
    public String linea;
    public String columna;
    
    public Excepciones(String tipo, String descripcion, String linea, String columna){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }
    
    @Override
    public String toString(){
        return this.tipo +": "+this.descripcion +" ["+ this.linea+", "+this.columna+"] ";
    }
}
