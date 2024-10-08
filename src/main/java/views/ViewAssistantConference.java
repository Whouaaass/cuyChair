/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domain.Conference;
import domain.User;
import drivers.ConferenceStoreService;
import drivers.PaperStoreService;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import context.AppContext;
import infra.Observer;

/**
 *
 * @author julia
 */
public class ViewAssistantConference extends javax.swing.JFrame implements Observer {
    //Usuario logeado
    private User objUser;
    //Servicio de conferencias
    private ConferenceStoreService objConferenceStoreService;
    //Servicio de papers
    private PaperStoreService objPaperStoreService;
    /**
     * Creates new form ViewAssistantConference
     */
    public ViewAssistantConference() {
        initComponents();
        AppContext appContext = AppContext.getInstance();

        this.objUser=appContext.getLoggedUser();
        this.objConferenceStoreService= appContext.getConferenceStoreService();
        this.objPaperStoreService= appContext.getPaperStoreService();

        objConferenceStoreService.addObserver(this);

        InitTable();
    }
    private void InitTable()
    {
       DefaultTableModel model= new DefaultTableModel();       
       model.addColumn("Titulo");       
       model.addColumn("Ciudad");
       model.addColumn("Descripción");
       model.addColumn("Fecha");
       this.jTableConferencesaAssistance.setModel(model);
       fillTable();
    }
    //Limpia una tabla
    public void cleanTable(){
        DefaultTableModel modelo=(DefaultTableModel) this.jTableConferencesaAssistance.getModel();
        int rows=this.jTableConferencesaAssistance.getRowCount();
        for (int i = 0;rows>i; i++) {
            modelo.removeRow(0);
        }        
    }
     
    //Llenar tabla
     private void fillTable()
    {
        DefaultTableModel model=(DefaultTableModel) this.jTableConferencesaAssistance.getModel();
        cleanTable();
        ArrayList<Conference> conferenceList
                = (ArrayList<Conference>) this.objConferenceStoreService.listConferencesRelatedTo(objUser);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        for (int i = 0; i < conferenceList.size(); i++) {
            //Encontramos al usuario en la lista de usuarios de la conferencia
            Object [] row= {
                    conferenceList.get(i).getTitle(),
                    conferenceList.get(i).getCity(),
                    conferenceList.get(i).getDescription(),
                    formatter.format(conferenceList.get(i).getDate())
            };

            model.addRow(row);
            
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitleAssistanceConference = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConferencesaAssistance = new javax.swing.JTable();
        jButtonUploadPaper = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 213, 224));

        jLabelTitleAssistanceConference.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitleAssistanceConference.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleAssistanceConference.setText("CONFERENCIAS A LAS QUE ASISTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabelTitleAssistanceConference)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTitleAssistanceConference)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(244, 240, 216));

        jTableConferencesaAssistance.setBackground(new java.awt.Color(172, 156, 124));
        jTableConferencesaAssistance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titulo", "Ciudad", "Descripcion", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTableConferencesaAssistance);
        if (jTableConferencesaAssistance.getColumnModel().getColumnCount() > 0) {
            jTableConferencesaAssistance.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableConferencesaAssistance.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTableConferencesaAssistance.getColumnModel().getColumn(3).setPreferredWidth(7);
        }

        jButtonUploadPaper.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonUploadPaper.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUploadPaper.setText("Subir trabajo");
        jButtonUploadPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadPaperActionPerformed(evt);
            }
        });

        jButtonRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRefresh.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRefresh.setText("Actualizar");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButtonUploadPaper, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUploadPaper, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUploadPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadPaperActionPerformed
        // TODO add your handling code here:
        ViewUploadPaper objViewUploadPaper = new ViewUploadPaper();
        objViewUploadPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        objViewUploadPaper.setVisible(true);
    }//GEN-LAST:event_jButtonUploadPaperActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        fillTable();
    }//GEN-LAST:event_jButtonRefreshActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonUploadPaper;
    private javax.swing.JLabel jLabelTitleAssistanceConference;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConferencesaAssistance;

    @Override
    public void update(Object o) {
        fillTable();
    }
    // End of variables declaration//GEN-END:variables
}
