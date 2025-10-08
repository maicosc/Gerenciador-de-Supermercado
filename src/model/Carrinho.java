package model;

public class Carrinho {

	private int id;
	private double valorProduto;
	private String nomeProduto, cpf;
	private int codProd, quantidade;
	public Carrinho( double valorProduto, String nomeProduto, int quantidade, int codProd, String cpf) {
		this.quantidade = quantidade;
		this.codProd = codProd;
		this.cpf =cpf;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}
	
	public Carrinho() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		
		return getNomeProduto() +" ------------- Quantidade: "+ getQuantidade()+" ------------ R$ "+String.format("%.2f", getValorProduto()*getQuantidade());
	}
	
}
