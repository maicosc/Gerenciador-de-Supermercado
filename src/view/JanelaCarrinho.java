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
import net.miginfocom.swing.MigLayout;

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
		contentPane.setLayout(new MigLayout("", "[154px,grow][119px,grow][154px,grow]", "[29px,grow][224px,grow][42px,grow]"));

		listProdutos = new JList();
		contentPane.add(listProdutos, "cell 0 1 3 1,grow");

		btnAtualizar = new JButton("");
		btnAtualizar.setBackground(new Color(234, 253, 255));
		btnAtualizar.setBorderPainted(false);
		btnAtualizar.setIcon(new ImageIcon(JanelaCarrinho.class.getResource("/images/AtualizarCarrinho.png")));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnAtualizar, "cell 0 2,grow");

		btnDeletar = new JButton("");
		btnDeletar.setBackground(new Color(234, 253, 255));
		btnDeletar.setBorderPainted(false);
		btnDeletar.setIcon(new ImageIcon(JanelaCarrinho.class.getResource("/images/DeletarNoCarrinho.png")));
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnDeletar, "cell 2 2,grow");
		
		lblValorTotal = new JLabel();
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblValorTotal, "cell 0 0 3 1,grow");
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
