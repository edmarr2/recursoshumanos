/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import entidade.Funcionário.EstadoCivil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import persistência.DB;

/**
 *
 * @author edmar
 */
public class Emprego {
    private int id;
    private Timestamp dataInicio, dataFim;
    private final Funcionário funcionario;
    private final Empresa empresa;
    
    public Emprego(int id, Funcionário funcionario, Empresa empresa, Timestamp dataInicio, Timestamp dataFim) {
        this.id = id;
        this.funcionario = funcionario;
        this.empresa = empresa;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public Emprego(int id, Funcionário funcionario, Empresa empresa) {
        this.id = id;
        this.funcionario = funcionario;
        this.empresa = empresa;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Funcionário getFuncionario() {
        return funcionario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }
    
    public Emprego getVisao() {
        return new Emprego(this.id, this.funcionario, this.empresa);
    }
    
    public static ArrayList<Emprego> pesquisarEmpregos(EstadoCivil estadoCivil, double salarioMinimo, String cargoDesejado, Timestamp dataMinima) {
        String sql = "SELECT F.id, F.cpf, F.cargo, F.salario, EM.dataInicio, F.nome, "
                + "E.cnpj, E.nome "
                + "FROM funcionarios F, empresas E, emprego EM"
                + "WHERE EM.funcionarioId = F.id AND EM.empresaId = E.cnpj ";

        if (estadoCivil != null || salarioMinimo > -1 || cargoDesejado != null || dataMinima != null) {
            sql += "WHERE ";

            boolean hasPreviousCondition = false;
            if (estadoCivil != null) {
                if (hasPreviousCondition) {
                    sql += "AND ";
                }
                sql += "F.estadoCivil = ? ";
                hasPreviousCondition = true;
            }

            if (salarioMinimo > -1) {
                if (hasPreviousCondition) {
                    sql += "AND ";
                }
                sql += "F.salario >= ? ";
                hasPreviousCondition = true;
            }

            if (cargoDesejado != null) {
                if (hasPreviousCondition) {
                    sql += "AND ";
                }
                sql += "F.cargo = ? ";
                hasPreviousCondition = true;
            }

            if (dataMinima != null) {
                if (hasPreviousCondition) {
                    sql += "AND ";
                }
                sql += "EM.dataInicio >= ? ";
            }
        }

        sql += "ORDER BY F.id";

        ResultSet resultados = null;
        ArrayList<Emprego> empregosSelecionados = new ArrayList<>();
        int index = 0;

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);

            if (estadoCivil != null) {
                comando.setInt(++index, estadoCivil.ordinal());
            }

            if (salarioMinimo > -1) {
                comando.setDouble(++index, salarioMinimo);
            }

            if (cargoDesejado != null) {
                comando.setString(++index, cargoDesejado);
            }

            if (dataMinima != null) {
                comando.setTimestamp(++index, dataMinima);
            }

            resultados = comando.executeQuery();

            while (resultados.next()) {
                Emprego emprego_pesquisado = Emprego.buscarEmprego(resultados.getInt("id"));
                empregosSelecionados.add(emprego_pesquisado);
            }

            resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empregosSelecionados;
    }
    
    public static int ultimoId() {
        String sql = "SELECT MAX(id) FROM emprego";
        ResultSet resultados = null;
        int id = 0;
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            resultados = comando.executeQuery();
            while (resultados.next()) {
                id = resultados.getInt(1);
            }
            resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static Emprego buscarEmprego(int id) {
        String sql = "SELECT * FROM emprego WHERE id = ?";
        ResultSet resultados = null;
        Emprego emprego = null;

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();

            while (resultados.next()) {
                int funcionarioId = resultados.getInt("funcionarioId");
                String empresaId = resultados.getString("empresaId");
                Timestamp dataInicioTimestamp = resultados.getTimestamp("dataInicio");
                Timestamp dataFimTimestamp = resultados.getTimestamp("dataFim");
                Funcionário funcionario = Funcionário.buscarFuncionario(funcionarioId);
                Empresa empresa = Empresa.buscarEmpresa(empresaId);

                emprego = new Emprego(id, funcionario, empresa, dataInicioTimestamp, dataFimTimestamp);
            }

            resultados.close();
            comando.close();
        } catch (SQLException e) { 
            e.printStackTrace(); 
            emprego = null;
        }

        return emprego;
    }
    public static String inserirEmprego(Emprego emprego) {
        String sql = "INSERT INTO Emprego (funcionarioId, empresaId, dataInicio, dataFim) "
                + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, emprego.getFuncionario().getId());
            comando.setString(2, emprego.getEmpresa().getCNPJ());
            java.sql.Date dataInicio = new java.sql.Date(emprego.getDataInicio().getTime());
            java.sql.Date dataFim = new java.sql.Date(emprego.getDataFim().getTime());
            comando.setDate(3, dataInicio);
            comando.setDate(4, dataFim);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Erro na Inserção do Emprego no BD";
    }
    public static String alterarEmprego(Emprego emprego) {
        String sql = "UPDATE emprego SET funcionarioId = ?, empresaId = ?, "
                + "dataInicio = ?, dataFim = ? WHERE id = ?";

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, emprego.getFuncionario().getId());
            comando.setString(2, emprego.getEmpresa().getCNPJ());
            java.sql.Date dataInicio = new java.sql.Date(emprego.getDataInicio().getTime());
            java.sql.Date dataFim = new java.sql.Date(emprego.getDataFim().getTime());
            comando.setDate(3, dataInicio);
            comando.setDate(4, dataFim);
            comando.setInt(5, emprego.getId());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Erro na Alteração do Emprego no BD";
    }
    public static String removerEmprego(int id) {
        String sql = "DELETE FROM emprego WHERE id = ?";

        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro na Remoção do Emprego no BD";
        }
    }
    public static Emprego[] getVisoes() {
        String sql = "SELECT id, funcionarioId, empresaId, dataInicio, dataFim FROM emprego";
        ResultSet resultados = null;
        ArrayList<Emprego> visoes = new ArrayList<>();
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            resultados = comando.executeQuery();
            while (resultados.next()) {
                int id = resultados.getInt("id");
                int funcionarioId = resultados.getInt("funcionarioId");
                String empresaId = resultados.getString("empresaId");
                Timestamp dataInicio = new Timestamp(resultados.getDate("dataInicio").getTime());
                Timestamp dataFim = new Timestamp(resultados.getDate("dataFim").getTime());

                Funcionário funcionario = Funcionário.buscarFuncionario(funcionarioId);
                Empresa empresa = Empresa.buscarEmpresa(empresaId);

                Emprego emprego = new Emprego(id, funcionario, empresa, dataInicio, dataFim);
                visoes.add(emprego);
            }
            resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visoes.toArray(new Emprego[visoes.size()]);
    }
    public static boolean existeEmprego(int id) {
        String sql = "SELECT COUNT(id) FROM emprego WHERE id = ?";
        ResultSet resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, id);
            resultados = comando.executeQuery();
            while (resultados.next()) {
                existe = true;
            }
            resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public static boolean existeEmprego(int chave_funcionario, String chave_empresa) {
        String sql = "SELECT id FROM emprego WHERE funcionarioId = ? AND empresaId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = DB.conexão.prepareStatement(sql);
            comando.setInt(1, chave_funcionario);
            comando.setString(2, chave_empresa);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }
    public static String formatarData(Timestamp dataHora) {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return data.format(dataHora);
    }
    @Override
    public String toString() {
        return "Emprego{" +
                "id=" + id +
                ", funcionario=" + funcionario +
                ", empresa=" + empresa +
                ", data admissão=" + formatarData(dataInicio) +
                ", data demissão=" + formatarData(dataFim) +
                '}';
    }
    
}
