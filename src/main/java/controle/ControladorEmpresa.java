/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidade.Empresa;
import interfaces.JanelaCadastroEmpresas;

/**
 *
 * @author edmar
 */
public class ControladorEmpresa {
    public ControladorEmpresa() {
        new JanelaCadastroEmpresas(this).setVisible(true);
    }

    public String inserirEmpresa(Empresa empresa) {
        Empresa newEmpresa = Empresa.buscarEmpresa(empresa.getCNPJ());
        if(newEmpresa == null) {
            return Empresa.inserirEmpresa(empresa);
        } else {
            return "CNPJ da empresa já cadastrado";
        }
    }

    public String alterarEmpresa(Empresa empresa) {
        Empresa updatedEmpresa = Empresa.buscarEmpresa(empresa.getCNPJ());
        if(updatedEmpresa != null) {
            return Empresa.alterarEmpresa(empresa);
        } else {
            return "CNPJ da empresa não cadastrado";
        }
    }

    public String removerEmpresa(String cnpj) {
        Empresa removedEmpresa = Empresa.buscarEmpresa(cnpj);
        if(removedEmpresa != null) {
            return Empresa.removerEmpresa(cnpj);
        } else {
            return "CNPJ da empresa não cadastrado";
        }
    }
}
