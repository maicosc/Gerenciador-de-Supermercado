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
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

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
	private JList<Produto>list;
	

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
		setLayout(new MigLayout("", "[82px,grow][][1px,grow][114px,grow][112px,grow][25px,grow][138px,grow][grow][290px,grow]", "[50px,grow][50px,grow][40px,grow][28px,grow][43px,grow][grow][18px,grow][][][37px,grow][46px,grow][43px,grow][11px,grow][43px,grow][11px,grow][72px,grow]"));
		
		
		
		btnDeslogar = new JButton("");
		btnDeslogar.setBackground(new Color(234, 253, 255));
		btnDeslogar.setBorderPainted(false);
		btnDeslogar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeslogar.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/icons8-sair-50.png")));
		add(btnDeslogar, "cell 0 0,alignx left,growy");
		
		JLabel lblTitulo = new JLabel("Cadastro de Produto");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo, "cell 1 0,growx,aligny top");
		
		list = new JList();
		add(list, "cell 3 1 6 14,grow");
		
		tfNomeProduto = new JTextField();
		add(tfNomeProduto, "cell 1 2,grow");
		tfNomeProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblQuantidade, "flowx,cell 1 4,alignx right,growy");
		
		JLabel lblCodProd = new JLabel("Código do Produto:");
		lblCodProd.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblCodProd, "cell 0 5 1 3,alignx center,growy");
		
		tfCodProd = new JTextField();
		tfCodProd.setEnabled(false);
		tfCodProd.setColumns(10);
		add(tfCodProd, "cell 1 5 1 3,grow");
		
		btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.setBackground(new Color(234, 253, 255));
		btnAdicionarProduto.setBorderPainted(false);
		btnAdicionarProduto.setEnabled(false);
		btnAdicionarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/Adicionar.png")));
		btnAdicionarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		add(btnAdicionarProduto, "cell 1 9,grow");
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNomeProduto, "cell 0 2,alignx right,growy");
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblPreco, "flowx,cell 0 4,alignx right,growy");
		
		btnAtualizarProduto = new JButton("");
		btnAtualizarProduto.setBackground(new Color(234, 253, 255));
		btnAtualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizarProduto.setBorderPainted(false);
		btnAtualizarProduto.setEnabled(false);
		btnAtualizarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/AtualizarProduto.png")));
		btnAtualizarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		add(btnAtualizarProduto, "cell 1 10,grow");
		
		tfPreco = new JTextField();
		tfPreco.setEnabled(false);
		tfPreco.setColumns(10);
		add(tfPreco, "cell 0 4,grow");
		
		btnDeletarProduto = new JButton("");
		btnDeletarProduto.setBackground(new Color(234, 253, 255));
		btnDeletarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletarProduto.setBorderPainted(false);
		btnDeletarProduto.setEnabled(false);
		btnDeletarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeletarProduto.setIcon(new ImageIcon(JanelaCadastroProduto.class.getResource("/images/DeletarProduto.png")));
		btnDeletarProduto.setFont(new Font("Tahoma", Font.BOLD, 27));
		add(btnDeletarProduto, "cell 1 11,growx,aligny top");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setEnabled(false);
		tfQuantidade.setColumns(10);
		add(tfQuantidade, "cell 1 4,grow");
	}

	public String getNomeProduto() {
		return tfNomeProduto.getText();
	}

	public String getPreco() {
		return tfPreco.getText();
	}

	public String getQuantidade() {
		return tfQuantidade.getText();
	}

	public String getCodProd() {
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

	public JTextField getTfNomeProduto() {
		return tfNomeProduto;
	}

	public JTextField getTfPreco() {
		return tfPreco;
	}

	public JTextField getTfQuantidade() {
		return tfQuantidade;
	}

	public JTextField getTfCodProd() {
		return tfCodProd;
	}

	public JButton getBtnAdicionarProduto() {
		return btnAdicionarProduto;
	}

	public JButton getBtnAtualizarProduto() {
		return btnAtualizarProduto;
	}

	public JButton getBtnDeletarProduto() {
		return btnDeletarProduto;
	}

	public JList getList() {
		return list;
	}
	public void ativaPreco(KeyListener kLis) {
		this.tfNomeProduto.addKeyListener(kLis);
	}
	public void ativaQuantidade(KeyListener kLis) {
		this.tfPreco.addKeyListener(kLis);
	}
	public void ativaCodigo(KeyListener kLis) {
		this.tfQuantidade.addKeyListener(kLis);
	}
	public void ativaAdicionar(KeyListener kLis) {
		this.tfCodProd.addKeyListener(kLis);
	}
	public Produto getProdutoSelecionado() {
	    return list.getSelectedValue();
	}
	public void preencherFormulario(Produto p) {
		this.tfNomeProduto.setText(p.getNomeProd());
		this.tfPreco.setText(String.format("%.2f",p.getPreco()));
		this.tfQuantidade.setText(String.valueOf(p.getQuantidade()));
		this.tfCodProd.setText(String.valueOf(p.getCodProd()));
	}
	
}
