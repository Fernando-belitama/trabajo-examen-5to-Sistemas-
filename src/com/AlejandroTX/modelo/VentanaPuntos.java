/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlejandroTX.modelo;
import com.AlejandroTX.controlador.Arista;
import com.AlejandroTX.controlador.Aristas;
import com.AlejandroTX.controlador.Puntos;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

/**
 *
 * @author RAI
 */
public class VentanaPuntos extends JFrame {
    
    
    public Puntos puntos = new Puntos(); 
    public Aristas aristas = new Aristas();
    
    public JButton bAñadeAristas = new JButton("Añade Aristas"); 
    public PanelPuntos panelPuntos = new PanelPuntos(puntos, aristas);
    public DialogAñadeAristas dialogoAñadeArista = new DialogAñadeAristas(this);




    public VentanaPuntos(){
        super("Une Puntos");


        add(panelPuntos, BorderLayout.CENTER); 
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAñadeAristas);
        add(pB, BorderLayout.SOUTH); 


        bAñadeAristas.addActionListener(new manejadorBotonAñade()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        pack(); 
        setVisible(true);
    }
    
    
    private class manejadorBotonAñade implements ActionListener{ 
    @Override 
        public void actionPerformed(ActionEvent e){
            
        int[] ptos = dialogoAñadeArista.muestra();
        
            if (ptos != null){
            for(int i=0; i<ptos.length-1; i++){ 
            aristas.añade(new Arista(puntos.punto(ptos[i]), puntos.punto(ptos[i+1])));
            }
            panelPuntos.repaint();
            }
        }
    }
    
    
    public static void main(String[] args) {
        new VentanaPuntos();
    }
    
}
