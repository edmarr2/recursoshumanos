/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Funcionário;
import entidade.Funcionário.EstadoCivil;
import entidade.Funcionário.Gênero;
import java.util.List;
/**
 *
 * @author edmar
 */
public class ControladorFuncionário {
    private Funcionário funcionario;

    public ControladorFuncionário() {
        this.funcionario = new Funcionário();
    }

    public void adicionarFuncionario(String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero) {
        Funcionário newFuncionario = new Funcionário(0, cpf, nome, cargo, salario, estadoCivil, genero);
        funcionario.adicionarFuncionario(newFuncionario);
    }

    public void atualizarFuncionario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero) {
        Funcionário updatedFuncionario = new Funcionário(id, cpf, nome, cargo, salario, estadoCivil, genero);
        funcionario.atualizarFuncionario(updatedFuncionario);
    }

    public void removerFuncionario(int id) {
        funcionario.removerFuncionario(id);
    }

    public Funcionário buscarFuncionarioPorId(int id) {
        return funcionario.buscarFuncionarioPorId(id);
    }

    public boolean verificarCpfExistente(String cpf) {
        return funcionario.verificarCpfExistente(cpf);
    }

    public List<Funcionário> listarFuncionarios() {
        return funcionario.listarFuncionarios();
    }
}
