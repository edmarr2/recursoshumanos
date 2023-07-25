/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import controle.ControladorCadastroEmpregado;
import controle.ControladorCadastroEmpresa;
import entidade.Empregado;
import entidade.Empregado.EstadoCivil;
import entidade.Empresa;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author edmar
 */
public class JanelaCadastroEmpregados extends javax.swing.JFrame {
    private ControladorCadastroEmpregado controlador;
    private ControladorCadastroEmpresa controladorEmpresa;
    /**
     * Creates new form JanelaRecursosHumanos
     */
    public JanelaCadastroEmpregados() {
        controlador = new ControladorCadastroEmpregado();
        controladorEmpresa = new ControladorCadastroEmpresa();
        initComponents();
        inicializarListaEmpregados();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public JanelaCadastroEmpregados(ControladorCadastroEmpregado aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeEmpregadoLabel = new javax.swing.JLabel();
        cargoEmpregadoLabel = new javax.swing.JLabel();
        salarioEmpregadoLabel = new javax.swing.JLabel();
        nomeEmpregadoTextField = new javax.swing.JTextField();
        cargoEmpregadoTextField = new javax.swing.JTextField();
        salarioEmpregadoTextField = new javax.swing.JTextField();
        cadastrarEmpregadoButton = new javax.swing.JButton();
        atualizarEmpregadoButton = new javax.swing.JButton();
        limparCamposButton = new javax.swing.JButton();
        removerEmpregadoButton = new javax.swing.JButton();
        buscarEmpregadoButton = new javax.swing.JButton();
        cpfEmpregadoLabel = new javax.swing.JLabel();
        cpfEmpregadoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        empregadosCadastradosList = new javax.swing.JList<>();
        listagemEmpregadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Empregados");

        nomeEmpregadoLabel.setText("Nome:");

        cargoEmpregadoLabel.setText("Cargo:");

        salarioEmpregadoLabel.setText("Salário:");

        nomeEmpregadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeEmpregadoTextFieldActionPerformed(evt);
            }
        });

        cargoEmpregadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargoEmpregadoTextFieldActionPerformed(evt);
            }
        });

        salarioEmpregadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioEmpregadoTextFieldActionPerformed(evt);
            }
        });

        cadastrarEmpregadoButton.setText("Adicionar");
        cadastrarEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEmpregadoButtonActionPerformed(evt);
            }
        });

        atualizarEmpregadoButton.setText("Atualizar");
        atualizarEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarEmpregadoButtonActionPerformed(evt);
            }
        });

        limparCamposButton.setText("Limpar Campos");
        limparCamposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposButtonActionPerformed(evt);
            }
        });

        removerEmpregadoButton.setText("Remover");
        removerEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerEmpregadoButtonActionPerformed(evt);
            }
        });

        buscarEmpregadoButton.setText("Buscar");
        buscarEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpregadoButtonActionPerformed(evt);
            }
        });

        cpfEmpregadoLabel.setText("CPF:");

        cpfEmpregadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfEmpregadoTextFieldActionPerformed(evt);
            }
        });

        empregadosCadastradosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        empregadosCadastradosList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                empregadosCadastradosListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(empregadosCadastradosList);

        listagemEmpregadoLabel.setText("Empregados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(salarioEmpregadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cargoEmpregadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeEmpregadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargoEmpregadoTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeEmpregadoTextField)
                            .addComponent(salarioEmpregadoTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastrarEmpregadoButton)
                        .addGap(18, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limparCamposButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buscarEmpregadoButton)
                                .addGap(29, 29, 29)
                                .addComponent(atualizarEmpregadoButton)
                                .addGap(28, 28, 28)
                                .addComponent(removerEmpregadoButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listagemEmpregadoLabel)
                            .addComponent(cpfEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cpfEmpregadoTextField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(listagemEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfEmpregadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeEmpregadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargoEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargoEmpregadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioEmpregadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarioEmpregadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrarEmpregadoButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(removerEmpregadoButton)
                        .addComponent(atualizarEmpregadoButton)
                        .addComponent(buscarEmpregadoButton)))
                .addGap(18, 18, 18)
                .addComponent(limparCamposButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeEmpregadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeEmpregadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeEmpregadoTextFieldActionPerformed

    private void cargoEmpregadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargoEmpregadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargoEmpregadoTextFieldActionPerformed

    private void salarioEmpregadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioEmpregadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioEmpregadoTextFieldActionPerformed

    private void cadastrarEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEmpregadoButtonActionPerformed
        String cpf = cpfEmpregadoTextField.getText();
        String nome = nomeEmpregadoTextField.getText().replace("-", "");
        String cargo = cargoEmpregadoTextField.getText();
        double salario = Double.parseDouble(salarioEmpregadoTextField.getText());

        if(controlador.verificarCpfExistente(cpf)){
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        controlador.adicionarEmpregado(cpf, nome, cargo, salario, EstadoCivil.solteiro);
        this.inicializarListaEmpregados();

        this.limparTextos();
    }//GEN-LAST:event_cadastrarEmpregadoButtonActionPerformed
 
    private void atualizarEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarEmpregadoButtonActionPerformed
        String nome = nomeEmpregadoTextField.getText().replace("-", "");
        String cargo = cargoEmpregadoTextField.getText();
        double salario = Double.parseDouble(salarioEmpregadoTextField.getText());
        String cpf = cpfEmpregadoTextField.getText();
        
        controlador.atualizarEmpregado(cpf, nome, cargo, salario, EstadoCivil.solteiro);
        
        this.inicializarListaEmpregados();
        this.limparTextos();
    }//GEN-LAST:event_atualizarEmpregadoButtonActionPerformed

    private void limparCamposButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposButtonActionPerformed
        this.limparTextos();
    }//GEN-LAST:event_limparCamposButtonActionPerformed

    private void removerEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerEmpregadoButtonActionPerformed
        String cpfText = cpfEmpregadoTextField.getText();

        controlador.removerEmpregado(cpfText);
        this.limparTextos();
        this.inicializarListaEmpregados();
    }//GEN-LAST:event_removerEmpregadoButtonActionPerformed

    private void buscarEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpregadoButtonActionPerformed
        String cpf = cpfEmpregadoTextField.getText();
        Empregado empregado = controlador.buscarEmpregadoPorCPF(cpf);

        // Exibir informações do empregado encontrado (por exemplo, preencher campos de texto)
        if (empregado != null) {
            this.selecionarEmpregadoList(empregado.getNomeECPF());
            this.preencherCampos(empregado);
        } else {
            JOptionPane.showMessageDialog(null, "Não encontrado nenhum empregado com esse CPF!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buscarEmpregadoButtonActionPerformed

    private void cpfEmpregadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfEmpregadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfEmpregadoTextFieldActionPerformed

    private void empregadosCadastradosListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_empregadosCadastradosListValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            DefaultListModel<String> empregadoSelecionado = (DefaultListModel<String>) empregadosCadastradosList.getModel();
            int empregadoSelecionadoIndex = empregadosCadastradosList.getSelectedIndex();
            if (empregadoSelecionadoIndex != -1) {
                String[] nomeCPF = empregadoSelecionado.getElementAt(empregadoSelecionadoIndex).split(" - ");
                // pega a parte do CPF
                Empregado empregado = controlador.buscarEmpregadoPorCPF(nomeCPF[1]);
                this.preencherCampos(empregado);
            }
        }
    }//GEN-LAST:event_empregadosCadastradosListValueChanged
    
    private void selecionarEmpregadoList(String empregado) {
        int index = -1;
        for (int i = 0; i < empregadosCadastradosList.getModel().getSize(); i++) {
            if (empregadosCadastradosList.getModel().getElementAt(i).equals(empregado)) {
                index = i;
                break;
            }
        }

        // Definir o item desejado como selecionado
        if (index != -1) {
            empregadosCadastradosList.setSelectedIndex(index);
        }
    }
    
    private void inicializarListaEmpregados() {
        DefaultListModel<String> empregadosListModel = new DefaultListModel<>();

        List<Empregado> empregados = controlador.listarEmpregados();
        for (Empregado empregado : empregados) {
            empregadosListModel.addElement(empregado.getNomeECPF());
        }

        empregadosCadastradosList.setModel(empregadosListModel);
    }
    
    private void preencherCampos(Empregado empregado) {
        cpfEmpregadoTextField.setText(String.valueOf(empregado.getCPF()));
        nomeEmpregadoTextField.setText(empregado.getNome());
        cargoEmpregadoTextField.setText(empregado.getCargo());
        salarioEmpregadoTextField.setText(String.valueOf(empregado.getSalário()));
    }
    
    private void limparTextos(){
        nomeEmpregadoTextField.setText("");
        cargoEmpregadoTextField.setText("");
        salarioEmpregadoTextField.setText("");
        cpfEmpregadoTextField.setText("");
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
            java.util.logging.Logger.getLogger(JanelaCadastroEmpregados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroEmpregados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroEmpregados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroEmpregados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroEmpregados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarEmpregadoButton;
    private javax.swing.JButton buscarEmpregadoButton;
    private javax.swing.JButton cadastrarEmpregadoButton;
    private javax.swing.JLabel cargoEmpregadoLabel;
    private javax.swing.JTextField cargoEmpregadoTextField;
    private javax.swing.JLabel cpfEmpregadoLabel;
    private javax.swing.JTextField cpfEmpregadoTextField;
    private javax.swing.JList<String> empregadosCadastradosList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparCamposButton;
    private javax.swing.JLabel listagemEmpregadoLabel;
    private javax.swing.JLabel nomeEmpregadoLabel;
    private javax.swing.JTextField nomeEmpregadoTextField;
    private javax.swing.JButton removerEmpregadoButton;
    private javax.swing.JLabel salarioEmpregadoLabel;
    private javax.swing.JTextField salarioEmpregadoTextField;
    // End of variables declaration//GEN-END:variables
}
