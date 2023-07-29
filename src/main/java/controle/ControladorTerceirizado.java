/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Terceirizado;
import entidade.Funcionário.EstadoCivil;
import entidade.Funcionário.Gênero;
/**
 *
 * @author edmar
 */
public class ControladorTerceirizado {
    private Terceirizado terceirizado;

    public ControladorTerceirizado() {
        this.terceirizado = new Terceirizado();
    }

    public void adicionarTerceirizado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, String empresaContratada, String duracaoContrato) {
        Terceirizado newTerceirizado = new Terceirizado(id, cpf, nome, cargo, salario, estadoCivil, genero, empresaContratada, duracaoContrato);
        terceirizado.adicionarTerceirizado(newTerceirizado);
    }

    public void atualizarTerceirizado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero genero, String empresaContratada, String duracaoContrato) {
        Terceirizado updatedTerceirizado = new Terceirizado(id, cpf, nome, cargo, salario, estadoCivil, genero, empresaContratada, duracaoContrato);
        terceirizado.atualizarTerceirizado(updatedTerceirizado);
    }

    public void removerTerceirizado(int id) {
        terceirizado.removerTerceirizado(id);
    }

    public Terceirizado buscarTerceirizadoPorId(int id) {
        return terceirizado.buscarTerceirizadoPorId(id);
    }
}
