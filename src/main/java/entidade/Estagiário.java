/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author edmar
 */
public class Estagiário extends Funcionário {
    private String curso;
    private int cargaHoraria;
    
    public Estagiário(int id, String cpf, String nome, String cargo, double salario, 
            EstadoCivil estadoCivil, char sexo, boolean ativo) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
    }
    
    public Estagiário(int id, String cpf, String nome, String cargo, double salario, 
            EstadoCivil estadoCivil, char sexo, boolean ativo, String curso, int cargaHoraria) {
        super(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo);
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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
