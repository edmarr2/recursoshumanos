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
public class Empresa {
    private String cnpj;
    private String nome;
    private String endereco;
    
    // Construtor
    public Empresa(String cnpj, String nome, String endereço) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereço;
    }
    
    public Empresa() {
        DB.criaConexão();
    }

    public String getCNPJ() {
        return cnpj;
    }
    
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getNomeECNPJ() {
        return this.getNome() + " - " + this.getCNPJ();
    }
    
    public void adicionarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresas (cnpj, nome, endereco) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empresa.getCNPJ());
            statement.setString(2, empresa.getNome());
            statement.setString(3, empresa.getEndereco());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarEmpresa(Empresa empresa) {
        String sql = "UPDATE empresas SET nome = ?, endereco = ? WHERE cnpj = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, empresa.getNome());
            statement.setString(2, empresa.getEndereco());
            statement.setString(3, empresa.getCNPJ());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removerEmpresa(String cnpj) {
        String sql = "DELETE FROM empresas WHERE cnpj = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Empresa buscarEmpresaPorCNPJ(String cnpj) {
        String sql = "SELECT * FROM empresas WHERE cnpj = ?";
        
        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                String cnpjEmpresa = resultSet.getString("cnpj");
                String nomeEmpresa = resultSet.getString("nome");
                String emderecoEmpresa = resultSet.getString("endereco");

                return new Empresa(cnpjEmpresa, nomeEmpresa, emderecoEmpresa);
            }
            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<Empresa> listarEmpresas() {
        List<Empresa> listaEmpresas = new ArrayList<>();

        String sql = "SELECT * FROM empresas";

        try {
            PreparedStatement statement = DB.conexão.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");

                Empresa empresa = new Empresa(cnpj, nome, endereco);
                listaEmpresas.add(empresa);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEmpresas;
    }
    
    public boolean verificarCnpjExistente(String cnpj) {
        String sql = "SELECT COUNT(*) FROM empresas WHERE cnpj = ?";

        try (PreparedStatement statement = DB.conexão.prepareStatement(sql)) {
            statement.setString(1, cnpj);
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
}
