/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Frdy
 */
class ViewMainMenu extends JFrame {
    
    public ViewMainMenu() {
        initComponents();
    }    
    
    
    /**
     * Función que inicializa todos los componentes
     */
    private void initComponents() {
        jLabelTitle = new JLabel();
        jPanelUp = new JPanel();
        jPanelCenter = new JPanel();
        jPanelDown = new JPanel();
        
        getContentPane().add(jPanelCenter, BorderLayout.CENTER);
        getContentPane().add(jPanelUp, BorderLayout.NORTH);
        getContentPane().add(jPanelDown, BorderLayout.SOUTH);
                
        jPanelUp.setLayout(new GridBagLayout());
                
        pack(); // sirve para cambiar el tamaño de la ventana
    }
    
    
    
    // componentes
    private JLabel jLabelTitle;
    private JPanel jPanelUp;
    private JPanel jPanelCenter;
    private JPanel jPanelDown;
    
    
    
}
