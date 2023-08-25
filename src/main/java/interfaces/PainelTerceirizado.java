/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

/**
 *
 * @author edmar
 */
public class PainelTerceirizado extends javax.swing.JPanel {

    /**
     * Creates new form PainelTerceirizado
     */
    public PainelTerceirizado() {
        initComponents();
    }
    public String getEmpresaContratada() {
        if(empresaContratadaTextField.getText().isEmpty())
            return null;
        
        return empresaContratadaTextField.getText();
    } 
    public String getDuracaoContrato() {
        if(duracaoContratoTextField.getText().isEmpty())
            return null;
        
        return duracaoContratoTextField.getText();
    } 
    public void setEmpresaContratada(String empresaContratada) {
        empresaContratadaTextField.setText(empresaContratada);
    }
    
    public void setDuracaoContrato(String duracao) {
        duracaoContratoTextField.setText(duracao);
    }
    public void limparTexto() {
        empresaContratadaTextField.setText("");
        duracaoContratoTextField.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empresaContratadaLabel = new javax.swing.JLabel();
        empresaContratadaTextField = new javax.swing.JTextField();
        duraçãoContratoLabel = new javax.swing.JLabel();
        duracaoContratoTextField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(376, 96));

        empresaContratadaLabel.setText("Empresa Contratada:");

        duraçãoContratoLabel.setText("Duração do Contrato:");

        duracaoContratoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracaoContratoTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empresaContratadaLabel)
                    .addComponent(duraçãoContratoLabel)
                    .addComponent(empresaContratadaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duracaoContratoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(empresaContratadaLabel)
                .addGap(7, 7, 7)
                .addComponent(empresaContratadaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(duraçãoContratoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duracaoContratoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void duracaoContratoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracaoContratoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracaoContratoTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField duracaoContratoTextField;
    private javax.swing.JLabel duraçãoContratoLabel;
    private javax.swing.JLabel empresaContratadaLabel;
    private javax.swing.JTextField empresaContratadaTextField;
    // End of variables declaration//GEN-END:variables
}
