/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Empregado;
import entidade.Funcionário.EstadoCivil;
import entidade.Funcionário.Gênero;
/**
 *
 * @author edmar
 */
public class ControladorEmpregado {
    private Empregado empregado;

    public ControladorEmpregado() {
        this.empregado = new Empregado();
    }

    public void adicionarEmpregado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo, String departamento, int avaliacaoDeDesempenho) {
        Empregado newEmpregado = new Empregado(id, cpf, nome, cargo, salario, estadoCivil, genero, ativo, departamento, avaliacaoDeDesempenho);
        empregado.adicionarEmpregado(newEmpregado);
    }

    public void atualizarEmpregado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo, String departamento, int avaliacaoDeDesempenho) {
        Empregado newEmpregado = new Empregado(id, cpf, nome, cargo, salario, estadoCivil, genero, ativo, departamento, avaliacaoDeDesempenho);
        empregado.atualizarEmpregado(newEmpregado);
    }

    public void removerEmpregado(int id) {
        empregado.removerEmpregado(id);
    }

    public Empregado buscarEmpregadoPorId(int id) {
        return empregado.buscarEmpregadoPorId(id);
    }
}
