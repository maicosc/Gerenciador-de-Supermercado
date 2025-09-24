package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JRadioButton;

public class JanelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
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
	public JanelaCadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomaInc = new JLabel("REDE MAIK");
		lblNomaInc.setForeground(new Color(255, 0, 0));
		lblNomaInc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNomaInc.setBounds(60, 13, 122, 37);
		contentPane.add(lblNomaInc);
		
		JLabel lblSlogan = new JLabel("Sempre do seu lado");
		lblSlogan.setForeground(new Color(0, 0, 0));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSlogan.setBounds(10, 49, 132, 14);
		contentPane.add(lblSlogan);
		
		tfNome = new JTextField();
		tfNome.setFocusTraversalPolicyProvider(true);
		tfNome.setFocusable(false);
		tfNome.setName("Nome");
		tfNome.setToolTipText("Nome");
		tfNome.requestFocus(false);
		tfNome.setBounds(10, 112, 264, 30);
		if (tfNome.getText().trim().equals("")) {
			tfNome.setText("Digite sua senha!");
		}
			  
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(false);
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		tfCpf.setBounds(10, 172, 264, 30);
		
		contentPane.add(tfCpf);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setEnabled(false);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(255, 0, 0));
		btnCadastrar.setBounds(42, 345, 206, 30);
		
		contentPane.add(btnCadastrar);
		
		JLabel lblEmpresa = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblEmpresa.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmpresa.setBounds(10, 386, 264, 14);
		contentPane.add(lblEmpresa);
		
		JLabel lblIcon = new JLabel("New label");
		lblIcon.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		lblIcon.setBounds(10, 11, 40, 40);
		contentPane.add(lblIcon);
		
		JRadioButton rdbtnAdm = new JRadioButton("Administrador");
		rdbtnAdm.setBackground(new Color(234, 253, 255));
		rdbtnAdm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdm.setBounds(60, 228, 141, 37);
		contentPane.add(rdbtnAdm);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBackground(new Color(234, 253, 255));
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnCliente.setBounds(60, 278, 141, 37);
		contentPane.add(rdbtnCliente);
	}
}
