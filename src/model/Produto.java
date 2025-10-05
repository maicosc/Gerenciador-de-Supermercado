package model;

public class Produto {

	private double preco;
	private int quantidade, codProd;
	private String nomeProd;
	public Produto(String nomeProd, int quantidade, double preco, int codProd) {
		
		this.nomeProd = nomeProd;
        this.quantidade = quantidade;
        this.preco = preco;
        this.codProd = codProd;
	}
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	
	@Override
	public String toString() {
		
		return getNomeProd() + "------------------ R$ "+String.format("%.2f", getPreco());
	}
	
}
