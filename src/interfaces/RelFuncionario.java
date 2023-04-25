/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;


import classe.Funcionario;
import dao.FuncionarioDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thiag
 */
public class RelFuncionario extends javax.swing.JFrame {

    
    public RelFuncionario() {
        initComponents();
        mostratabela();
    }

    private void mostratabela(){
        
        tbfuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbfuncionario.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbfuncionario.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbfuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbfuncionario.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbfuncionario.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbfuncionario.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        DefaultTableModel modelo = (DefaultTableModel)tbfuncionario.getModel();
            modelo.setNumRows(0);
            
            FuncionarioDao dao = new FuncionarioDao();
            
            List<Funcionario> funcionarios = dao.BuscaFuncionarios();
            
            for(Funcionario funcionario : funcionarios){
                
                modelo.addRow(new Object[]{
                
                    funcionario.getIdfuncionario(),
                    funcionario.getNome(),
                    funcionario.getCargo(),
                    funcionario.getCpf(),
                    funcionario.getEndereco(),
                    funcionario.getUsuario(),
                    funcionario.getSenha()
                
                });
                
                
            }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbfuncionario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Relatório de Funcionarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 590, 60));

        tbfuncionario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbfuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IdFuncionario", "Nome", "Cargo", "CPF", "Endereço", "Usuário", "Senha"
            }
        ));
        jScrollPane1.setViewportView(tbfuncionario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 710, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo_2.PNG"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 690));

        jPanel1.setBackground(new java.awt.Color(182, 155, 197));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(RelFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbfuncionario;
    // End of variables declaration//GEN-END:variables
}
