/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import persistência.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author edmar
 */
public class Empregado {
    private int id;
    private String cpf;
    private String nome;
    private String cargo;
    private double salário;
    private int empresa_id;
    // Construtor
    public Empregado(int id, String cpf, String nome, String cargo, double salário, int empresaId ) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
        this.empresa_id = empresaId;
    }
    
    public Empregado() {
        DB.criaConexão();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    
    public String getCPF() {
        return cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
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
    
    public int getEmpresaId() {
        return empresa_id;
    }

    public void setEmpresaId(int empresaId) {
        this.empresa_id = empresaId;
    }
    
    public void adicionarEmpregado(Empregado empregado) {
        String sql = "INSERT INTO empregados (cpf, nome, cargo, salario, empresa_id) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getCPF());
            statement.setString(2, empregado.getNome());
            statement.setString(3, empregado.getCargo());
            statement.setDouble(4, empregado.getSalário());
            statement.setInt(5, empregado.getEmpresaId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarEmpregado(Empregado empregado) {
        String sql = "UPDATE empregados SET cpf = ?, nome = ?, cargo = ?, salario = ?, empresa_id = ? WHERE id = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getCPF());
            statement.setString(2, empregado.getNome());
            statement.setString(3, empregado.getCargo());
            statement.setDouble(4, empregado.getSalário());
            statement.setInt(5, empregado.getEmpresaId());
            statement.setInt(6, empregado.getId());

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
    
    public Empregado buscarEmpregadoPorCPF(String cpf) {
        String sql = "SELECT * FROM empregados WHERE cpf = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                int empregadoId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                int empresaId = resultSet.getInt("empresa_id");

                return new Empregado(empregadoId, cpf, nome, cargo, salário, empresaId);
            }
            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    public boolean verificarCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM empregados WHERE cpf = ?";

        try (PreparedStatement statement = DB.conexão.prepareStatement(sql)) {
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public List<Empregado> listarEmpregadosPorEmpresa(int empresaId) {
        List<Empregado> empregados = new ArrayList<>();
        String sql = "SELECT * FROM empregados WHERE empresa_id = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, empresaId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int empregadoId = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");

                Empregado empregado = new Empregado(empregadoId, cpf, nome, cargo, salário, empresaId);
                empregados.add(empregado);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empregados;
    }
}