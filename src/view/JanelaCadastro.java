package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JRadioButton;

public class JanelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JButton btnCadastrar;
	private String tipoUser;
	private ButtonGroup grupo;
	private JRadioButton rdbtnCliente, rdbtnAdm;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		
		
		setBounds(100, 100, 820, 568);
		
		setBackground(new Color(234, 253, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JLabel lblNomaInc = new JLabel("REDE MAIK");
		lblNomaInc.setForeground(new Color(255, 0, 0));
		lblNomaInc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNomaInc.setBounds(60, 13, 122, 37);
		add(lblNomaInc);
		
		JLabel lblSlogan = new JLabel("Sempre do seu lado");
		lblSlogan.setForeground(new Color(0, 0, 0));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSlogan.setBounds(10, 49, 132, 14);
		add(lblSlogan);
		
		tfNome = new JTextField();
		tfNome.setName("Nome");
		tfNome.setToolTipText("Nome");
		tfNome.setBounds(125, 116, 567, 40);
		
			  
		add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(true);
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		tfCpf.setBounds(125, 182, 567, 40);
		
		add(tfCpf);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setEnabled(true);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(255, 0, 0));
		btnCadastrar.setBounds(271, 328, 264, 50);
		
		add(btnCadastrar);
		
		JLabel lblEmpresa = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblEmpresa.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmpresa.setBounds(185, 483, 389, 37);
		add(lblEmpresa);
		
		JLabel lblIcon = new JLabel("New label");
		lblIcon.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		lblIcon.setBounds(10, 11, 40, 40);
		add(lblIcon);
		
		rdbtnAdm = new JRadioButton("Administrador");
		rdbtnAdm.setBackground(new Color(234, 253, 255));
		rdbtnAdm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdm.setBounds(240, 256, 141, 37);
		add(rdbtnAdm);
		
		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBackground(new Color(234, 253, 255));
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnCliente.setBounds(447, 256, 141, 37);
		add(rdbtnCliente);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtnCliente);
		grupo.add(rdbtnAdm);
		
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNome.setBounds(54, 115, 74, 37);
		add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCPF.setBounds(60, 181, 61, 37);
		add(lblCPF);
	}
	public void cadastrar(ActionListener actionListener) {
		this.btnCadastrar.addActionListener(actionListener);
	}
	public String getNome() {
		return this.tfNome.getText();
	}
	public void setNome() {
		this.tfNome.setText("");
	}
	public String getCpf() {
		return this.tfCpf.getText();
	}
	public void setCpf() {
		this.tfCpf.setText("");
	}
	public String getTipoUser() {
		if(rdbtnAdm.isSelected()) {
			return "ADMINISTRADOR";
		}else if (rdbtnCliente.isSelected()) {
			return "CLIENTE";
		}else {
			return null;
		}
		
	}
	public void setTipoUser(String text) {
		this.tipoUser = text;
	}
	public void limparFormulario() {
		this.tfNome.setText("");
		this.tfCpf.setText("");
		rdbtnAdm.setSelected(false);
		rdbtnCliente.setSelected(false);
	}
	
}
