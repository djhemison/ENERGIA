package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Cliente;

public class ClienteDAO {

    public void adicionar(Cliente cliente) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into cliente (nome, sexo, endereco, cep, bairro, cpf, nascimento, vencimento, unidade, email, kwh, valortotal, site) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSexo());
        ps.setString(3, cliente.getEndereco());
        ps.setInt(4, cliente.getCep());
        ps.setString(5, cliente.getBairro());
        ps.setInt(6, cliente.getCpf());
        ps.setString(7, cliente.getNascimento());
        ps.setString(8, cliente.getVencimento());
        ps.setString(9, cliente.getUnidade());
        ps.setString(10, cliente.getEmail());
        ps.setInt(11, cliente.getKwh());
        ps.setInt(12, cliente.getValortotal());
        ps.setString(13, cliente.getSite());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public void remover(int codigo) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "delete from cliente where id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public void alterar(Cliente cliente) throws SQLException {
//        Connection conexao = new Conexao().getConexao();
//        String sql = "UPDATE cliente set descricao=?,cep=?,bairro=?,numero=?"
//                + "where codigo=?";
//        PreparedStatement ps = conexao.prepareStatement(sql);
//        ps.setString(1, pessoa.getDescricao());
//        ps.setString(2, pessoa.getCep());
//        ps.setString(3, pessoa.getBairro());
//        ps.setInt(4, pessoa.getNumero());

    }

    public List<Cliente> pesquisarClientes(String termo, String pesquisa) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select * from cliente where ? like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, termo);
        ps.setString(2, "%" + pesquisa + "%");
        ResultSet result = ps.executeQuery();
        Cliente cliente = null;
        while (result.next()) {
            cliente = new Cliente(result.getString("nome"),
                    result.getString("sexo"),
                    result.getString("endereco"),
                    result.getInt("cep"),
                    result.getString("bairro"),
                    result.getInt("cpf"),
                    result.getString("nascimento"),
                    result.getString("vencimento"),
                    result.getString("unidade"),
                    result.getString("email"),
                    result.getInt("kwh"),
                    result.getInt("valortotal"),
                    result.getString("site"));
            cliente.setId(result.getInt("id"));
            clientes.add(cliente);
        }
        result.close();
        ps.close();
        return clientes;
    }
}
