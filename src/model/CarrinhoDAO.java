package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {

	public void adicionarProdutoAoCarrinho(Carrinho carrinho) {
		String sql = "INSERT INTO carrinho (nomeProduto, valorProduto, quantidade, codProd, cpf) VALUES (?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, carrinho.getNomeProduto());
			pstm.setDouble(2, carrinho.getValorProduto());
			pstm.setInt(3, carrinho.getQuantidade());
			pstm.setInt(4, carrinho.getCodProd());
			pstm.setString(5, carrinho.getCpf());
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

	public List<Carrinho> mostrarCarrinho() {
		String sql = "SELECT * FROM carrinho";
		List<Carrinho> listaCarrinho = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Carrinho carrinho = new Carrinho();
				carrinho.setNomeProduto(rset.getString("nomeProduto"));
				carrinho.setValorProduto(rset.getDouble("valorProduto"));
				carrinho.setId(rset.getInt("id"));
				carrinho.setQuantidade(rset.getInt("quantidade"));
				carrinho.setCodProd(rset.getInt("codProd"));
				carrinho.setCpf(rset.getString("cpf"));

				listaCarrinho.add(carrinho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);

		}
		return listaCarrinho;
	}

	public void atualizarProdutoEmCarrinho(int q, int id) {
		String sql = "UPDATE carrinho SET quantidade = ? WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, q);
			pstm.setInt(2, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			BancoDeDados.desconectar(conexao);
		}
	}

	public Double valorTotalDoCarrinho(String cpf) {
		String sql = "SELECT SUM(valorProduto * quantidade) AS valorTotal FROM carrinho WHERE cpf = ?; ";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		double valorTotal = 0.0;
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();
			if (rset.next()) {
				valorTotal = rset.getDouble("valorTotal");

				if (rset.wasNull()) {
					valorTotal = 0.0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);

		}
		return valorTotal;
	}

	public void excluirProdutoDeCarrinho(int id) {
		String sql = "DELETE FROM carrinho WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}
	public void excluirTodosProdutosDeCarrinho(String cpf) {
		String sql = "DELETE FROM carrinho WHERE cpf = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cpf);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}
}
