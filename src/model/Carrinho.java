package model;

public class Carrinho {

	private int quantidadeItens, id;
	private double valorTotal;
	private String[] itens;
	
	public Carrinho() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public int getId() {
		return id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String[] getItens() {
		return itens;
	}

	public void setItens(String[] itens) {
		this.itens = itens;
	}
	
}
