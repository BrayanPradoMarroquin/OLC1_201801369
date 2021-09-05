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
    public String Nombres;
    public int clases;
    public int Variables;
    public int Metodos;
    public int Comentarios;
    
    public Archivo_Entrante(){
        this.Nombres = "";
        this.clases = 0;
        this.Variables = 0;
        this.Metodos = 0;
        this.Comentarios = 0;
    }
    
    public Archivo_Entrante(int clase, int variables, int metodos, int comentarios){
        this.clases = this.clases + clase;
        this.Variables = this.Variables + variables;
        this.Metodos = this.Metodos+ metodos;
        this.Comentarios = this.Comentarios + comentarios;
    }
}
