package entities;

public class ProdutoImportado extends Produto{

	
	private Double taxaImportado;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaImportado) {
		super(nome, preco);
		this.taxaImportado = taxaImportado;
	}

	public Double getTaxaImportado() {
		return taxaImportado;
	}

	public void setTaxaImportado(Double taxaImportado) {
		this.taxaImportado = taxaImportado;
	}
	
	@Override
	public String precoEtq() {
		return getNome() 
				+" R$: " + String.format("%.2f", precoTotal())  
				+ " (taxa de importação: " + taxaImportado 
				+ ")";
	}
	
	public double precoTotal () {
		return  getPreco() + taxaImportado; // CALCULA PRECO COM A TAXA DE IMPORTAÇÃO
	}
	
	
	
	
}
