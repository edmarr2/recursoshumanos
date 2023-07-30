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
public class Funcionário {
    public enum EstadoCivil {
        SOLTEIRO(0), CASADO(1), DIVORCIADO(2), VIUVO(3);

        private int mnemonic;

        private EstadoCivil(int mnemonic) {
            this.mnemonic = mnemonic;
        }

        public int getMnemonic() {
            return this.mnemonic;
        }
    }
    
    public enum Gênero {
        MASCULINO("Masculino", 'M'),
        FEMININO("Feminino", 'F');

        private final String texto;
        private final char mnemonic;

        Gênero(String texto, char mnemonic) {
            this.texto = texto;
            this.mnemonic = mnemonic;
        }

        public String getTexto() {
            return texto;
        }

        public char getMnemonic() {
            return mnemonic;
        }
    }
    private int id;
    private String cpf;
    private String nome;
    private String cargo;
    private double salário;
    EstadoCivil estadoCivil;
    Gênero gênero;
    private boolean ativo;

    public Funcionário(int id, String cpf, String nome, String cargo, double salário, EstadoCivil estadoCivil, Gênero gênero, boolean ativo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
        this.estadoCivil = estadoCivil;
        this.gênero = gênero;
        this.ativo = ativo;
    }
    public Funcionário() {
        DB.criaConexão();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "[" + this.getId() +  "] " + this.getNome() + " - " + this.getCPF();
    }
    
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public Gênero getGênero() {
        return gênero;
    }

    public void setGenero(Gênero gênero) {
        this.gênero = gênero;
    }
    
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public void adicionarFuncionário(Funcionário funcionario) {
        String sql = "INSERT INTO funcionarios (id, cpf, nome, cargo, salario, estadoCivil, genero, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionario.getId());
            statement.setString(2, funcionario.getCPF());
            statement.setString(3, funcionario.getNome());
            statement.setString(4, funcionario.getCargo());
            statement.setDouble(5, funcionario.getSalário());
            statement.setString(6, funcionario.getEstadoCivil().toString());
            statement.setString(7, funcionario.getGênero().toString());
            statement.setBoolean(8, funcionario.getAtivo());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarFuncionário(Funcionário funcionario) {
        String sql = "UPDATE funcionarios SET cpf = ?, nome = ?, cargo = ?, salario = ?, estadoCivil = ?, genero = ?, ativo = ? WHERE id = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, funcionario.getCPF());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCargo());
            statement.setDouble(4, funcionario.getSalário());
            statement.setString(5, funcionario.getEstadoCivil().toString());
            statement.setString(6, funcionario.getGênero().toString());
            statement.setBoolean(7, funcionario.getAtivo());
            statement.setInt(8, funcionario.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removerFuncionário(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Funcionário buscarFuncionárioPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                EstadoCivil estadoCivil = EstadoCivil.valueOf(resultSet.getString("estadoCivil"));
                Gênero gênero = Gênero.valueOf(resultSet.getString("genero"));
                boolean ativo = resultSet.getBoolean("ativo");
                return new Funcionário(id, cpf, nome, cargo, salário, estadoCivil, gênero, ativo);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public Funcionário buscarFuncionárioPorCpf(String cpf) {
        String sql = "SELECT * FROM funcionarios WHERE cpf = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salário = resultSet.getDouble("salario");
                EstadoCivil estadoCivil = EstadoCivil.valueOf(resultSet.getString("estadoCivil"));
                Gênero gênero = Gênero.valueOf(resultSet.getString("genero"));
                boolean ativo = resultSet.getBoolean("ativo");
                return new Funcionário(id, cpf, nome, cargo, salário, estadoCivil, gênero, ativo);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean verificarCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM funcionarios WHERE cpf = ?";

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
    
    public List<Funcionário> listarFuncionários() {
        List<Funcionário> funcionarios = new ArrayList<>();
        String sql = "SELECT id, cpf, nome, cargo, salario, estadoCivil, genero, ativo FROM funcionarios";

        try (PreparedStatement statement = DB.conexão.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                double salario = resultSet.getDouble("salario");
                EstadoCivil estadoCivil = EstadoCivil.valueOf(resultSet.getString("estadoCivil"));
                Gênero gênero = Gênero.valueOf(resultSet.getString("genero"));
                boolean ativo = resultSet.getBoolean("ativo");
                Funcionário funcionario = new Funcionário(id, cpf, nome, cargo, salario, estadoCivil, gênero, ativo);
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }
}
