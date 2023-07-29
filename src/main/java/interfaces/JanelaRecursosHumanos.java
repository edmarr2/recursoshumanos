/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import javax.swing.JOptionPane;
import controle.ControladorEmpregado;
import interfaces.JanelaCadastroEmpregados;
import interfaces.JanelaCadastroEmpresas;

import persistência.DB;
/**
 *
 * @author edmar
 */
public class JanelaRecursosHumanos extends javax.swing.JFrame {

    /**
     * Creates new form JanelaRecursosHumanos
     */
    public JanelaRecursosHumanos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        janelaCadastroEmpresaMenuBar = new javax.swing.JMenu();
        cadastrarEmpresaMenuItem = new javax.swing.JMenuItem();
        janelaCadastroEmpregadosMenuBar = new javax.swing.JMenu();
        cadastrarEmpregadoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recursos Humanos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        janelaCadastroEmpresaMenuBar.setText("Empresas");
        janelaCadastroEmpresaMenuBar.setActionCommand("equipamentosMenuBar");
        janelaCadastroEmpresaMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janelaCadastroEmpresaMenuBarActionPerformed(evt);
            }
        });

        cadastrarEmpresaMenuItem.setText("Cadastrar Empresa");
        cadastrarEmpresaMenuItem.setActionCommand("cadastrarEquipamentosMenuItem");
        cadastrarEmpresaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEmpresaMenuItemActionPerformed(evt);
            }
        });
        janelaCadastroEmpresaMenuBar.add(cadastrarEmpresaMenuItem);

        jMenuBar1.add(janelaCadastroEmpresaMenuBar);

        janelaCadastroEmpregadosMenuBar.setText("Empregados");
        janelaCadastroEmpregadosMenuBar.setActionCommand("");
        janelaCadastroEmpregadosMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janelaCadastroEmpregadosMenuBarActionPerformed(evt);
            }
        });

        cadastrarEmpregadoMenuItem.setText("Cadastrar Empregado");
        cadastrarEmpregadoMenuItem.setActionCommand("cadastrarEmpregadoMenuItem");
        cadastrarEmpregadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEmpregadoMenuItemActionPerformed(evt);
            }
        });
        janelaCadastroEmpregadosMenuBar.add(cadastrarEmpregadoMenuItem);

        jMenuBar1.add(janelaCadastroEmpregadosMenuBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void janelaCadastroEmpresaMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janelaCadastroEmpresaMenuBarActionPerformed
    }//GEN-LAST:event_janelaCadastroEmpresaMenuBarActionPerformed

    private void cadastrarEmpresaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEmpresaMenuItemActionPerformed
        new JanelaCadastroEmpresas().setVisible(true);
    }//GEN-LAST:event_cadastrarEmpresaMenuItemActionPerformed

    private void janelaCadastroEmpregadosMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janelaCadastroEmpregadosMenuBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_janelaCadastroEmpregadosMenuBarActionPerformed

    private void cadastrarEmpregadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEmpregadoMenuItemActionPerformed
        // TODO add your handling code here:
        new JanelaCadastroEmpregados().setVisible(true);
    }//GEN-LAST:event_cadastrarEmpregadoMenuItemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        DB.fechaConexão();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed
    
    private void informarServiçoIndisponível(){
        JOptionPane.showMessageDialog (this, "Serviço Indisponivel", "Informação",
                JOptionPane.INFORMATION_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(JanelaRecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaRecursosHumanos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrarEmpregadoMenuItem;
    private javax.swing.JMenuItem cadastrarEmpresaMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu janelaCadastroEmpregadosMenuBar;
    private javax.swing.JMenu janelaCadastroEmpresaMenuBar;
    // End of variables declaration//GEN-END:variables
}
