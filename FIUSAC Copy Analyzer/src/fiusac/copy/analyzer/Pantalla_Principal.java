/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiusac.copy.analyzer;

import analizadores.Lexico;
import analizadores.Sintactico;
import fiusac.copy.analyzer.Pestañas;
import java.awt.MenuComponent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import Errores.*;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author BRAYAN
 */
public class Pantalla_Principal extends javax.swing.JFrame {
    public ArrayList<Excepciones> tabladeErrores = new ArrayList();
    String cadena = "";
    Sintactico sintax;
    analizadorJs.Sintactico sintaxJS1, sintaxJS2;
    private MenuComponent Pestañas;

    /**
     * Creates new form Pantalla_Principal
     */
    public Pantalla_Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPPestañas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        JL_Console = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        JM_Abrir = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        JM_Ejecutar = new javax.swing.JMenu();
        JM_Reportes = new javax.swing.JMenu();
        JM_Cerrar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("EDITOR DE TEXTO");

        jLabel2.setText("CONSOLA");

        JT_1.setColumns(20);
        JT_1.setRows(5);
        jScrollPane2.setViewportView(JT_1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        JPPestañas.addTab("Datos Generados", jPanel2);

        JL_Console.setColumns(20);
        JL_Console.setRows(5);
        JL_Console.setEnabled(false);
        jScrollPane1.setViewportView(JL_Console);

        JM_Abrir.setText("Abrir");
        JM_Abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JM_AbrirMouseClicked(evt);
            }
        });
        JM_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_AbrirActionPerformed(evt);
            }
        });
        jMenuBar1.add(JM_Abrir);

        jMenu2.setText("Crear Pestaña");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Eliminar Pestaña");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        JM_Ejecutar.setText("Ejecutar");
        JM_Ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JM_EjecutarMouseClicked(evt);
            }
        });
        jMenuBar1.add(JM_Ejecutar);

        JM_Reportes.setText("Reportes");
        JM_Reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JM_ReportesMouseClicked(evt);
            }
        });
        jMenuBar1.add(JM_Reportes);

        JM_Cerrar.setText("Cerrar Aplicacion");
        JM_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JM_CerrarMouseClicked(evt);
            }
        });
        jMenuBar1.add(JM_Cerrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(216, 216, 216))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPPestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JPPestañas)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
       Pestañas nuevo = new Pestañas();
       JPPestañas.add("Nuevo", nuevo);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        JPPestañas.remove(Pestañas);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void JM_AbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_AbrirMouseClicked
        // TODO add your handling code here:
        analizadores.Sintactico pars;
        JFileChooser abrir = new JFileChooser();
        
        FileNameExtensionFilter extension = new FileNameExtensionFilter(".fca", "fca");
        abrir.setFileFilter(extension);
        abrir.showOpenDialog(this);
        File archivo = new File(abrir.getSelectedFile().getAbsolutePath());
        
        try {            
            String st  = new String(Files.readAllBytes(archivo.toPath()));
            JT_1.setText(st);
            //pars = new analizadores.Sintactico(new analizadores.Lexico(new FileInputStream(abrir.getSelectedFile())));
            //pars.parse();
            JL_Console.setText(JL_Console.getText()+"Si accedio :) \n");
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+e.getCause());
        }
    }//GEN-LAST:event_JM_AbrirMouseClicked

    private void JM_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_CerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_JM_CerrarMouseClicked

    private void JM_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_AbrirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JM_AbrirActionPerformed

    private void JM_EjecutarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_EjecutarMouseClicked
        // TODO add your handling code here:
        analizer();
    }//GEN-LAST:event_JM_EjecutarMouseClicked

    private void JM_ReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JM_ReportesMouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < sintax.GraficasEjecutar.size(); i++) {
            if (sintax.GraficasEjecutar.get(i).tipo.equals("GraficaBarras")) {
                JL_Console.setText(JL_Console.getText()+" Generando grafica de Barras");
                NodoGrafica barras = new NodoGrafica();
                barras = sintax.GraficasEjecutar.get(i);
                
                for (int j = 0; j < barras.Valores.size(); j++) {
                    for (int k = 0; k < sintax.ListaVariables.size(); k++) {
                        if (barras.Valores.get(j).equals(sintax.ListaVariables.get(k).Identificador)) {
                            barras.Valores.set(j, sintax.ListaVariables.get(k).contenido);
                        }   
                        if (barras.Ejes.get(j).equals(sintax.ListaVariables.get(k).Identificador)) {
                            barras.Ejes.set(j, sintax.ListaVariables.get(k).contenido);
                        }
                    }
                }
                for (int j = 0; j < sintax.ListaVariables.size(); j++) {
                    if (barras.titulo.equals(sintax.ListaVariables.get(j).Identificador)){
                        barras.titulo = sintax.ListaVariables.get(j).contenido;
                    }
                }
                
                for (int j = 0; j < sintax.ListaVariables.size(); j++) {
                    if (barras.Titulox.equals(sintax.ListaVariables.get(j).Identificador)){
                        barras.Titulox = sintax.ListaVariables.get(j).contenido;
                    }
                }
                
                for (int j = 0; j < sintax.ListaVariables.size(); j++) {
                    if (barras.Tituloy.equals(sintax.ListaVariables.get(j).Identificador)){
                        barras.Tituloy = sintax.ListaVariables.get(j).contenido;
                    }
                }
                
                DefaultCategoryDataset data = new DefaultCategoryDataset();
                
                for (int j = 0; j < barras.Ejes.size(); j++) {
                    data.setValue(Double.parseDouble(barras.Valores.get(j)), "Resultado", barras.Ejes.get(j));
                }
                
                JFreeChart GraficoBarras = ChartFactory.createBarChart3D(
                        barras.titulo,
                        barras.Titulox,
                        barras.Tituloy,
                        data,
                        PlotOrientation.VERTICAL,
                        false,
                        false,
                        false
                );
                
                ChartFrame jf = new ChartFrame(barras.titulo, GraficoBarras);
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }else if (sintax.GraficasEjecutar.get(i).tipo.equals("GraficaPie")) {
                
                NodoGrafica circular = new NodoGrafica();
                circular = sintax.GraficasEjecutar.get(i);
                JL_Console.setText(JL_Console.getText()+" Generando grafica Circular");
                for (int j = 0; j < circular.Valores.size(); j++) {
                    for (int k = 0; k < sintax.ListaVariables.size(); k++) {
                        if (circular.Valores.get(j).equals(sintax.ListaVariables.get(k).Identificador)) {
                            circular.Valores.set(j, sintax.ListaVariables.get(k).contenido);
                        }   
                        if (circular.Ejes.get(j).equals(sintax.ListaVariables.get(k).Identificador)) {
                            circular.Ejes.set(j, sintax.ListaVariables.get(k).contenido);
                        }
                    }
                }
                
                for (int j = 0; j < sintax.ListaVariables.size(); j++) {
                    if (circular.titulo.equals(sintax.ListaVariables.get(j).Identificador)){
                        circular.titulo = sintax.ListaVariables.get(j).contenido;
                    }
                }
                
                DefaultPieDataset data = new DefaultPieDataset();
                
                
                
            }else if (sintax.GraficasEjecutar.get(i).tipo.equals("GraficaLineas")) {
                NodoGrafica lineal = new NodoGrafica();
                lineal = sintax.GraficasEjecutar.get(i);
                JL_Console.setText(JL_Console.getText()+" Generando grafica de Lineas");
            }
            
            
        }
    }//GEN-LAST:event_JM_ReportesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JL_Console;
    private javax.swing.JMenu JM_Abrir;
    private javax.swing.JMenu JM_Cerrar;
    private javax.swing.JMenu JM_Ejecutar;
    private javax.swing.JMenu JM_Reportes;
    private javax.swing.JTabbedPane JPPestañas;
    private javax.swing.JTextArea JT_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void analizer() {
        String texto = JT_1.getText();
        JL_Console.setText("Iniciando Analisis \n");
        sintax = new Sintactico(new Lexico(new StringReader(texto)));
        try {
            sintax.parse();
            JL_Console.setText(JL_Console.getText()+ "Hay "+Integer.toString(sintax.ListaVariables.size())+" variables Globales \n"); 
            JL_Console.setText(JL_Console.getText()+ "Hay "+Integer.toString(sintax.GraficasEjecutar.size())+" graficas a Realizar \n");
            JL_Console.setText(JL_Console.getText()+ " Obtencion de Tokens");
            JL_Console.setText(JL_Console.getText()+" Obtención de Rutas exitosa. \n");
            JL_Console.setText(JL_Console.getText()+" entrada de archivos.  \n");
            BusquedadeRutas(sintax.Direcciones);
            JL_Console.setText(JL_Console.getText()+" archivos analizados. \n");
            JL_Console.setText(JL_Console.getText()+ "Analisis Correcto \n");
        } catch (Exception e) {
            JL_Console.setText(JL_Console.getText()+"Error en el analisis Sintactico  \n");
            //JL_Console.setText(JL_Console.getText()+ "Error de Sintaxis Linea: " + (syma.right+1) + " Columna: " + (syma.left+1) + " Texto: \"" + syma.value + "\" \n");
        }
        JL_Console.setText(JL_Console.getText()+"Analisis Finalizado \n");
    } 

    private void BusquedadeRutas(ArrayList<String> Direcciones) {
        String rut1validar1 = Direcciones.get(0);
        String rut1validar2 = Direcciones.get(1);
        File rut1 = new File(rut1validar1.substring(1, rut1validar1.length()-1));
        File rut2 = new File(rut1validar2.substring(1, rut1validar2.length()-1));
        
        String[] carpeta1 = rut1.list();
        String[] carpeta2 = rut2.list();
        
        JL_Console.setText(JL_Console.getText()+" Detectando Archivos con el mismo nombre. \n");
        for (int i = 0; i < carpeta1.length; i++) {
            for (int j = 0; j < carpeta2.length; j++) {
                if (carpeta1[i].equals(carpeta2[j])) {
                    File archivo1 = new File(rut1validar1.substring(1, rut1validar1.length()-1)+"\\"+carpeta1[i]);
                    File archivo2 = new File(rut1validar1.substring(1, rut1validar1.length()-1)+"\\"+carpeta2[i]);
        
                    try {            
                        String st1  = new String(Files.readAllBytes(archivo1.toPath()));
                        String st2  = new String(Files.readAllBytes(archivo2.toPath()));
                        //System.out.println(st1+"\n");
                        //System.out.println(st2+"\n");
                        sintaxJS1 = new analizadorJs.Sintactico(new analizadorJs.Lexico(new StringReader(st1)));
                        sintaxJS2 = new analizadorJs.Sintactico(new analizadorJs.Lexico(new StringReader(st2)));
                        JL_Console.setText(JL_Console.getText()+"Obtencion de Datos exitoso :) \n");
                    } catch (Exception e) {
                        System.out.println("Error fatal en compilación de entrada.");
                        System.out.println("Causa: "+e.getCause());
                    }
                }
            }
        }
    }
}
