/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import entidade.Empregado;
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
            int empresaId) {
        Empregado newEmpregado = new Empregado(0, cpf, nome, cargo, salário, empresaId);
        empregado.adicionarEmpregado(newEmpregado);
    }
    
    public void atualizarEmpregado(int id, String cpf, String nome, String cargo, double salário, int empresaId) {
        Empregado newEmpregado = new Empregado(id, cpf, nome, cargo, salário, empresaId);
        empregado.atualizarEmpregado(newEmpregado);
    }
    
    public void removerEmpregado(int id) {
        empregado.removerEmpregado(id);
    }
    
    public Empregado buscarEmpregadoPorCPF(String cpf) {
        return empregado.buscarEmpregadoPorCPF(cpf);
    }
    
    public boolean verificarCpfExistente(String cpf) {
       return empregado.verificarCpfExistente(cpf);
    }
    
    public List<Empregado> listarEmpregadosPorEmpresa(int empresaId) {
        return empregado.listarEmpregadosPorEmpresa(empresaId);
    }
}
