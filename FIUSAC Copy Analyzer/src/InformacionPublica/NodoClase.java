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
public class NodoClase {
    public String Identificador;
    public ArrayList<String> Method;
    public int CantidadMetodos;
    public int Lineas;
    
    public NodoClase(){
        this.Identificador = "";
        this.Method = null;
        this.CantidadMetodos = 0;
        this.Lineas = 0;
    }
}
