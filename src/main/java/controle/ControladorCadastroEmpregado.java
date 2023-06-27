/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Empregado;
/**
 *
 * @author edmar
 */
public class ControladorCadastroEmpregado {
    private Empregado empregado;
    public ControladorCadastroEmpregado() {
        this.empregado = new Empregado();
    }
    public void adicionarEmpregado(String nome, String cargo, double salário) {
        Empregado newEmpregado = new Empregado(0, nome, cargo, salário);
        empregado.adicionarEmpregado(newEmpregado);
    }
    
    public void atualizarEmpregado(int id, String nome, String cargo, double salario) {
        Empregado newEmpregado = new Empregado(id, nome, cargo, salario);
        empregado.atualizarEmpregado(newEmpregado);
    }
    
    public void removerEmpregado(int id) {
        empregado.removerEmpregado(id);
    }
    
    public Empregado buscarEmpregadoPorNome(String nome) {
        return empregado.buscarEmpregadoPorNome(nome);
    }
}
