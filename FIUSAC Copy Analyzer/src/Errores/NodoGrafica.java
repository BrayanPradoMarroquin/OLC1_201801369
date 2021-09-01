/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;
import java.util.ArrayList;

/**
 *
 * @author BRAYAN
 */
public class NodoGrafica {
    public String tipo;
    public String titulo;
    public ArrayList<String> Ejes;
    public ArrayList<String> Valores;
    public String Titulox;
    public String Tituloy;
    
    public NodoGrafica(String tipo, String titulo, ArrayList<String> Ejes, ArrayList<String> valores, String tx, String ty){
        this.tipo = tipo;
        this.titulo = titulo;
        this.Ejes = Ejes;
        this.Valores= valores;
        this.Titulox = tx;
        this.Tituloy = ty;
    }

    public NodoGrafica() {
        this.tipo = "";
        this.titulo = "";
        this.Ejes = null;
        this.Valores= null;
        this.Titulox = "";
        this.Tituloy = "";       
    }
}
