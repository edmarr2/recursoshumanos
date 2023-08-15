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
    
    public String toStringFull() {
        return this.nome + "[" + this.cnpj + "] - endereco: " + this.endereco;
    }
    
    public static String inserirEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresas (cnpj, nome, endereco) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setString(1, empresa.getCNPJ());
            comando.setString(2, empresa.getNome());
            comando.setString(3, empresa.getEndereco());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro na inserção de Empresa";
        }
    }
    
    public static String alterarEmpresa(Empresa empresa) {
        String sql = "UPDATE empresas SET nome = ?, endereco = ? WHERE cnpj = ?";
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getEndereco());
            comando.setString(3, empresa.getCNPJ());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro na Alteração de Empresa";
        }
    }
    
    public static String removerEmpresa(String cnpj) {
        String sql = "DELETE FROM empresas WHERE cnpj = ?";
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setString(1, cnpj);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro na Remoção da Empresa";
        }
    }
    
    public static Empresa buscarEmpresa(String cnpj) {
        String sql = "SELECT * FROM empresas WHERE cnpj = ?";
        ResultSet resultados = null;
        Empresa empresa = null;
        
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setString(1, cnpj);
            resultados = comando.executeQuery();
            
            if(resultados.next()){
                String cnpjEmpresa = resultados.getString("cnpj");
                String nomeEmpresa = resultados.getString("nome");
                String enderecoEmpresa = resultados.getString("endereco");

                empresa =  new Empresa(cnpjEmpresa, nomeEmpresa, enderecoEmpresa);
            }
            comando.close();
        }catch(SQLException e) {
            e.printStackTrace();
            empresa = null;
        }
        
        return empresa;
    }
    
    public static Empresa[] getVisoes() {
        ArrayList<Empresa> visoes = new ArrayList<>();
        ResultSet resultados = null;
        String sql = "SELECT * FROM empresas";

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            resultados = comando.executeQuery();

            while (resultados.next()) {
                String cnpj = resultados.getString("cnpj");
                String nome = resultados.getString("nome");
                String endereco = resultados.getString("endereco");
                visoes.add(new Empresa(cnpj, nome, endereco));
            }

            resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visoes.toArray(new Empresa[visoes.size()]);
    }
    
    public Empresa getVisao() {
        return new Empresa(this.cnpj, this.nome, this.endereco);
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
