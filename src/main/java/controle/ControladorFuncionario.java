/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Funcionario;
import entidade.Funcionario.EstadoCivil;
import entidade.Funcionario.Gênero;
import java.util.List;
/**
 *
 * @author edmar
 */
public class ControladorFuncionario {
    private Funcionario funcionario;

    public ControladorFuncionario() {
        this.funcionario = new Funcionario();
    }

    public void adicionarFuncionario(String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero) {
        Funcionario newFuncionario = new Funcionario(0, cpf, nome, cargo, salario, estadoCivil, genero);
        funcionario.adicionarFuncionario(newFuncionario);
    }

    public void atualizarFuncionario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero) {
        Funcionario updatedFuncionario = new Funcionario(id, cpf, nome, cargo, salario, estadoCivil, genero);
        funcionario.atualizarFuncionario(updatedFuncionario);
    }

    public void removerFuncionario(int id) {
        funcionario.removerFuncionario(id);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionario.buscarFuncionarioPorId(id);
    }

    public boolean verificarCpfExistente(String cpf) {
        return funcionario.verificarCpfExistente(cpf);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionario.listarFuncionarios();
    }
}
