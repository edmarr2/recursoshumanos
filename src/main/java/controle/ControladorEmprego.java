/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidade.Emprego;
import interfaces.JanelaCadastroEmprego;

/**
 *
 * @author edmar
 */
public class ControladorEmprego {
    public ControladorEmprego() {
        new JanelaCadastroEmprego(this).setVisible(true);
    }
    
    public String inserirEmprego(Emprego emprego) {
        if (!Emprego.existeEmprego(emprego.getFuncionario().getId(), emprego.getEmpresa().getCNPJ())) {
            return Emprego.inserirEmprego(emprego);
        }
        return "Emprego já cadastrado";
    }
    
    public String alterarEmprego(Emprego emprego_informado) {
        Emprego emprego_cadastrado = Emprego.buscarEmprego(emprego_informado.getId());
        if ((emprego_informado.getFuncionario().getId() == emprego_cadastrado.getFuncionario().getId()) && 
                (emprego_informado.getEmpresa().getCNPJ().equals(emprego_cadastrado.getEmpresa().getCNPJ()))) {
            return Emprego.alterarEmprego(emprego_informado);
        } else {
            return "Alteração não permitida: chave do funcionário e/ou empresa foram alteradas";
        }
    }
    
    public String removerEmprego(int id) {
        if (Emprego.existeEmprego(id)) {
            return Emprego.removerEmprego(id);
        } else {
            return "ID não corresponde a nenhum emprego";
        }
    }
}
