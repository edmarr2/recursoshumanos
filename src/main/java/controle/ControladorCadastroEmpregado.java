/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Empregado;
import entidade.Empregado.EstadoCivil;
import entidade.Empregado.Gênero;
import java.util.List;
/**
 *
 * @author edmar
 */
public class ControladorCadastroEmpregado {
    private Empregado empregado;
    public ControladorCadastroEmpregado() {
        this.empregado = new Empregado();
    }
    public void adicionarEmpregado(
            String cpf, 
            String nome, 
            String cargo, 
            double salário,
            EstadoCivil estadoCivil,
            Gênero gênero) {
        Empregado newEmpregado = new Empregado(cpf, nome, cargo, salário, estadoCivil, gênero);
        empregado.adicionarEmpregado(newEmpregado);
    }
    
    public void atualizarEmpregado(String cpf, String nome, String cargo, double salário, EstadoCivil estadoCivil, Gênero gênero) {
        Empregado newEmpregado = new Empregado(cpf, nome, cargo, salário, estadoCivil, gênero);
        empregado.atualizarEmpregado(newEmpregado);
    }
    
    public void removerEmpregado(String cpf) {
        empregado.removerEmpregado(cpf);
    }
    
    public Empregado buscarEmpregadoPorCPF(String cpf) {
        return empregado.buscarEmpregadoPorCPF(cpf);
    }
    
    public boolean verificarCpfExistente(String cpf) {
       return empregado.verificarCpfExistente(cpf);
    }
    
    public List<Empregado> listarEmpregados() {
        return empregado.listarEmpregados();
    }
}
