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
    public enum EstadoCivil {solteiro, casado, divorciado, viúvo};
    private String cpf;
    private String nome;
    private String cargo;
    private double salário;
    EstadoCivil estadoCivil;
    
    public Empregado(String cpf, String nome, String cargo, double salário, EstadoCivil estadoCivil ) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
        this.estadoCivil = estadoCivil;
    }
    
    public Empregado() {
        DB.criaConexão();
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
    
    public String getNomeECPF() {
        return this.getNome() + " - " + this.getCPF();
    }
    
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public void adicionarEmpregado(Empregado empregado) {
        String sql = "INSERT INTO empregados (cpf, nome, cargo, salario, estadoCivil) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getCPF());
            statement.setString(2, empregado.getNome());
            statement.setString(3, empregado.getCargo());
            statement.setDouble(4, empregado.getSalário());
            statement.setString(5, empregado.getEstadoCivil().toString());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarEmpregado(Empregado empregado) {
        String sql = "UPDATE empregados SET nome = ?, cargo = ?, salario = ?, estadoCivil = ? WHERE cpf = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getNome());
            statement.setString(2, empregado.getCargo());
            statement.setDouble(3, empregado.getSalário());
            statement.setString(4, empregado.getEstadoCivil().toString());
            statement.setString(5, empregado.getCPF());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removerEmpregado(String cpf) {
        String sql = "DELETE FROM empregados WHERE cpf = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, cpf);
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
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                String estadoCivilString = resultSet.getString("estadoCivil");
                EstadoCivil estadoCivil = this.stringToEstadoCivil(estadoCivilString);
                return new Empregado(cpf, nome, cargo, salário, estadoCivil);
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
    
    public List<Empregado> listarEmpregados() {
        List<Empregado> empregados = new ArrayList<>();
        String sql = "SELECT * FROM empregados";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                String estadoCivilString = resultSet.getString("estadoCivil");
                EstadoCivil estadoCivil = this.stringToEstadoCivil(estadoCivilString);

                Empregado empregado = new Empregado(cpf, nome, cargo, salário, estadoCivil);
                empregados.add(empregado);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empregados;
    }
    
      private EstadoCivil stringToEstadoCivil(String estadoCivilString) {
        try {
            return EstadoCivil.valueOf(estadoCivilString);
        } catch (IllegalArgumentException e) {
            // Trate o caso em que o banco de dados contém um valor inválido para o estado civil
            return EstadoCivil.solteiro; // ou qualquer valor padrão que você preferir
        }
    }
}