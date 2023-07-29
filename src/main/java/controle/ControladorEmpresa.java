/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidade.Empresa;
import java.util.List;

/**
 *
 * @author edmar
 */
public class ControladorEmpresa {
    private Empresa empresa;

    public ControladorEmpresa() {
        this.empresa = new Empresa();
    }

    public void adicionarEmpresa(String cnpj, String nome, String endereco) {
        Empresa newEmpresa = new Empresa(cnpj, nome, endereco);
        empresa.adicionarEmpresa(newEmpresa);
    }

    public void atualizarEmpresa(String cnpj, String nome, String endereco) {
        Empresa updatedEmpresa = new Empresa(cnpj, nome, endereco);
        empresa.atualizarEmpresa(updatedEmpresa);
    }

    public void removerEmpresa(String cnpj) {
        empresa.removerEmpresa(cnpj);
    }

    public Empresa buscarEmpresaPorCNPJ(String cnpj) {
        return empresa.buscarEmpresaPorCNPJ(cnpj);
    }

    public List<Empresa> listarEmpresas() {
        return empresa.listarEmpresas();
    }

    public boolean verificarCnpjExistente(String cnpj) {
        return empresa.verificarCnpjExistente(cnpj);
    }
}
