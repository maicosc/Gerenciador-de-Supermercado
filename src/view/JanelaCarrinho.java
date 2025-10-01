package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Carrinho;
import model.Produto;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JanelaCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JList<Carrinho> listProdutos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JanelaCarrinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		listProdutos = new JList();
		listProdutos.setBounds(36, 27, 427, 243);
		contentPane.add(listProdutos);

		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizar.setBounds(36, 281, 154, 42);
		contentPane.add(btnAtualizar);

		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletar.setBounds(309, 281, 154, 42);
		contentPane.add(btnDeletar);
	}

	public void atualizarProdutoEmCarrinho(ActionListener actionListener) {
		this.btnAtualizar.addActionListener(actionListener);
	}

	public void deletarProdutoDoCarrinho(ActionListener actionListener) {
		this.btnDeletar.addActionListener(actionListener);
	}
	public void setListaModeloCarrinho(DefaultListModel<Carrinho> modelo) {
	    listProdutos.setModel(modelo);
	}
	public Carrinho getProdutoSelecionadoCar() {
	    return listProdutos.getSelectedValue();
	}

}
