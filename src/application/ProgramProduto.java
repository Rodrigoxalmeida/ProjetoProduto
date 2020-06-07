package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class ProgramProduto {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// CRIA UMA LISTA DE PRODUTO
		List<Produto> listaProduto = new ArrayList<>();

		System.out.print("Quantidades de produtos: ");
		int n = sc.nextInt();
		System.out.println("-----------------------------------------------------------------------");
		
		// PEDIR PRODUTO DE ACORDO COM A QUANTIDADE
		for (int i = 1; i <= n; i++) {

			System.out.println("Produto #" + i);
			System.out.print("Informe o tipo de produto: \n Comum, usado ou importado (c/u/i):");
			char tipoProduto = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if (tipoProduto == 'c') {
				Produto p = new Produto(nome, preco);
				listaProduto.add(p); // ADD PRODUTO NA LISTA
				System.out.println("-----------------------------------------------------------------------");


			} else if (tipoProduto == 'u') {
				System.out.print("Data de compra: ");
				Date data = sdf.parse(sc.next());
				ProdutoUsado pu = new ProdutoUsado(nome, preco, data);
				listaProduto.add(pu); // ADD PRODUTO NA LISTA
				System.out.println("-----------------------------------------------------------------------");


			} else if (tipoProduto == 'i') {
				System.out.print("Taxa:");
				double taxa = sc.nextDouble();
				ProdutoImportado pi = new ProdutoImportado(nome, preco, taxa);
				listaProduto.add(pi); // ADD PRODUTO NA LISTA
				System.out.println("-----------------------------------------------------------------------");

			}

		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Tabela de preços:");
		System.out.println("-----------------------------------------------------------------------");

		// PERCORRE A LISTA E IMPRIME OS PRODUTOS DE ACORDO COM A ESCOLHA: COMUM, USADO OU IMPORTADO
		for (Produto prod : listaProduto) {
			System.out.println(prod.precoEtq());

		}

		sc.close();

	}

}
