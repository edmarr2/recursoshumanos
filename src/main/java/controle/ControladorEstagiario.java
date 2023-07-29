/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Estagiario;
import entidade.Funcionario.EstadoCivil;
import entidade.Funcionario.Gênero;
/**
 *
 * @author edmar
 */
public class ControladorEstagiario {
    private Estagiario estagiario;

    public ControladorEstagiario() {
        this.estagiario = new Estagiario();
    }

    public void adicionarEstagiario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, String curso, int cargaHoraria) {
        Estagiario newEstagiario = new Estagiario(id, cpf, nome, cargo, salario, estadoCivil, genero, curso, cargaHoraria);
        estagiario.adicionarEstagiario(newEstagiario);
    }

    public void atualizarEstagiario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, String curso, int cargaHoraria) {
        Estagiario updatedEstagiario = new Estagiario(id, cpf, nome, cargo, salario, estadoCivil, genero, curso, cargaHoraria);
        estagiario.atualizarEstagiario(updatedEstagiario);
    }

    public void removerEstagiario(int id) {
        estagiario.removerEstagiario(id);
    }

    public Estagiario buscarEstagiarioPorId(int id) {
        return estagiario.buscarEstagiarioPorId(id);
    }
}
