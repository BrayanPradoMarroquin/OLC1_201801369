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
    public int fila;
    public int Columna;
    
    public Excepciones(String tipo, String descripcion, int fila, int columna){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.Columna = columna;
    }
    
    @Override
    public String toString(){
        return this.tipo +": "+this.descripcion ;
    }
}
