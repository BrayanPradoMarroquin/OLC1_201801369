/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPublica;

import java.util.ArrayList;

/**
 *
 * @author BRAYAN
 */
public class Archivo_Entrante {
    public NodoClase Clase;
    public int CantidadVariable;
    public NodoMetodo Metodos;
    public ArrayList<String> Comentarios;
    
    public Archivo_Entrante(){
        this.Clase = null;
        this.CantidadVariable = 0;
        this.Metodos = null;
        this.Comentarios = null;
    }
    
    public Archivo_Entrante(NodoClase clase, NodoMetodo Method, String coment){
        this.Clase = clase;
        this.CantidadVariable = +1;
        this.Metodos = Method;
        this.Comentarios.add(coment);
    }
}
