/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author edmar
 */
public class PainelFiltroEmpregado extends javax.swing.JFrame {

    /**
     * Creates new form PainelFiltroEmpregado
     */
    public PainelFiltroEmpregado() {
        initComponents();
    }
    public int getAvaliacaoDesempenho() {
        int avaliacao = -1;

        if (!avaliacaoDesempenhoTextField.getText().equals("")) {
            avaliacao = Integer.parseInt(avaliacaoDesempenhoTextField.getText());
        }

        return avaliacao;
    }
    public void limparFiltros() {
        avaliacaoDesempenhoTextField.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avaliacaoDesempenhoLabel = new javax.swing.JLabel();
        avaliacaoDesempenhoTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        avaliacaoDesempenhoLabel.setText("Avaliação de Desempenho Máxima");

        avaliacaoDesempenhoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaliacaoDesempenhoTextFieldActionPerformed(evt);
            }
        });
        avaliacaoDesempenhoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                avaliacaoDesempenhoTextField(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(avaliacaoDesempenhoLabel)
                    .addGap(12, 12, 12)
                    .addComponent(avaliacaoDesempenhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(avaliacaoDesempenhoLabel))
                        .addComponent(avaliacaoDesempenhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void avaliacaoDesempenhoTextField(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_avaliacaoDesempenhoTextField
        char caracter = evt.getKeyChar();

        if(!Character.isDigit(caracter))
        evt.consume();
    }//GEN-LAST:event_avaliacaoDesempenhoTextField

    private void avaliacaoDesempenhoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliacaoDesempenhoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avaliacaoDesempenhoTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avaliacaoDesempenhoLabel;
    private javax.swing.JTextField avaliacaoDesempenhoTextField;
    // End of variables declaration//GEN-END:variables
}
