/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.DB;

/**
 *
 * @author edmar
 */
public class Funcionário {
    public enum EstadoCivil { solteiro, casado, divorciado, viuvo };
    private char sexo;

    private int id;
    private String cpf;
    private String nome;
    private String cargo;
    private double salário;
    EstadoCivil estadoCivil;
    private boolean ativo;

    public Funcionário(int id, String cpf, String nome, String cargo,
            double salário, EstadoCivil estadoCivil, char sexo, boolean ativo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.salário = salário;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.ativo = ativo;
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
    
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String toStringFull() {
        return "[" + this.id + "] - " + this.nome + "[" + this.cpf + "]" + " - " + "salario: " + this.salário +
                estadoCivil + " - " + sexo + " - " + this.ativo;
    }
    
    @Override
    public String toString() {
        return "[" + this.id + "] " + this.nome + " - CPF: " + this.cpf + "";
    }

    public static int ultimoID() {
        String sql = "SELECT MAX(id) FROM funcionarios";
        ResultSet resultados = null;
        int id = 0;
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                id = resultados.getInt(1);
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) { e.printStackTrace(); }
        
        return id;
    }
    private static boolean existeFuncionarioIdJaCadastrado(int id, String tabela) {
        String sql = "SELECT COUNT(funcionarioId) FROM " + tabela + " WHERE funcionarioId = ?";
        ResultSet resultados;
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                if(resultados.getInt(1) != 0) {
                    return true;
                }
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) { e.printStackTrace(); }
        
