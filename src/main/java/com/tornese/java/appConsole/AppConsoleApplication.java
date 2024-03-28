package com.tornese.java.appConsole;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import com.tornese.java.appConsole.entidades.Cliente;
import com.tornese.java.appConsole.entidades.Pedido;
import com.tornese.java.appConsole.servicos.Configuracao;
import com.tornese.java.appConsole.InputControl;

@SpringBootApplication
public class AppConsoleApplication {

	public static void main(String[] args) {

		/*
		 * João é um comerciante que vende laranjas Ele precisa fazer uma entrega de
		 * algumas caixas cada laranja ele vende por 0,50 centavos, cada caixa tem 50
		 * laranjas
		 * 
		 * Faça um programa que peça a quantidade de caixas para o joão e de o total a
		 * receber
		 * 
		 * Perguntar se o pagamento é a vista, caso seja a vista e valor for maior que
		 * R$ 100 reais dar um desconto de 10% temos promoção levou 10 ganhou 10%, ou
		 * seja se for 10 caixas dar 10% de desconto
		 * 
		 * Caso o pagamento seja parcelado acrescentar 15% sobre o valor total segundo a
		 * tebela 2x = 5% 3x = 8% 4x = 10% 5x = 13% maior que 5x = 15%
		 * 
		 * Obs: aceitar parcelas no máximo até 12 meses, e mostrar o valor de cada
		 * parcela já com acrescimo
		 * 
		 * 
		 * O lucro do comerciante será de 45% em suas vendas
		 * 
		 * Dar um relatório final sobre a operação acima
		 * 
		 * armazene o nome e o valor do cliente para que o final da operação você possa
		 * mostrar o nome e a quantidade de caixas
		 * 
		 */

		List<Pedido> pedidos = new ArrayList<Pedido>();
		Configuracao config = new Configuracao();

		while (true) {

			System.out.println("=================");
			System.out.println("Seja Bem vindo ao seu software");
			System.out.println("=================");
			int sair = InputControl.lerNumero("Digite \n1 para continuar \n0 para sair\n", config.getContinuarOuSair());
			if (sair == 0) break;

			Pedido pedido = new Pedido();
			pedido.setCliente(new Cliente());
			pedido.getCliente().setNome(InputControl.lerString("Digite o nome do cliente que quer comprar as caixas:\n"));
			int qtdCaixas = InputControl.lerNumero("Digite a quantidade de caixas que o " + pedido.getCliente().getNome() + " deseja:\n");
			pedido.setQtdCaixas(qtdCaixas);

			System.out.println("[" + qtdCaixas + "]");// outra maneira: System.out.printf("[%s]", qtdCaixas);

			pedido.setTotalDeLaranjas(qtdCaixas, config.getValorLaranja(), config.getQtdDeLaranjaPorCaixas());

			String tipoPagamento = InputControl.lerString(config.getaVistaOuParcelado(),"A compra será a vista ou parcelado? \n A - A vista \n P - Parcelado : \n");
			
			boolean aVista = tipoPagamento.toUpperCase().equals(config.getaVistaOuParcelado()[0]);
			if (aVista) {
				System.out.println("Você selecionou pagamento a vista");
				pedido.alterarValorParaPagamentoAVista(config.getValorParaDesconto(), qtdCaixas, config.getQtdCaixasPromocao(), config.getPorcentagemDesconto());
				
			} else {
				pedido.setParcelas(InputControl.lerNumero("Você selecionou pagamento parcelado, Digite a quantidade de parcelas: \n"));
				if (pedido.getParcelas() > config.getMaximoparcelas()) {
					System.out.println("Quantidade de parcelas Invalida, iremos assumir que será em " + config.getMaximoparcelas() + " vezes");
					pedido.setParcelas(config.getMaximoparcelas());
				}

				if (pedido.getParcelas() == 1) {
					pedido.alterarValorParaPagamentoAVista(config.getValorParaDesconto(), qtdCaixas, config.getQtdCaixasPromocao(), config.getPorcentagemDesconto());
				} else 
					pedido.acrescentaJuros(config.getPorcentagemAcrescimo());
			}

			pedido.calculaLucroAReceber(config.getProcetagemLucro());
			pedidos.add(pedido);

			System.out.println("=================");
			System.out.println("O seu lucro é de : R$ " + pedido.getLucroAReceber());
			System.out.println("O valor total a cobrar do cliente é de : R$ " + pedido.getValorTotalAlterado());
			System.out.println("O cliente escolheu o tipo de pagamento " + (aVista ? "A vista" : "Parcelado em " + pedido.getParcelas() + " vezes"));
			if (!aVista && pedido.getParcelas() != 1) {
				System.out.println("Para o pagamento parcelado cobramos o juros de: R$ " + pedido.valorDoJuros());
				System.out.println("O valor da parcela será de : R$ " + pedido.valorDaParcela());
			} else {
				System.out.println("Para o pagamento a vista demos o desconto de: R$ " + pedido.valorComDesconto());
			}
			System.out.println("=================");

			
		}
		System.out.println("RESUMO");
		for(int i=0; i<pedidos.size(); i++){
			Pedido pedido = pedidos.get(i);
			System.out.println("=================");
			System.out.println("Cliente: " + pedido.getCliente().getNome());
			System.out.println("Quantidade de Caixas: " + pedido.getQtdCaixas());
			System.out.println("Valor total a pagar: " + pedido.getValorTotalAlterado());
			System.out.println("=================");

		}

		// SpringApplication.run(AppConsoleApplication.class, args);
	}

}
