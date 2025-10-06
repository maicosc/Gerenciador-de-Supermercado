package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Carrinho;
import model.Produto;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JanelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeProduto;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField tfCodProd;
	private JButton btnAdicionarProduto;
	private JButton btnAtualizarProduto;
	private JButton btnDeletarProduto;
	private JButton btnDeslogar;
	private JList list;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JanelaCadastroProduto() {
		setBackground(new Color(234, 253, 255));
		
		setBounds(100, 100, 820, 568);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setLayout(null);
		
		
		
		btnDeslogar = new JButton("");
		btnDeslogar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeslogar.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/icons8-sair-50.png")));
		btnDeslogar.setBounds(10, 11, 50, 50);
		add(btnDeslogar);
		
		list = new JList();
		list.setBounds(491, 39, 290, 464);
		add(list);
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(181, 114, 264, 37);
		add(tfNomeProduto);
		tfNomeProduto.setColumns(10);
		
		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(95, 182, 112, 37);
		add(tfPreco);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		tfQuantidade.setBounds(344, 185, 112, 37);
		add(tfQuantidade);
		
		tfCodProd = new JTextField();
		tfCodProd.setColumns(10);
		tfCodProd.setBounds(207, 240, 112, 37);
		add(tfCodProd);
		
		btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/Adicionar.png")));
		btnAdicionarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnAdicionarProduto.setBounds(95, 394, 224, 43);
		add(btnAdicionarProduto);
		
		btnAtualizarProduto = new JButton("");
		btnAtualizarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/AtualizarProduto.png")));
		btnAtualizarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnAtualizarProduto.setBounds(95, 448, 224, 43);
		add(btnAtualizarProduto);
		
		btnDeletarProduto = new JButton("");
		btnDeletarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeletarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/DeletarProduto.png")));
		btnDeletarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnDeletarProduto.setBounds(95, 502, 224, 43);
		add(btnDeletarProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNomeProduto.setBounds(10, 111, 174, 36);
		add(lblNomeProduto);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPreco.setBounds(21, 179, 71, 37);
		add(lblPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantidade.setBounds(221, 182, 125, 37);
		add(lblQuantidade);
		
		JLabel lblCodProd = new JLabel("Código do Produto:");
		lblCodProd.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCodProd.setBounds(21, 240, 186, 37);
		add(lblCodProd);
		
		JLabel lblTitulo = new JLabel("Cadastro de Produto");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(93, 11, 389, 37);
		add(lblTitulo);
	}

	public String getTfNomeProduto() {
		return tfNomeProduto.getText();
	}

	public String getTfPreco() {
		return tfPreco.getText();
	}

	public String getTfQuantidade() {
		return tfQuantidade.getText();
	}

	public String getTfCodProd() {
		return tfCodProd.getText();
	}
	public void cadastrarProduto(ActionListener actionListener) {
		this.btnAdicionarProduto.addActionListener(actionListener);
	}
	public void atualizarProduto(ActionListener actionListener) {
		this.btnAtualizarProduto.addActionListener(actionListener);
	}
	public void deletarProduto(ActionListener actionListener) {
		this.btnDeletarProduto.addActionListener(actionListener);
	}
	public void limparFormulario() {
		this.tfNomeProduto.setText("");
		this.tfPreco.setText("");
		this.tfQuantidade.setText("");
		this.tfCodProd.setText("");
	}
	public void deslogar(ActionListener actionListener) {
		this.btnDeslogar.addActionListener(actionListener);
	}
	public void setListaModeloProduto(DefaultListModel<Produto> modelo) {
	    list.setModel(modelo);
	}
	
	
}
