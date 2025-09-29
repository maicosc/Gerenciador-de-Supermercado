package model;

public class Produto {

	private double preco;
	private int quantidade, id;
	private String nomeProd;
	public Produto(double preco,int quantidade,String nomeProd, int id) {
		// TODO Auto-generated constructor stub
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
	public int getId() {
		return id;
	}
	
}
