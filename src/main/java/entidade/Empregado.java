/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistência.DB;

/**
 *
 * @author edmar
 */
public class Empregado extends Funcionario{
    private String departamento;
    private int avaliaçãoDeDesempenho;

    public Empregado(String cpf, String nome, String cargo, double salário, EstadoCivil estadoCivil, Gênero gênero, String departamento, int avaliaçãoDeDesempenho) {
        super(cpf, nome, cargo, salário, estadoCivil, gênero);
        this.departamento = departamento;
        this.avaliaçãoDeDesempenho = avaliaçãoDeDesempenho;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public int getAvaliaçãoDeDesempenho() {
        return avaliaçãoDeDesempenho;
    }
    
    public void setAvaliaçãoDeDesempenho(int avaliaçãoDeDesempenho){
        this.avaliaçãoDeDesempenho = avaliaçãoDeDesempenho;
    }
    
    public void adicionarEmpregado(Empregado empregado) {
        String sql = "INSERT INTO empregados (cpf, departamento, avaliacaoDeDesempenho) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getCPF());
            statement.setString(2, empregado.getDepartamento());
            statement.setInt(3, empregado.getAvaliaçãoDeDesempenho());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}