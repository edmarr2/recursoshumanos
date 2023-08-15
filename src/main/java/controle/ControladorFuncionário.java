/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Funcionário;
import interfaces.JanelaCadastroFuncionários;

/**
 *
 * @author edmar
 */
public class ControladorFuncionário {
    public ControladorFuncionário() {
        new JanelaCadastroFuncionários(this).setVisible(true);
    }

    public String inserirFuncionário(Funcionário funcionario) {
        if(!Funcionário.verificarCpfExistente(funcionario.getCPF())) {
            return Funcionário.inserirFuncionario(funcionario);
        } else {
            return "Já existe um funcionário cadastrado com esse cpf";
        }
    }

    public String alterarFuncionario(Funcionário funcionario) {
        Funcionário updateFuncionário = Funcionário.buscarFuncionario(funcionario.getId());
        if(updateFuncionário != null) {
            return Funcionário.alterarFuncionario(funcionario);
        }
        else {
            return "Funcionário não cadastrado";
        }
    }

    public String removerFuncionário(Funcionário funcionario) {
        Funcionário removedFuncionário = Funcionário.buscarFuncionario(funcionario.getId());
        if(removedFuncionário != null) {
            return Funcionário.removerFuncionario(funcionario);
        }
        else {
            return "Funcionário não cadastrado";
        }
    }
}
