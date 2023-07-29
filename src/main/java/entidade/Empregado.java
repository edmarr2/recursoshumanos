/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistência.DB;
import java.sql.ResultSet;

/**
 *
 * @author edmar
 */
public class Empregado extends Funcionário{
     private String departamento;
    private int avaliacaoDeDesempenho;

    public Empregado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero gênero, String departamento, int avaliacaoDeDesempenho) {
        super(id, cpf, nome, cargo, salario, estadoCivil, gênero);
        this.departamento = departamento;
        this.avaliacaoDeDesempenho = avaliacaoDeDesempenho;
    }
    public Empregado() {
        DB.criaConexão();
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

    public void adicionarEmpregado(Empregado empregado) {
        String sql = "INSERT INTO empregados (funcionarioId, departamento, avaliacaoDeDesempenho) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, empregado.getId());
            statement.setString(2, empregado.getDepartamento());
            statement.setInt(3, empregado.getAvaliacaoDeDesempenho());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public void removerEmpregado(int funcionarioId) {
        String sql = "DELETE FROM empregados WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEmpregado(Empregado empregado) {
        String sql = "UPDATE empregados SET departamento = ?, avaliacaoDeDesempenho = ? WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empregado.getDepartamento());
            statement.setInt(2, empregado.getAvaliacaoDeDesempenho());
            statement.setInt(3, empregado.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Empregado buscarEmpregadoPorId(int funcionarioId) {
        String sql = "SELECT * FROM empregados WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String departamento = resultSet.getString("departamento");
                int avaliacaoDeDesempenho = resultSet.getInt("avaliacaoDeDesempenho");

                return new Empregado(funcionarioId, getCPF(), getNome(), getCargo(), getSalário(), getEstadoCivil(), getGênero(), departamento, avaliacaoDeDesempenho);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}