/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import drivers.PaperStoreService;
import javax.swing.table.DefaultTableModel;
import infra.Observer;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ObserverJobs extends javax.swing.JFrame implements Observer {
     PaperStoreService objPaperStoreService;
    /**
     * Creates new form ObserverJobs
     */
    public ObserverJobs() {
        initComponents();
        headersTable();
    }

  
   private void headersTable() {
        jTableJobs.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Titulo Paper", "Descripcion Paper", "Conferencia" , "Nombre author"
                }
        ));
    } 
   @ Override
   public void update(Object o){
       obj
         ProductService productService = (ProductService) o;
        List<Product> list = productService.listProducts();
        
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        
        Object rowData[] = new Object[4];
        //remover filas
        //int rows = model.getRowCount();
        //for (int i = 0; i < rows; i++) {
        //    model.removeRow(i);
        //}
        //Poniendo a cero el total de filas, se elimina todas
        model.setRowCount(0);
        
        for (Product p : list) {
            rowData[0] = p.getProductId();
            rowData[1] = p.getName();
            rowData[2] = p.getPrice();
            rowData[3] = p.getUnidad();
            model.addRow(rowData);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableJobs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableJobs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableJobs;
    // End of variables declaration//GEN-END:variables
}
