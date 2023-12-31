/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import controle.ControladorEmpresa;
import entidade.Empresa;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author edmar
 */
public class JanelaCadastroEmpresas extends javax.swing.JFrame {
    ControladorEmpresa controlador;
    private final Empresa[] empresasCadastradas;

    public JanelaCadastroEmpresas(ControladorEmpresa controlador) {
        this.controlador = controlador;
        this.empresasCadastradas = Empresa.getVisoes();
        initComponents();
        limparTextos();
    }   
    
    private void preencherCampos(Empresa empresa) {
        cnpjEmpresaTextField.setText(empresa.getCNPJ());
        nomeEmpresaTextField.setText(empresa.getNome());
        enderecoEmpresaTextField.setText(empresa.getEndereco());
    }

    private void limparTextos (){
        cnpjEmpresaTextField.setText("");
        nomeEmpresaTextField.setText("");
        enderecoEmpresaTextField.setText("");
    }
    
    private void selecionarEmpresa() {
        Empresa visao = (Empresa) empresasCadastradasComboBox.getSelectedItem();
        String erro = null;
        Empresa empresa = null;

        if (visao != null) {
            empresa = Empresa.buscarEmpresa(visao.getCNPJ());

            if (empresa == null) {
                erro = "Empresa não cadastrada";
            }
        } else {
            erro = "Nenhuma empresa foi selecionada";
        }

        if (erro == null) {
            cnpjEmpresaTextField.setText(empresa.getCNPJ());
            nomeEmpresaTextField.setText(empresa.getNome());
            enderecoEmpresaTextField.setText(empresa.getEndereco());
        } else {
            informarErroEmpresa(erro);
        }
    }
    
    private Empresa obterEmpresaInformada() {
        Empresa empresa = null;

        String cnpj = cnpjEmpresaTextField.getText();
        String nomeEmpresa = nomeEmpresaTextField.getText();
        String enderecoEmpresa = enderecoEmpresaTextField.getText();

        if (cnpj.isEmpty() || nomeEmpresa.isEmpty() || enderecoEmpresa.isEmpty()) {
            return null;
        }

        empresa = new Empresa(cnpj, nomeEmpresa, enderecoEmpresa);
        return empresa;
    }
    
