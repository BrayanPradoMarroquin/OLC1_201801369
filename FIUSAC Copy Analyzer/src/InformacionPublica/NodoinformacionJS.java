/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPublica;

/**
 *
 * @author BRAYAN
 */
public class NodoinformacionJS {
    public String tipo;
    public String Identificador;
    public int lugar;
    
    public NodoinformacionJS(String tipo, String contendio, int lugar){
        this.tipo = tipo;
        this.Identificador = contendio;
        this.lugar = lugar;
    }

    public NodoinformacionJS(String comentario, String var1) {
        this.tipo = tipo;
        this.Identificador = var1;
        this.lugar = 0;
    }
}
