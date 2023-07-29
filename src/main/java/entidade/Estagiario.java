/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistência.DB;

/**
 *
 * @author edmar
 */
public class Estagiario extends Funcionario {
    private String curso;
    private int cargaHoraria;

    public Estagiario(int id, String cpf, String nome, String cargo, double salario, EstadoCivil estadoCivil, Gênero gênero, String curso, int cargaHoraria) {
        super(id, cpf, nome, cargo, salario, estadoCivil, gênero);
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
    }
    public Estagiario() {
        DB.criaConexão();
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

    public void adicionarEstagiario(Estagiario estagiario) {
        String sql = "INSERT INTO estagiarios (funcionarioId, curso, cargaHoraria) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, estagiario.getId());
            statement.setString(2, estagiario.getCurso());
            statement.setInt(3, estagiario.getCargaHoraria());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerEstagiario(int funcionarioId) {
        String sql = "DELETE FROM estagiarios WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEstagiario(Estagiario estagiario) {
        String sql = "UPDATE estagiarios SET curso = ?, cargaHoraria = ? WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, estagiario.getCurso());
            statement.setInt(2, estagiario.getCargaHoraria());
            statement.setInt(3, estagiario.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Estagiario buscarEstagiarioPorId(int funcionarioId) {
        String sql = "SELECT * FROM estagiarios WHERE funcionarioId = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionarioId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String curso = resultSet.getString("curso");
                int cargaHoraria = resultSet.getInt("cargaHoraria");

                return new Estagiario(funcionarioId, getCPF(), getNome(), getCargo(), getSalário(), getEstadoCivil(), getGênero(), curso, cargaHoraria);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