        return false;
    }
    public static String inserirFuncionario(Funcionário funcionario) {
        String sql = "INSERT INTO funcionarios (id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo)" +
                " VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getCPF());
            comando.setString(3, funcionario.getNome());
            comando.setString(4, funcionario.getCargo());
            comando.setDouble(5, funcionario.getSalário());
            comando.setInt(6, funcionario.getEstadoCivil().ordinal());
            comando.setString(7, funcionario.getSexo() + "");
            comando.setBoolean(8, funcionario.getAtivo());
            comando.executeUpdate();
            comando.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            return "Erro na inserção do Funcionario";
        }
        
        int id = Funcionário.ultimoID();
        if(funcionario instanceof Empregado) {
            Empregado empregado = (Empregado) funcionario;
            sql = "INSERT INTO empregados (departamento, avaliacaoDeDesempenho, funcionarioId) VALUES " +
                    "(?,?,?)";
            try{
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, empregado.getDepartamento());
                comando.setInt(2, empregado.getAvaliacaoDeDesempenho());
                comando.setInt(3, id);
                comando.executeUpdate();
                comando.close();
            }
            catch (SQLException e){
                e.printStackTrace();
                return "Erro na inserção do Empregado";
            }
        } else if(funcionario instanceof Estagiário) {
            Estagiário estagiario = (Estagiário) funcionario;
            sql = "INSERT INTO estagiarios (curso, cargaHoraria, funcionarioId) " +
                    "VALUES (?,?,?)";
            try{
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, estagiario.getCurso());
                comando.setInt(2, estagiario.getCargaHoraria());
                comando.setInt(3, id);
                comando.executeUpdate();
                comando.close();
            }
            catch (SQLException e){
                e.printStackTrace();
                return "Erro na inserção de Estagiário";
            }
        } else {
            Terceirizado terceirizado = (Terceirizado) funcionario;
            sql = "INSERT INTO terceirizados (empresaContratada, duracaoContrato, funcionarioId) " +
                    "VALUES (?,?,?)";
            try{
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, terceirizado.getEmpresaContratada());
                comando.setString(2, terceirizado.getDuracaoContrato());
                comando.setInt(3, id);
                comando.executeUpdate();
                comando.close();
            }
            catch (SQLException e){
                e.printStackTrace();
                return "Erro na inserção do Terceirizado";
            }
        }
        
        return null;
    }
    public static String alterarFuncionario(Funcionário funcionario) {
        String sql = "UPDATE funcionarios SET cpf = ?, nome = ?, cargo = ?, salario = ?, estadoCivil = ?,"
                + "sexo = ?, ativo = ? WHERE id = ?";
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setString(1, funcionario.getCPF());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getCargo());
            comando.setDouble(4, funcionario.getSalário());
            comando.setInt(5, funcionario.getEstadoCivil().ordinal());
            comando.setString(6, funcionario.getSexo() + "");
            comando.setBoolean(7, funcionario.getAtivo());
            comando.setInt(8, funcionario.getId());

            comando.executeUpdate();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
            return "Erro na alteração do Funcionario";
        }
        
        if(funcionario instanceof Empregado) {
            Empregado empregado = (Empregado) funcionario;
            sql = "UPDATE empregados SET departamento = ?, avaliacaoDeDesempenho = ? WHERE " +
                    "funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, empregado.getDepartamento());
                comando.setInt(2, empregado.getAvaliacaoDeDesempenho());
                comando.setInt(3, funcionario.getId());
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na alteração do Empregado";
            }
        }
        
        else if(funcionario instanceof Estagiário) {
            Estagiário estagiario = (Estagiário) funcionario;
            sql = "UPDATE estagiarios SET curso = ?, cargaHoraria = ? WHERE " +
                    "funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, estagiario.getCurso());
                comando.setInt(2, estagiario.getCargaHoraria());
                comando.setInt(3, funcionario.getId());
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na alteração de Estagiario";
            }
        }
        
        else if(funcionario instanceof Terceirizado) {
            Terceirizado terceirizado = (Terceirizado) funcionario;
            sql = "UPDATE terceirizados SET empresaContratada = ?, duracaoContrato = ? WHERE " +
                    "funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setString(1, terceirizado.getEmpresaContratada());
                comando.setString(2, terceirizado.getDuracaoContrato());
                comando.setInt(3, funcionario.getId());
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na alteração do estagiário";
            }
        }
        
        return null;
    }
    public static String removerFuncionario(Funcionário funcionario) {
        int id = funcionario.getId();
        
        if(funcionario instanceof Empregado) {
            String sql = "DELETE FROM empregados WHERE funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setInt(1, id);
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na remoção do empregado";
            }
        }
        
        else if(funcionario instanceof Estagiário) {
            String sql = "DELETE FROM estagiarios WHERE funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setInt(1, id);
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na remoção de estagiário";
            }
        }
        
        else if(funcionario instanceof Terceirizado) {
            String sql = "DELETE FROM terceirizados WHERE funcionarioId = ?";
            try {
                PreparedStatement comando = DB.conexão.prepareStatement(sql);
                comando.setInt(1, id);
                comando.executeUpdate();
                comando.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
                return "Erro na remoção do terceirizado";
            }
        }
        
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, funcionario.getId());
            comando.executeUpdate();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
            return "Erro na remoção do funcionário";
        }
        
        return null;
    }    
    public static Funcionário[] getVisoes() {
        String sql = "SELECT id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo FROM funcionarios";
        ResultSet resultados = null;
        ArrayList<Funcionário> visoes = new ArrayList<>();
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                int id = resultados.getInt("id");
                String cpf = resultados.getString("cpf");
                String nome = resultados.getString("nome");
                String cargo = resultados.getString("cargo");
                double salario = resultados.getDouble("salario");
                int estadoCivilOrdinal = resultados.getInt("estadoCivil");
                EstadoCivil estadoCivil = Funcionário.EstadoCivil.values()[estadoCivilOrdinal];
                char sexo = resultados.getString("sexo").charAt(0);
                boolean ativo = resultados.getBoolean("ativo");
                
                if(existeFuncionarioIdJaCadastrado(id, "empregados")) {
                    visoes.add(new Empregado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo));
                }
                else if(existeFuncionarioIdJaCadastrado(id, "estagiarios")) {
                    visoes.add(new Estagiário(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo));
                }
                else {
                    visoes.add(new Terceirizado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo));
                }
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        return visoes.toArray(new Funcionário[visoes.size()]);
    }
    public static boolean verificarCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM funcionarios WHERE cpf = ?";
        ResultSet result = null;
        try (PreparedStatement comando = DB.conexão.prepareStatement(sql)) {
            comando.setString(1, cpf);
            result = comando.executeQuery();

            if (result.next()) {
                int count = result.getInt(1);
                return count > 0;
            }

            result.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Funcionário getVisao() {
        return new Funcionário(this.id, this.cpf, this.nome, this.cargo,
                this.salário, this.estadoCivil, this.sexo, this.ativo);
    }
    public static Funcionário buscarFuncionario(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        ResultSet resultados = null;
        String cpf = null;
        String nome = null;
        String cargo = null;
        double salario = 0.0;
        EstadoCivil estadoCivil = Funcionário.EstadoCivil.values()[0];
        char sexo = 'M';
        boolean ativo = false;
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                cpf = resultados.getString("cpf");
                nome = resultados.getString("nome");
                cargo = resultados.getString("cargo");
                salario = resultados.getDouble("salario");
                int estadoCivilOrdinal = resultados.getInt("estadoCivil");
                estadoCivil = Funcionário.EstadoCivil.values()[estadoCivilOrdinal];
                sexo = resultados.getString("sexo").charAt(0);
                ativo = resultados.getBoolean("ativo");
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT departamento, avaliacaoDeDesempenho FROM empregados WHERE funcionarioId = ?";
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                return new Empregado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo,
                resultados.getString("departamento"), resultados.getInt("avaliacaoDeDesempenho"));
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        sql = "SELECT curso, cargaHoraria FROM estagiarios WHERE funcionarioId = ?";
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                return new Estagiário(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo, 
                resultados.getString("curso"), resultados.getInt("cargaHoraria"));
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        sql = "SELECT empresaContratada, duracaoContrato FROM terceirizados WHERE funcionarioId = ?";
        try{
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while(resultados.next()) {
                return new Terceirizado(id, cpf, nome, cargo, salario, estadoCivil, sexo, ativo, 
                resultados.getString("empresaContratada"), resultados.getString("duracaoContrato"));
            }
            resultados.close();
            comando.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
