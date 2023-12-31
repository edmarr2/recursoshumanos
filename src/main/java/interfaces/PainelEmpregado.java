/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

/**
 *
 * @author edmar
 */
public class PainelEmpregado extends javax.swing.JPanel {

    /**
     * Creates new form PainelEmpregado
     */
    public PainelEmpregado() {
        initComponents();
    }
    public String getDepartamento() {
        if(departamentoTextField.getText().isEmpty())
            return null;
        
        return departamentoTextField.getText();
    } 
    
    public Integer getAvaliacao() {
        if(avaliacaoTextField.getText().isEmpty())
            return null;
        
        return Integer.valueOf(avaliacaoTextField.getText());
    }
    
    public void setDepartamento(String departamento) {
        departamentoTextField.setText(departamento);
    }
    
    public void setAvaliacao(Integer avaliacao) {
        avaliacaoTextField.setText(avaliacao.toString());
    }

    public void limparTexto() {
        departamentoTextField.setText("");
        avaliacaoTextField.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        departamentoLabel = new javax.swing.JLabel();
        departamentoTextField = new javax.swing.JTextField();
        avaliaçãoDesempenhoLabel = new javax.swing.JLabel();
        avaliacaoTextField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(376, 96));

        departamentoLabel.setText("Departamento:");

        departamentoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departamentoTextFieldActionPerformed(evt);
            }
        });

        avaliaçãoDesempenhoLabel.setText("Avaliação de desempenho:");

        avaliacaoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaliacaoTextFieldActionPerformed(evt);
            }
        });
        avaliacaoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                avaliacaoTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departamentoLabel)
                    .addComponent(avaliaçãoDesempenhoLabel)
                    .addComponent(departamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avaliacaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(departamentoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avaliaçãoDesempenhoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avaliacaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void departamentoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departamentoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departamentoTextFieldActionPerformed

    private void avaliacaoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliacaoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avaliacaoTextFieldActionPerformed

    private void avaliacaoTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_avaliacaoTextFieldKeyTyped
        char caracteres = evt.getKeyChar();

        if(!Character.isDigit(caracteres)){
            evt.consume();
        }
    }//GEN-LAST:event_avaliacaoTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avaliacaoTextField;
    private javax.swing.JLabel avaliaçãoDesempenhoLabel;
    private javax.swing.JLabel departamentoLabel;
    private javax.swing.JTextField departamentoTextField;
    // End of variables declaration//GEN-END:variables
}
