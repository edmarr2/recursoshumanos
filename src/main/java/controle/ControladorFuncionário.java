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
    private Funcionário funcionário;

    public ControladorFuncionário() {
        this.funcionário = new Funcionário();
    }

    public void adicionarFuncionário(String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo) {
        Funcionário newFuncionário = new Funcionário(0, cpf, nome, cargo, salario, estadoCivil, genero, ativo);
        funcionário.adicionarFuncionário(newFuncionário);
    }

    public void atualizarFuncionario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo) {
        Funcionário newFuncionário = new Funcionário(id, cpf, nome, cargo, salario, estadoCivil, genero, ativo);
        funcionário.atualizarFuncionário(newFuncionário);
    }

    public void removerFuncionário(int id) {
        funcionário.removerFuncionário(id);
    }

    public Funcionário buscarFuncionárioPorId(int id) {
        return funcionário.buscarFuncionárioPorId(id);
    }
    
    public Funcionário buscarFuncionárioPorCpf(String cpf) {
        return funcionário.buscarFuncionárioPorCpf(cpf);
    }

    public boolean verificarCpfExistente(String cpf) {
        return funcionário.verificarCpfExistente(cpf);
    }

    public List<Funcionário> listarFuncionários() {
        return funcionário.listarFuncionários();
    }
}
