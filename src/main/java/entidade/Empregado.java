/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import persistência.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author edmar
 */
public class Empregado {
    private int id;
    private String nome;
    private String cargo;
    private double salário;

    // Construtor
    public Empregado(int id, String nome, String cargo, double salário) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
    }
    
    public Empregado() {
        DB.criaConexão();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalário() {
        return salário;
    }

    public void setSalario(double salário) {
        this.salário = salário;
    }
    
    public void adicionarEmpregado(Empregado empregado) {
        String sql = "INSERT INTO empregados (nome, cargo, salario) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getNome());
            statement.setString(2, empregado.getCargo());
            statement.setDouble(3, empregado.getSalário());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarEmpregado(Empregado empregado) {
        String sql = "UPDATE empregados SET nome = ?, cargo = ?, salario = ? WHERE id = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getNome());
            statement.setString(2, empregado.getCargo());
            statement.setDouble(3, empregado.getSalário());
            statement.setInt(4, empregado.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removerEmpregado(int id) {
        String sql = "DELETE FROM empregados WHERE id = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Empregado buscarEmpregadoPorNome(String nome) {
        String sql = "SELECT * FROM empregados WHERE nome = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                int empregadoId = resultSet.getInt("id");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                
                return new Empregado(empregadoId, nome, cargo, salário);
            }
            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}