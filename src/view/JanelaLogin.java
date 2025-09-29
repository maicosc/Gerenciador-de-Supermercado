package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class JanelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JanelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REDE MAIK");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 13, 122, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sempre do seu lado");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 49, 132, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setName("");
		textField.setToolTipText("Nome");
		textField.setBounds(10, 112, 264, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setToolTipText("CPF");
		textField_1.setDragEnabled(true);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 172, 264, 30);
		
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("ENTRAR");
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(40, 238, 206, 30);
		
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Não possui cadastro?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(50, 279, 132, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cadastrar");
		lblNewLabel_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_4.setBounds(170, 279, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 386, 264, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		lblNewLabel.setBounds(10, 11, 40, 40);
		contentPane.add(lblNewLabel);
	}
	public void logar(ActionListener actionListener) {
		this.btnNewButton.addActionListener(actionListener);
	}
	public String getNome() {
		return this.textField.getText();
	}
	public void setNome() {
		this.textField.setText("");
	}
	public String getCpf() {
		return this.textField_1.getText();
	}
	public void setCpf() {
		this.textField_1.setText("");
	}
	public void limparFormulario() {
		this.textField.setText("");
		this.textField_1.setText("");
	}
	public void irParaCadastro(MouseListener mouseListener) {
		this.lblNewLabel_4.addMouseListener(mouseListener);
	}

}
