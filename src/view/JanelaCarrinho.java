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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JanelaCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JList<Carrinho> listProdutos;
	private JLabel lblValorTotal;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JanelaCarrinho() {
		
		setBounds(100, 100, 510, 373);
		setTitle("Carrinho");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		listProdutos = new JList();
		listProdutos.setBounds(36, 46, 427, 224);
		contentPane.add(listProdutos);

		btnAtualizar = new JButton("");
		btnAtualizar.setBorderPainted(false);
		btnAtualizar.setIcon(new ImageIcon(JanelaCarrinho.class.getResource("/images/AtualizarCarrinho.png")));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizar.setBounds(36, 281, 154, 42);
		contentPane.add(btnAtualizar);

		btnDeletar = new JButton("");
		btnDeletar.setBorderPainted(false);
		btnDeletar.setIcon(new ImageIcon(JanelaCarrinho.class.getResource("/images/DeletarNoCarrinho.png")));
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletar.setBounds(309, 281, 154, 42);
		contentPane.add(btnDeletar);
		
		lblValorTotal = new JLabel();
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setBounds(97, 11, 284, 29);
		contentPane.add(lblValorTotal);
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
	public void setLblValorTotal(String texto) {
		this.lblValorTotal.setText(texto);
	}

	public JList<Carrinho> getListProdutos() {
		return listProdutos;
	}
	
}
