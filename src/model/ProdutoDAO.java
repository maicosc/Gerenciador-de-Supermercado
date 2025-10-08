package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (preco, nomeProd, quantidade, codProd) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(2, produto.getNomeProd());
            pstm.setDouble(1, produto.getPreco());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setInt(4, produto.getCodProd());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

  
    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setNomeProd(rset.getString("nomeProd"));
                produto.setPreco(rset.getDouble("preco"));
                produto.setQuantidade(rset.getInt("quantidade"));
                produto.setCodProd(rset.getInt("codProd"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            
        }
        return produtos;
    }
    public Produto getProduto(int codProd) {
        String sql = "SELECT * FROM produtos WHERE codProd= ?";
        Produto produto = new Produto();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codProd);
            rset = pstm.executeQuery();
            while(rset.next()) {
            	produto.setNomeProd(rset.getString("nomeProd"));
                produto.setPreco(rset.getDouble("preco"));
                produto.setQuantidade(rset.getInt("quantidade"));
                produto.setCodProd(rset.getInt("codProd"));
            }
            
               
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            
        }
        return produto;
    }
    
    public void atualizarQuantidadeProd(int codProd, int quantRetirada) {
    	
    	String sql = "UPDATE produtos SET quantidade = ? WHERE codProd = ?";
    	Connection conexao = null;
    	PreparedStatement pstm = null;
    	try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, quantRetirada);
            pstm.setInt(2, codProd);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	
        	BancoDeDados.desconectar(conexao);
        }
    }

    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produtos SET nomeProd = ?, preco = ?, quantidade = ? WHERE codProd = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNomeProd());
            pstm.setDouble(2, produto.getPreco());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setInt(4, produto.getCodProd());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	
        	BancoDeDados.desconectar(conexao);
        }
    }

    
    public void excluirProduto(int codProd) {
        String sql = "DELETE FROM produtos WHERE codProd = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codProd);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}
