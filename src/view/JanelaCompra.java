package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import model.Produto;

public class JanelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDeslogar;
	private JButton btnCarrinho;
	private JButton btnAdicionarAoCarrinho;
	private JList<Produto> listProdutos;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCompra frame = new JanelaCompra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaCompra() {
		
		setBounds(100, 100, 820, 568);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setLayout(null);
		
		
		
		btnDeslogar = new JButton("Deslogar");
		btnDeslogar.setBounds(10, 11, 49, 41);
		add(btnDeslogar);
		
		btnCarrinho = new JButton("Carrinho");
		btnCarrinho.setBounds(747, 11, 49, 41);
		add(btnCarrinho);
		
		listProdutos = new JList();
		listProdutos.setBounds(43, 94, 554, 426);
		
		add(listProdutos);
		
		btnAdicionarAoCarrinho = new JButton("Adicionar");
		btnAdicionarAoCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAdicionarAoCarrinho.setBounds(607, 232, 189, 79);
		add(btnAdicionarAoCarrinho);
		
		JLabel lblTitulo = new JLabel("Compra de Produtos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(74, 29, 541, 54);
		add(lblTitulo);
	}
	public void deslogar(ActionListener actionListener) {
		this.btnDeslogar.addActionListener(actionListener);
	}
	public void abrirCarrinho(ActionListener actionListener) {
		this.btnCarrinho.addActionListener(actionListener);
	}
	public void adicionarAoCarrinho(ActionListener actionListener) {
		this.btnAdicionarAoCarrinho.addActionListener(actionListener);
	}

	public void setListaModelo(DefaultListModel<Produto> modelo) {
	    listProdutos.setModel(modelo);
	}

	public Produto getProdutoSelecionado() {
	    return listProdutos.getSelectedValue();
	}
	
	
}
