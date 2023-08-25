/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import controle.ControladorFuncionário;
import entidade.Empregado;
import entidade.Estagiário;
import entidade.Funcionário;
import entidade.Funcionário.EstadoCivil;
import entidade.Terceirizado;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author edmar
 */
public class JanelaCadastroFuncionários extends javax.swing.JFrame {
    ControladorFuncionário controlador;
    private DefaultListModel<Funcionário> listaFuncionarios;
    PainelEmpregado painelEmpregado;
    PainelEstagiário painelEstagiario;
    PainelTerceirizado painelTerceirizado;
    public JanelaCadastroFuncionários(ControladorFuncionário controlador) {
        this.controlador = controlador;
        initComponents();
        inicializarListaFuncionários();
        painelEmpregado = new PainelEmpregado();
        painelEstagiario = new PainelEstagiário();
        painelTerceirizado = new PainelTerceirizado();
        subclassesTabbedPane.addTab("Empregado", painelEmpregado);
        subclassesTabbedPane.addTab("Estagiário", painelEstagiario);
        subclassesTabbedPane.addTab("Terceirizado", painelTerceirizado);
        limparTextos();
    }
    private void inicializarListaFuncionários() {
        listaFuncionarios = new DefaultListModel<>();
        Funcionário[] visoes = Funcionário.getVisoes();
        for (Funcionário visao : visoes) {
            listaFuncionarios.addElement(visao);
        }

        funcionáriosCadastradosList.setModel(listaFuncionarios);
    }
    private Funcionário obterFuncionario() {
        Funcionário funcionario = null;
        
        String idStr = idFuncionárioTextField.getText();
        int id = 0;
        String cpf = cpfFuncionárioTextField.getText();
        String nome = nomeFuncionárioTextField.getText();
        String cargo = cargoFuncionárioTextField.getText();
        String salarioStr = salárioFuncionárioTextField.getText();
        char sexo;
        double salario = 0.0;
        boolean ativo = false;
        EstadoCivil estadoCivil;
        if(cpf.isEmpty() || nome.isEmpty() || cargo.isEmpty() || salarioStr.isEmpty()) {
            return null;
        }
        salario = Double.parseDouble(salarioStr);
        if(!idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
        }
        if(sexoButtonGroup.getSelection() != null) {
            sexo = (char) sexoButtonGroup.getSelection().getMnemonic();
        }
        else {return null;}
        if(estadoCivilButtonGroup.getSelection() != null) {
            estadoCivil = EstadoCivil.values()[estadoCivilButtonGroup.getSelection().getMnemonic()];
        } else {return null;}
        ativo = ativoCheckBox.isSelected();
        int indice_aba_selecionada = subclassesTabbedPane.getSelectedIndex();
        switch(indice_aba_selecionada) {
            case 0:
                String departamento = painelEmpregado.getDepartamento();
                int avaliacao = painelEmpregado.getAvaliacao();
                funcionario = new Empregado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo,
                departamento, avaliacao);
                break;
            case 1:
                String curso = painelEstagiario.getCurso();
                int cargaHoraria = painelEstagiario.getCargaHoraria();
                funcionario = new Estagiário(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo,
                curso, cargaHoraria);
                break;
            case 2:
                String empresaContratada = painelTerceirizado.getEmpresaContratada();
                String duracaoContrato = painelTerceirizado.getDuracaoContrato();
                funcionario = new Terceirizado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo,
                empresaContratada, duracaoContrato);
                break;
        }
        
        return funcionario;
    }
    private void limparTextos(){
        idFuncionárioTextField.setText("");
        nomeFuncionárioTextField.setText("");
        cargoFuncionárioTextField.setText("");
        salárioFuncionárioTextField.setText("");
        cpfFuncionárioTextField.setText("");

        sexoButtonGroup.clearSelection();
        estadoCivilButtonGroup.clearSelection();
        ativoCheckBox.setSelected(false);
        painelEmpregado.limparTexto();
        painelEstagiario.limparTexto();
        painelTerceirizado.limparTexto();
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    private void selecionarSexoRadioButton(char sexo) {
        switch(sexo) {
            case 'M': 
                masculinoRadioButton.setSelected(true);
                break;
            case 'F':
                femininoRadioButton.setSelected(true);
                break;
        }
    }
    private void selecionarEstadoCivilRadioButton(int estadoCivil) {
        switch(estadoCivil) {
            case 0:
                solteiroRadioButton.setSelected(true);
                break;
            case 1:
                casadoRadioButton.setSelected(true);
                break;
            case 2:
                divorciadoRadioButton.setSelected(true);
                break;
            case 3:
                viuvoRadioButton.setSelected(true);
                break;
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

        sexoButtonGroup = new javax.swing.ButtonGroup();
        estadoCivilButtonGroup = new javax.swing.ButtonGroup();
        nomeFuncionárioLabel = new javax.swing.JLabel();
        cargoFuncionárioLabel = new javax.swing.JLabel();
        salárioFuncionárioLabel = new javax.swing.JLabel();
        nomeFuncionárioTextField = new javax.swing.JTextField();
        cargoFuncionárioTextField = new javax.swing.JTextField();
        salárioFuncionárioTextField = new javax.swing.JTextField();
        cadastrarFuncionárioButton = new javax.swing.JButton();
        atualizarFuncionárioButton = new javax.swing.JButton();
        limparCamposButton = new javax.swing.JButton();
        removerFuncionárioButton = new javax.swing.JButton();
        buscarFuncionárioButton = new javax.swing.JButton();
        idFuncionárioLabel = new javax.swing.JLabel();
        cpfFuncionárioTextField = new javax.swing.JTextField();
        funcionáriosScrollPane = new javax.swing.JScrollPane();
        funcionáriosCadastradosList = new javax.swing.JList();
        listagemFuncionáriosLabel = new javax.swing.JLabel();
        ativoFuncionárioLabel = new javax.swing.JLabel();
        ativoCheckBox = new javax.swing.JCheckBox();
        subclassesTabbedPane = new javax.swing.JTabbedPane();
        cpfFuncionárioLabel = new javax.swing.JLabel();
        idFuncionárioTextField = new javax.swing.JTextField();
        sexoPanel = new javax.swing.JPanel();
        masculinoRadioButton = new javax.swing.JRadioButton();
        femininoRadioButton = new javax.swing.JRadioButton();
        sexoFuncionárioLabel = new javax.swing.JLabel();
        estadoCivilLabel = new javax.swing.JLabel();
        estado_civilPanel = new javax.swing.JPanel();
        solteiroRadioButton = new javax.swing.JRadioButton();
        casadoRadioButton = new javax.swing.JRadioButton();
        divorciadoRadioButton = new javax.swing.JRadioButton();
        viuvoRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Funcionários");

        nomeFuncionárioLabel.setText("Nome:");

        cargoFuncionárioLabel.setText("Cargo:");

        salárioFuncionárioLabel.setText("Salário:");

        nomeFuncionárioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFuncionárioTextFieldActionPerformed(evt);
            }
        });

        cargoFuncionárioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargoFuncionárioTextFieldActionPerformed(evt);
            }
        });

        salárioFuncionárioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salárioFuncionárioTextFieldActionPerformed(evt);
            }
        });
        salárioFuncionárioTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salárioFuncionárioTextFieldKeyTyped(evt);
            }
        });

        cadastrarFuncionárioButton.setText("Adicionar");
        cadastrarFuncionárioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFuncionárioButtonActionPerformed(evt);
            }
        });

        atualizarFuncionárioButton.setText("Atualizar");
        atualizarFuncionárioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarFuncionárioButtonActionPerformed(evt);
            }
        });

        limparCamposButton.setText("Limpar Campos");
        limparCamposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposButtonActionPerformed(evt);
            }
        });

        removerFuncionárioButton.setText("Remover");
        removerFuncionárioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerFuncionárioButtonActionPerformed(evt);
            }
        });

        buscarFuncionárioButton.setText("Buscar");
        buscarFuncionárioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFuncionárioButtonActionPerformed(evt);
            }
        });

        idFuncionárioLabel.setText("ID:");
        idFuncionárioLabel.setEnabled(false);

        cpfFuncionárioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFuncionárioTextFieldActionPerformed(evt);
            }
        });

        funcionáriosCadastradosList.setModel(new DefaultListModel());
        funcionáriosCadastradosList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                funcionáriosCadastradosListValueChanged(evt);
            }
        });
        funcionáriosScrollPane.setViewportView(funcionáriosCadastradosList);

        listagemFuncionáriosLabel.setText("Funcionários");

        ativoFuncionárioLabel.setText("Situação:");

        ativoCheckBox.setText("Ativo");
        ativoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ativoCheckBoxActionPerformed(evt);
            }
        });

        subclassesTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));

        cpfFuncionárioLabel.setText("CPF:");

        idFuncionárioTextField.setEnabled(false);
        idFuncionárioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFuncionárioTextFieldActionPerformed(evt);
            }
        });

        sexoPanel.setPreferredSize(new java.awt.Dimension(151, 33));

        sexoButtonGroup.add(masculinoRadioButton);
        masculinoRadioButton.setMnemonic('M');
        masculinoRadioButton.setText("Masculino");
        sexoPanel.add(masculinoRadioButton);

        sexoButtonGroup.add(femininoRadioButton);
        femininoRadioButton.setMnemonic('F');
        femininoRadioButton.setText("Feminino");
        sexoPanel.add(femininoRadioButton);

        sexoFuncionárioLabel.setText("Sexo");

        estadoCivilLabel.setText("Estado Civil");

        estado_civilPanel.setPreferredSize(new java.awt.Dimension(271, 33));

        estadoCivilButtonGroup.add(solteiroRadioButton);
        solteiroRadioButton.setText("Solteiro");
        estado_civilPanel.add(solteiroRadioButton);

        estadoCivilButtonGroup.add(casadoRadioButton);
        casadoRadioButton.setMnemonic('\u0001');
        casadoRadioButton.setText("Casado");
        casadoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casadoRadioButtonActionPerformed(evt);
            }
        });
        estado_civilPanel.add(casadoRadioButton);

        estadoCivilButtonGroup.add(divorciadoRadioButton);
        divorciadoRadioButton.setMnemonic('\u0002');
        divorciadoRadioButton.setText("Divorciado");
        estado_civilPanel.add(divorciadoRadioButton);

        estadoCivilButtonGroup.add(viuvoRadioButton);
        viuvoRadioButton.setMnemonic('\u0003');
        viuvoRadioButton.setText("Viuvo");
        estado_civilPanel.add(viuvoRadioButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(listagemFuncionáriosLabel)
                .addGap(64, 64, 64)
                .addComponent(funcionáriosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(idFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(idFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cpfFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(cpfFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nomeFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(nomeFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cargoFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(cargoFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(salárioFuncionárioLabel)
                .addGap(88, 88, 88)
                .addComponent(salárioFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(subclassesTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cadastrarFuncionárioButton)
                .addGap(31, 31, 31)
                .addComponent(buscarFuncionárioButton)
                .addGap(29, 29, 29)
                .addComponent(atualizarFuncionárioButton)
                .addGap(28, 28, 28)
                .addComponent(removerFuncionárioButton)
                .addGap(24, 24, 24)
                .addComponent(limparCamposButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sexoFuncionárioLabel)
                        .addGap(43, 43, 43)
                        .addComponent(sexoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estadoCivilLabel)
                        .addGap(12, 12, 12)
                        .addComponent(estado_civilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ativoFuncionárioLabel)
                    .addComponent(ativoCheckBox)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listagemFuncionáriosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcionáriosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpfFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cpfFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargoFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargoFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salárioFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salárioFuncionárioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ativoFuncionárioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ativoCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(sexoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(sexoFuncionárioLabel)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(estadoCivilLabel))
                            .addComponent(estado_civilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addComponent(subclassesTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrarFuncionárioButton)
                    .addComponent(buscarFuncionárioButton)
                    .addComponent(atualizarFuncionárioButton)
                    .addComponent(removerFuncionárioButton)
                    .addComponent(limparCamposButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFuncionárioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFuncionárioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFuncionárioTextFieldActionPerformed

    private void cargoFuncionárioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargoFuncionárioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargoFuncionárioTextFieldActionPerformed

    private void salárioFuncionárioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salárioFuncionárioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salárioFuncionárioTextFieldActionPerformed

    private void cadastrarFuncionárioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFuncionárioButtonActionPerformed
        Funcionário funcionario = obterFuncionario();
        String erro = null;
        if(funcionario != null) {erro = controlador.inserirFuncionário(funcionario);}
        else {erro = "Algum atributo do funcionario não foi informado";}
            
        if(erro == null) {
            int id = 0;
            if(Funcionário.ultimoID() > 0){
                id = Funcionário.ultimoID();
            }
            funcionario.setId(id);
            Funcionário visao;
            switch (subclassesTabbedPane.getSelectedIndex()) {
                case 0:
                    visao = (Empregado) funcionario.getVisao();
                    break;
                case 1:
                    visao = (Estagiário) funcionario.getVisao();
                    break;
                default:
                    visao = (Terceirizado) funcionario.getVisao();
                    break;
            }
            listaFuncionarios.addElement(funcionario);
            funcionáriosCadastradosList.setSelectedIndex(listaFuncionarios.size() - 1);
            idFuncionárioTextField.setText("" + id);
            funcionáriosCadastradosList.updateUI();
        }else {informarErro(erro);}
    }//GEN-LAST:event_cadastrarFuncionárioButtonActionPerformed
 
    private void atualizarFuncionárioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarFuncionárioButtonActionPerformed
        Funcionário funcionario = obterFuncionario();
        String erro = null;
        if(funcionario != null) {
            erro = controlador.alterarFuncionario(funcionario);
        }
        else {
            erro = "Algum atributo não foi informado";
        }
        if(erro == null) {
            Funcionário visao = (Funcionário) funcionáriosCadastradosList.getSelectedValue();
            if (visao != null) {
                visao.setId(funcionario.getId());
                visao.setNome(funcionario.getNome());
                visao.setCPF(funcionario.getCPF());

                DefaultListModel<Funcionário> modelo = (DefaultListModel<Funcionário>) funcionáriosCadastradosList.getModel();
                int selectedIndex = funcionáriosCadastradosList.getSelectedIndex();

                if (selectedIndex >= 0) {
                    modelo.setElementAt(visao, selectedIndex);
                }
            }
        }
        else {informarErro(erro);}

    }//GEN-LAST:event_atualizarFuncionárioButtonActionPerformed

    private void limparCamposButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposButtonActionPerformed
        this.limparTextos();
    }//GEN-LAST:event_limparCamposButtonActionPerformed

    private void removerFuncionárioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerFuncionárioButtonActionPerformed
        Funcionário visao = (Funcionário) funcionáriosCadastradosList.getSelectedValue();
        String erro = null;
        
        if(visao != null) {
            erro = controlador.removerFuncionário(visao);
        }
        else
            erro = "Nenhum funcionario selecionado";

        if(erro == null) {
            DefaultListModel<Funcionário> modelo = (DefaultListModel<Funcionário>) funcionáriosCadastradosList.getModel();
            modelo.removeElement(visao);
            if(listaFuncionarios.size() > 0) {
                funcionáriosCadastradosList.setSelectedIndex(0);
            }else {
                funcionáriosCadastradosList.setSelectedIndex(-1);
            }
            limparTextos();
        }
        else {
            informarErro(erro);
        }
    }//GEN-LAST:event_removerFuncionárioButtonActionPerformed

    private void buscarFuncionárioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFuncionárioButtonActionPerformed
        Funcionário visao = (Funcionário) funcionáriosCadastradosList.getSelectedValue();
        String erro = null;
        Funcionário funcionario = null;
        if(visao != null) {
            funcionario = Funcionário.buscarFuncionario(visao.getId());
            if(funcionario == null){erro = "Funcionario não Cadastrado";}
        } else { erro = "Nenhum funcionario selecionado selecionado";}
        
        if(erro == null) {
            idFuncionárioTextField.setText(Integer.toString(funcionario.getId()));
            nomeFuncionárioTextField.setText(funcionario.getNome());
            cargoFuncionárioTextField.setText(funcionario.getCargo());
            salárioFuncionárioTextField.setText(Double.toString(funcionario.getSalário()));
            cpfFuncionárioTextField.setText(funcionario.getCPF());
            selecionarSexoRadioButton(funcionario.getSexo());
            selecionarEstadoCivilRadioButton(funcionario.getEstadoCivil().ordinal());
            ativoCheckBox.setSelected(funcionario.getAtivo());
        }
        else {informarErro(erro);}
        if(funcionario instanceof Empregado) {
            subclassesTabbedPane.setSelectedIndex(0);
            Empregado empregado = (Empregado) funcionario;
            painelEmpregado.setDepartamento(empregado.getDepartamento());
            painelEmpregado.setAvaliacao(empregado.getAvaliacaoDeDesempenho());
        } else if(funcionario instanceof Estagiário) {
            subclassesTabbedPane.setSelectedIndex(1);
            Estagiário estagiario = (Estagiário) funcionario;
            painelEstagiario.setCurso(estagiario.getCurso());
            painelEstagiario.setCargaHoraria(estagiario.getCargaHoraria());
        } else {
            subclassesTabbedPane.setSelectedIndex(2);
            Terceirizado terceirizado = (Terceirizado) funcionario;
            painelTerceirizado.setEmpresaContratada(terceirizado.getEmpresaContratada());
            painelTerceirizado.setDuracaoContrato(terceirizado.getDuracaoContrato());
        }
    }//GEN-LAST:event_buscarFuncionárioButtonActionPerformed

    private void cpfFuncionárioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFuncionárioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFuncionárioTextFieldActionPerformed

    private void funcionáriosCadastradosListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_funcionáriosCadastradosListValueChanged

    }//GEN-LAST:event_funcionáriosCadastradosListValueChanged

    private void ativoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ativoCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ativoCheckBoxActionPerformed

    private void salárioFuncionárioTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salárioFuncionárioTextFieldKeyTyped
        char caracteres = evt.getKeyChar();
        
        if(!Character.isDigit(caracteres)){
            evt.consume();
        }
    }//GEN-LAST:event_salárioFuncionárioTextFieldKeyTyped

    private void idFuncionárioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFuncionárioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFuncionárioTextFieldActionPerformed

    private void casadoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casadoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casadoRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ativoCheckBox;
    private javax.swing.JLabel ativoFuncionárioLabel;
    private javax.swing.JButton atualizarFuncionárioButton;
    private javax.swing.JButton buscarFuncionárioButton;
    private javax.swing.JButton cadastrarFuncionárioButton;
    private javax.swing.JLabel cargoFuncionárioLabel;
    private javax.swing.JTextField cargoFuncionárioTextField;
    private javax.swing.JRadioButton casadoRadioButton;
    private javax.swing.JLabel cpfFuncionárioLabel;
    private javax.swing.JTextField cpfFuncionárioTextField;
    private javax.swing.JRadioButton divorciadoRadioButton;
    private javax.swing.ButtonGroup estadoCivilButtonGroup;
    private javax.swing.JLabel estadoCivilLabel;
    private javax.swing.JPanel estado_civilPanel;
    private javax.swing.JRadioButton femininoRadioButton;
    private javax.swing.JList funcionáriosCadastradosList;
    private javax.swing.JScrollPane funcionáriosScrollPane;
    private javax.swing.JLabel idFuncionárioLabel;
    private javax.swing.JTextField idFuncionárioTextField;
    private javax.swing.JButton limparCamposButton;
    private javax.swing.JLabel listagemFuncionáriosLabel;
    private javax.swing.JRadioButton masculinoRadioButton;
    private javax.swing.JLabel nomeFuncionárioLabel;
    private javax.swing.JTextField nomeFuncionárioTextField;
    private javax.swing.JButton removerFuncionárioButton;
    private javax.swing.JLabel salárioFuncionárioLabel;
    private javax.swing.JTextField salárioFuncionárioTextField;
    private javax.swing.ButtonGroup sexoButtonGroup;
    private javax.swing.JLabel sexoFuncionárioLabel;
    private javax.swing.JPanel sexoPanel;
    private javax.swing.JRadioButton solteiroRadioButton;
    private javax.swing.JTabbedPane subclassesTabbedPane;
    private javax.swing.JRadioButton viuvoRadioButton;
    // End of variables declaration//GEN-END:variables
}
