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
        SOLTEIRO(0, "Solteiro"),
        CASADO(1, "Casado"),
        DIVORCIADO(2, "Divorciado"),
        VIUVO(3, "Viúvo");
        
        private final int mnemonic;
        private final String label;

        EstadoCivil(int mnemonic, String label) {
            this.mnemonic = mnemonic;
            this.label = label;
        }

        public int getMnemonic() {
            return mnemonic;
        }

        public String getLabel() {
            return label;
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

    public Funcionário(int id, String cpf, String nome, String cargo, double salário, EstadoCivil estadoCivil, Gênero gênero) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
        this.estadoCivil = estadoCivil;
        this.gênero = gênero;
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
        return this.getNome() + " - " + this.getCPF();
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

    public void adicionarFuncionario(Funcionário funcionario) {
        String sql = "INSERT INTO funcionarios (id, cpf, nome, cargo, salario, estadoCivil, genero) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setInt(1, funcionario.getId());
            statement.setString(2, funcionario.getCPF());
            statement.setString(3, funcionario.getNome());
            statement.setString(4, funcionario.getCargo());
            statement.setDouble(5, funcionario.getSalário());
            statement.setString(6, funcionario.getEstadoCivil().toString());
            statement.setString(7, funcionario.getGênero().toString());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarFuncionario(Funcionário funcionario) {
        String sql = "UPDATE funcionarios SET cpf = ?, nome = ?, cargo = ?, salario = ?, estadoCivil = ?, genero = ? WHERE id = ?";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, funcionario.getCPF());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCargo());
            statement.setDouble(4, funcionario.getSalário());
            statement.setString(5, funcionario.getEstadoCivil().toString());
            statement.setString(6, funcionario.getGênero().toString());
            statement.setInt(7, funcionario.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removerFuncionario(int id) {
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
    
    public Funcionário buscarFuncionarioPorId(int id) {
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
                return new Funcionário(id, cpf, nome, cargo, salário, estadoCivil, gênero);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean verificarCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM Funcionarios WHERE cpf = ?";

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
    
    public List<Funcionário> listarFuncionarios() {
        List<Funcionário> funcionarios = new ArrayList<>();
        String sql = "SELECT id, cpf, nome, cargo, salario, estadoCivil, genero FROM funcionarios";

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

                Funcionário funcionario = new Funcionário(id, cpf, nome, cargo, salario, estadoCivil, gênero);
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }
}
