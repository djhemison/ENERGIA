/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.Conexao;
import modelo.Usuario;

/**
 *
 * @author Djhemison
 */
public class UsuarioDAO {
    public Usuario login(String login,String senha) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from usuario where login=? and senha=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        Usuario usuario = null;
        while(rs.next()){
            usuario = new Usuario();
            usuario.setCodigo(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setNivel(rs.getString("nivel"));
        }
        rs.close();
        ps.close();
        return usuario;
    }
    public ArrayList<Usuario> listarUsuarios() throws SQLException {

        Connection conexao = new Conexao().getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario order by id";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        Usuario usuario = null;
        while (result.next()) {
            usuario = new Usuario();
            usuario.setCodigo(result.getInt("id"));
            usuario.setNome(result.getString("nome"));
            usuario.setNivel(result.getString("nivel"));
            usuarios.add(usuario);
        }
        result.close();
        ps.close();
        return usuarios;
    }
}
