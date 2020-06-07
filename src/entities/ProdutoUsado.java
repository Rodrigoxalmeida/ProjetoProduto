package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataCompra;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataCompra) {
		super(nome, preco);
		this.dataCompra = dataCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	@Override
	public String precoEtq() {
		return  getNome() + "(usado)- R$: " 
						  +String.format("%.2f", getPreco())  
						  + " (Data de compra: " 
						  + sdf.format(dataCompra) 
						  + ")";
	}

}
