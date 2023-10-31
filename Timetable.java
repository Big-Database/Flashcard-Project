/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project101;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author timomichaelis
 */
public class Timetable extends javax.swing.JFrame {

    LinkedList <String> TestQue; 
    private String [] arr = new String[8];
    private String path = "/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/timeTable.txt";
    private String path2 = "/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/flash_titles.txt";
    String title;
    String datetoberemoved; 
    boolean found = false; 
    
    /**
     * Creates new form Timetable
     */
    public Timetable() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        
        String [] titles = null;
        Read_write rw = new Read_write(path2, true); 
        try { 
            titles = rw.OpenFile();
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();
        for(int i =0; i < titles.length; i++){
            Read_write read = new Read_write("/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/"+titles[i]+"/dates.txt", true);
            String [] dates = read.OpenFile(); 
            DateObj dateobj = new DateObj(titles[i], dates);
            outerloop:
            for(int ii = 2; ii < dateobj.dates.length; ii++){
                TimeHandler th = new TimeHandler("","");
                Date d = th.convertToDate(now);
                String date = th.converter(d);
                if(date.equals(dateobj.dates[ii])){
                    title = titles[i]; 
                    datetoberemoved = date; 
                    found = true; 
                    break outerloop;
                }else{found = false;}
            
            }
        }
        if(found == false){
        jTest.setEnabled(false);
        jTest.setVisible(false); 
        }

        jLabeltest.setText(title);
 
        File nf = new File(path);
        try {
            nf.createNewFile();
        } catch (IOException ex) {
            System.out.print("file timetable.txt creation error");
        }
        
        Read_write rl = new Read_write(path, true);
        try { 
            rl.readtimeTable();
        } catch (IOException ex) {
            System.out.print("opening of timetable file error");
        }
         
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel(); 
        int rows = rl.tList.size()/8; 
        
        int count = 0;
        String row[] = new String[8];
        
        for(int i = 0; i < rows; i++){
                row[0] = rl.tList.get(count);
                row[1] = rl.tList.get(count + 1);
                row[2] = rl.tList.get(count + 2);
                row[3] = rl.tList.get(count + 3);
                row[4] = rl.tList.get(count + 4);
                row[5] = rl.tList.get(count + 5);
                row[6] = rl.tList.get(count + 6);
                row[7] = rl.tList.get(count + 7);
                count = count + 8; 
                table.addRow(row);
            }
        
    
        
        jTable1.setRowHeight(50);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBack = new javax.swing.JButton();
        jSave = new javax.swing.JButton();
        jLabelTitel = new javax.swing.JLabel();
        jAddRow = new javax.swing.JButton();
        jDeleteRow = new javax.swing.JButton();
        jLabeltest = new javax.swing.JLabel();
        jTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBack.setText("<");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        jSave.setText("Save");
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jLabelTitel.setText("Time Table");

        jAddRow.setText("Add Row");
        jAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRowActionPerformed(evt);
            }
        });

        jDeleteRow.setText("Delete Row");
        jDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteRowActionPerformed(evt);
            }
        });

        jTest.setText("Go Test");
        jTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jAddRow)
                                .addGap(40, 40, 40)
                                .addComponent(jDeleteRow)
                                .addGap(89, 89, 89)
                                .addComponent(jLabeltest, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTest))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(295, 295, 295)
                                .addComponent(jLabelTitel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jDeleteRow)
                        .addComponent(jAddRow))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTest)
                                .addComponent(jLabeltest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        // TODO add your handling code here:
        
        this.dispose(); 
        Window_1 gg = new Window_1(); 
        gg.setVisible(true); 
    }//GEN-LAST:event_jBackActionPerformed

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
        // TODO add your handling code here:
        int rownum = jTable1.getRowCount(); 
        String [][] arr = new String[rownum][8]; 
        Read_write rw = new Read_write(path, false);
        Read_write rw2 = new Read_write(path, true);
        
        for(int i =0; i < rownum; i++){
            for(int ii = 0; ii < 8; ii++){
                    arr[i][ii] =(String) jTable1.getValueAt(i, ii);
            }
        }
        try {
            rw.writeLine(arr[0][0]+"//"+arr[0][1]+"//"+arr[0][2]+"//"+arr[0][3]+"//"+arr[0][4]+"//"+arr[0][5]+"//"+arr[0][6]+"//"+arr[0][7]);
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i =1; i < rownum; i++){
            try {
                rw2.writeLine(arr[i][0]+"//"+arr[i][1]+"//"+arr[i][2]+"//"+arr[i][3]+"//"+arr[i][4]+"//"+arr[i][5]+"//"+arr[i][6]+"//"+arr[i][7]);
            } catch (IOException ex) {
                Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        this.dispose();
        Timetable t; 
        try {
            t = new Timetable();
            t.setVisible(true); 
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jSaveActionPerformed

    private void jDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteRowActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        table.removeRow(jTable1.getSelectedRow());
    }//GEN-LAST:event_jDeleteRowActionPerformed

    private void jAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRowActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        for(int i = 0; i < 8; i++){arr[i] = " ";} 
        table.addRow(arr);
        
    }//GEN-LAST:event_jAddRowActionPerformed

    private void jTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTestActionPerformed
        // TODO add your handling code here: String route, int score, LinkedList<CardObj> a
        String [] arr = null;
        LinkedList<String> dates = new LinkedList<String>(); 
        Read_write rw = new Read_write("/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/"+title+"/dates.txt", true);
        Read_write rw2 = new Read_write("/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/"+title+"/dates.txt", false);
        try { 
            arr = rw.OpenFile();
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rw2.writeLine(arr[0]);
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 1; i< arr.length; i++){
            if(!arr[i].equals(datetoberemoved)){
                try {
                    rw.writeLine(arr[i]);
                } catch (IOException ex) {
                    Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        this.dispose(); 
        CardObj co = new CardObj(title); 
        try {
            co.createList();
        } catch (IOException ex) {
            Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Test t = new Test(title, 0,co.cardList); 
        t.setVisible(true); 
        
    }//GEN-LAST:event_jTestActionPerformed

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
            java.util.logging.Logger.getLogger(Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Timetable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddRow;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jDeleteRow;
    private javax.swing.JLabel jLabelTitel;
    private javax.swing.JLabel jLabeltest;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jTest;
    // End of variables declaration//GEN-END:variables
}
