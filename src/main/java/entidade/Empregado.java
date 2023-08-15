/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author edmar
 */
public class Empregado extends Funcionário{
    private String departamento;
    private int avaliacaoDeDesempenho;

    public Empregado(int id, String cpf, String nome, String cargo, double salario, 
            EstadoCivil estadoCivil, char sexo, boolean ativo) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
    }
    
    public Empregado(int id, String cpf, String nome, String cargo, double salario, 
            EstadoCivil estadoCivil, char sexo, boolean ativo, String departamento, 
            int avaliacaoDeDesempenho) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
        this.departamento = departamento;
        this.avaliacaoDeDesempenho = avaliacaoDeDesempenho;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getAvaliacaoDeDesempenho() {
        return avaliacaoDeDesempenho;
    }

    public void setAvaliacaoDeDesempenho(int avaliacaoDeDesempenho) {
        this.avaliacaoDeDesempenho = avaliacaoDeDesempenho;
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
    public Empregado getVisao() {
        return new Empregado(super.getId(), super.getCPF(), super.getNome(), super.getCargo(),
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