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
public class Error {
    
    public static ArrayList<Excepciones> ErroresCometidos = new ArrayList();
    
        public Error(String tipo, String descripcion, String linea, String columna){
            Excepciones nuevo = new Excepciones(tipo, descripcion, linea, columna);
            ErroresCometidos.add(nuevo);
        }        
        
}
