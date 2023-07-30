/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Estagiário;
import entidade.Funcionário.EstadoCivil;
import entidade.Funcionário.Gênero;
/**
 *
 * @author edmar
 */
public class ControladorEstagiário {
    private Estagiário estagiario;

    public ControladorEstagiário() {
        this.estagiario = new Estagiário();
    }

    public void adicionarEstagiario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo, String curso, int cargaHoraria) {
        Estagiário newEstagiario = new Estagiário(id, cpf, nome, cargo, salario, estadoCivil, genero, ativo, curso, cargaHoraria);
        estagiario.adicionarEstagiario(newEstagiario);
    }

    public void atualizarEstagiario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, boolean ativo, String curso, int cargaHoraria) {
        Estagiário newEstagiario = new Estagiário(id, cpf, nome, cargo, salario, estadoCivil, genero, ativo, curso, cargaHoraria);
        estagiario.atualizarEstagiario(newEstagiario);
    }

    public void removerEstagiario(int id) {
        estagiario.removerEstagiario(id);
    }

    public Estagiário buscarEstagiarioPorId(int id) {
        return estagiario.buscarEstagiarioPorId(id);
    }
}
