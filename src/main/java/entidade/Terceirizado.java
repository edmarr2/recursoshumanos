/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistência.DB;
/**
 *
 * @author edmar
 */
public class Terceirizado extends Funcionario {
    private String empresaContratada;
    private String duracaoContrato;

    public Terceirizado(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero gênero, String empresaContratada, String duracaoContrato) {
        super(id, cpf, nome, cargo, salario, estadoCivil, gênero);
        this.empresaContratada = empresaContratada;
        this.duracaoContrato = duracaoContrato;
    }
    public Terceirizado() {
        DB.criaConexão();
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

    public void adicionarTerceirizado(Terceirizado terceirizado) {
        String sql = "INSERT INTO terceirizados (funcionarioId, empresaContratada, duracaoContrato) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, terceirizado.getId());
            statement.setString(2, terceirizado.getEmpresaContratada());
            statement.setString(3, terceirizado.getDuracaoContrato());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerTerceirizado(int funcionarioId) {
        String sql = "DELETE FROM terceirizados WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTerceirizado(Terceirizado terceirizado) {
        String sql = "UPDATE terceirizados SET empresaContratada = ?, duracaoContrato = ? WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, terceirizado.getEmpresaContratada());
            statement.setString(2, terceirizado.getDuracaoContrato());
            statement.setInt(3, terceirizado.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Terceirizado buscarTerceirizadoPorId(int funcionarioId) {
        String sql = "SELECT * FROM terceirizados WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String empresaContratada = resultSet.getString("empresaContratada");
                String duracaoContrato = resultSet.getString("duracaoContrato");

                return new Terceirizado(funcionarioId, getCPF(), getNome(), getCargo(), getSalário(), getEstadoCivil(), getGênero(), empresaContratada, duracaoContrato);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
