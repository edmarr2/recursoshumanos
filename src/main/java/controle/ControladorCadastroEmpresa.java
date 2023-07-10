/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidade.Empresa;
import interfaces.JanelaCadastroEmpresas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author edmar
 */
public class ControladorCadastroEmpresa {
    private Empresa empresa;

    public ControladorCadastroEmpresa() {
        this.empresa = new Empresa();
    }
    
    public void adicionarEmpresa(
            String cnpj, 
            String nome, 
            String endereço) {
        Empresa newEmpresa = new Empresa(0, cnpj, nome, endereço);
        empresa.adicionarEmpresa(newEmpresa);
    }
    
    public void atualizarEmpresa(int id, String cnpj, String nome, String endereço) {
        Empresa newEmpresa = new Empresa(id, cnpj, nome, endereço);
        empresa.atualizarEmpresa(newEmpresa);
    }
    
    public void removerEmpresa(int id) {
        empresa.removerEmpresa(id);
    }
    
    public Empresa buscarEmpresaPorCNPJ(String cnpj) {
        return empresa.buscarEmpresaPorCNPJ(cnpj);
    }
    
    public Empresa buscarEmpresaPorID(int id) {
        return empresa.buscarEmpresaPorID(id);
    }
    
    public boolean verificarCnpjExistente(String cnpj) {
       return empresa.verificarCnpjExistente(cnpj);
    }
    
    public List<Empresa> listarEmpresas() {
        return empresa.listarEmpresas();
    }
}
