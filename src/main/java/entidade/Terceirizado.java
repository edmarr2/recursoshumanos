/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author edmar
 */
public class Terceirizado extends Funcionário {
    private String empresaContratada;
    private String duracaoContrato;
    
    public Terceirizado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, char sexo, boolean ativo) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
    }
    
    public Terceirizado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, char sexo, boolean ativo, String empresaContratada, String duracaoContrato) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
        this.empresaContratada = empresaContratada;
        this.duracaoContrato = duracaoContrato;
    }

    public String getEmpresaContratada() {
        return empresaContratada;
    }

    public void setEmpresaContratada(String empresaContratada) {
        this.empresaContratada = empresaContratada;
    }

    public String getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(String duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }

    @Override
    public int getId() {
        return super.getId();
    }
    
    @Override
    public String getCPF() {
        return super.getCPF();
    }
   
    @Override
    public String getNome() {
        return super.getNome();
    }
    @Override
    public String getCargo() {
        return super.getCargo();
    }
    
    @Override
    public double getSalário() {
        return super.getSalário();
    }
    
    @Override
    public EstadoCivil getEstadoCivil() {
        return super.getEstadoCivil();
    }
    
    @Override
    public boolean getAtivo() {
        return super.getAtivo();
    }

    @Override
    public char getSexo() {
        return super.getSexo();
    }

    @Override
    public Terceirizado getVisao() {
        return new Terceirizado(super.getId(), super.getCPF(), super.getNome(), super.getCargo(),
                super.getSalário(), super.getEstadoCivil(), super.getSexo(), super.getAtivo());
    }
    
    @Override
    public void setId(int id) {
        super.setId(id);
    }
    
    @Override
    public void setCPF(String cpf) {
        super.setCPF(cpf);
    }
    
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    
    @Override
    public void setCargo(String cargo) {
        super.setCargo(cargo);
    }

    @Override
    public void setSalario(double salario) {
        super.setSalario(salario);
    }    
    
    @Override
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        super.setEstadoCivil(estadoCivil);
    } 
    
    @Override
    public void setSexo(char sexo) {
        super.setSexo(sexo);
    } 
    
    @Override
    public void setAtivo(boolean ativo) {
        super.setAtivo(ativo);
    }     
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + super.toString();
    }
}