    private void informarErroEmpresa(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empresasCadastradasLabel = new javax.swing.JLabel();
        nomeEmpresaLabel = new javax.swing.JLabel();
        nomeEmpresaTextField = new javax.swing.JTextField();
        cnpjEmpresaTextField = new javax.swing.JTextField();
        cnpjEmpresaLabel = new javax.swing.JLabel();
        enderecoEmpresaLabel = new javax.swing.JLabel();
        enderecoEmpresaTextField = new javax.swing.JTextField();
        cadastrarEmpresaButton = new javax.swing.JButton();
        atualizarEmpresaButton = new javax.swing.JButton();
        removerEmpresaButton = new javax.swing.JButton();
        buscarEmpresaButton = new javax.swing.JButton();
        limparCamposEmpresaButton = new javax.swing.JButton();
        empresasCadastradasComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Empresas");

        empresasCadastradasLabel.setText("Empresas Cadastradas");

        nomeEmpresaLabel.setText("Nome");

        nomeEmpresaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeEmpresaTextFieldActionPerformed(evt);
            }
        });

        cnpjEmpresaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjEmpresaTextFieldActionPerformed(evt);
            }
        });

        cnpjEmpresaLabel.setText("CNPJ");

        enderecoEmpresaLabel.setText("Endereço");

        enderecoEmpresaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoEmpresaTextFieldActionPerformed(evt);
            }
        });

        cadastrarEmpresaButton.setText("Cadastrar");
        cadastrarEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEmpresaButtonActionPerformed(evt);
            }
        });

        atualizarEmpresaButton.setText("Alterar");
        atualizarEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarEmpresaButtonActionPerformed(evt);
            }
        });

        removerEmpresaButton.setText("Remover");
        removerEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerEmpresaButtonActionPerformed(evt);
            }
        });

        buscarEmpresaButton.setText("Buscar");
        buscarEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpresaButtonActionPerformed(evt);
            }
        });

        limparCamposEmpresaButton.setText("Limpar Campos");
        limparCamposEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposEmpresaButtonActionPerformed(evt);
            }
        });

        empresasCadastradasComboBox.setModel(new DefaultComboBoxModel(empresasCadastradas));
        empresasCadastradasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresasCadastradasComboBoxActionPerformed(evt);
            }
        });
        empresasCadastradasComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                empresasCadastradasComboBoxPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastrarEmpresaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atualizarEmpresaButton)
                        .addGap(43, 43, 43)
                        .addComponent(removerEmpresaButton)
                        .addGap(30, 30, 30)
                        .addComponent(buscarEmpresaButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empresasCadastradasLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empresasCadastradasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpjEmpresaLabel)
                            .addComponent(enderecoEmpresaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enderecoEmpresaTextField)
                            .addComponent(cnpjEmpresaTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeEmpresaLabel)
                        .addGap(22, 22, 22)
                        .addComponent(nomeEmpresaTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(limparCamposEmpresaButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empresasCadastradasLabel)
                    .addComponent(empresasCadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnpjEmpresaLabel)
                    .addComponent(cnpjEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEmpresaLabel)
                    .addComponent(nomeEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoEmpresaLabel)
                    .addComponent(enderecoEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarEmpresaButton)
                    .addComponent(atualizarEmpresaButton)
                    .addComponent(removerEmpresaButton)
                    .addComponent(buscarEmpresaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparCamposEmpresaButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeEmpresaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeEmpresaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeEmpresaTextFieldActionPerformed

    private void cnpjEmpresaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjEmpresaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjEmpresaTextFieldActionPerformed

    private void enderecoEmpresaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoEmpresaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoEmpresaTextFieldActionPerformed

    private void cadastrarEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEmpresaButtonActionPerformed
        Empresa empresa = obterEmpresaInformada();
        String erro = null;
        if(empresa != null)
            erro = controlador.inserirEmpresa(empresa);
        else
            erro = "Algum atributo de empresa não foi informado";
        if(erro == null) {
            DefaultComboBoxModel<Empresa> comboBoxModel = (DefaultComboBoxModel<Empresa>) empresasCadastradasComboBox.getModel();
            comboBoxModel.addElement(empresa);
            empresasCadastradasComboBox.setSelectedItem(empresa);
            this.limparTextos();
        }
        else
            informarErroEmpresa(erro);
    }//GEN-LAST:event_cadastrarEmpresaButtonActionPerformed

    private void atualizarEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarEmpresaButtonActionPerformed
        Empresa empresa = obterEmpresaInformada();
        String erro = null;

        if (empresa != null) {
            erro = controlador.alterarEmpresa(empresa);
        } else {
            erro = "Algum atributo de empresa não foi informado";
        }

        if (erro == null) {
            Empresa visao = (Empresa) empresasCadastradasComboBox.getSelectedItem();
            if(visao != null) {
                visao.setCNPJ(empresa.getCNPJ());
                visao.setNome(empresa.getNome());
                visao.setEndereco(empresa.getEndereco());
                empresasCadastradasComboBox.updateUI();
                empresasCadastradasComboBox.setSelectedItem(visao);
            }
        } else {
            informarErroEmpresa(erro);
        }
    }//GEN-LAST:event_atualizarEmpresaButtonActionPerformed

    private void removerEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerEmpresaButtonActionPerformed
        Empresa visao = (Empresa) empresasCadastradasComboBox.getSelectedItem();
        String erro = null;
        
        if(visao != null) {
            erro = controlador.removerEmpresa(visao.getCNPJ());
        }
        else
            erro = "Nenhuma empresa selecionada";

        if(erro == null) {
            empresasCadastradasComboBox.removeItem(visao);
        }
        else
            informarErroEmpresa(erro);
    }//GEN-LAST:event_removerEmpresaButtonActionPerformed

    private void buscarEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpresaButtonActionPerformed
        String erro = null;
        Empresa empresa = null;
        if(cnpjEmpresaTextField.getText() != null) {
            empresa = Empresa.buscarEmpresa(cnpjEmpresaTextField.getText());
            if(empresa == null) {
                erro = "Empresa não Cadastrada";
            }
        }
        else {
            erro = "Nenhuma empresa selecionada";
        }
        
        if(erro == null) {
            empresasCadastradasComboBox.setSelectedItem(empresa.getVisao());
            this.preencherCampos(empresa);
        }
        else {
            informarErroEmpresa(erro);
        }
    }//GEN-LAST:event_buscarEmpresaButtonActionPerformed

    private void limparCamposEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposEmpresaButtonActionPerformed
        this.limparTextos();
    }//GEN-LAST:event_limparCamposEmpresaButtonActionPerformed

    private void empresasCadastradasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresasCadastradasComboBoxActionPerformed
        this.selecionarEmpresa();
    }//GEN-LAST:event_empresasCadastradasComboBoxActionPerformed
    
    private void empresasCadastradasComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_empresasCadastradasComboBoxPropertyChange

    }//GEN-LAST:event_empresasCadastradasComboBoxPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarEmpresaButton;
    private javax.swing.JButton buscarEmpresaButton;
    private javax.swing.JButton cadastrarEmpresaButton;
    private javax.swing.JLabel cnpjEmpresaLabel;
    private javax.swing.JTextField cnpjEmpresaTextField;
    private javax.swing.JComboBox empresasCadastradasComboBox;
    private javax.swing.JLabel empresasCadastradasLabel;
    private javax.swing.JLabel enderecoEmpresaLabel;
    private javax.swing.JTextField enderecoEmpresaTextField;
    private javax.swing.JButton limparCamposEmpresaButton;
    private javax.swing.JLabel nomeEmpresaLabel;
    private javax.swing.JTextField nomeEmpresaTextField;
    private javax.swing.JButton removerEmpresaButton;
    // End of variables declaration//GEN-END:variables
}
