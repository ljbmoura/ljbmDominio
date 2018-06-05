package br.com.ljbm.utilitarios;

import static br.com.ljbm.fp.modelo.Corretora.cnpjAgora;
import static br.com.ljbm.fp.modelo.Corretora.cnpjBB;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.basePath;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.ljbm.fp.modelo.Corretora;
import br.com.ljbm.fp.modelo.FundoInvestimento;
import br.com.ljbm.fp.modelo.TipoFundoInvestimento;
import io.restassured.response.Response;


public class Cadastros {


	private static final BigDecimal TAXA_IMPOSTO_RENDA_POS_2ANOS = new BigDecimal("0.15");


	private static Response enviaPost(FundoInvestimento fundoInvestimento) {
		Response retorno = given().header("Accept", "application/json").contentType("application/json")
				.body(fundoInvestimento).when().post("http://pc:9080/ljbmWeb/rest/fundosInvestimento").andReturn();
		return retorno;
	}

	public static void main(String[] args) {

//		basePath = "http://localhost:9080/ljbmWeb";
		baseURI = "http://localhost:9080";
		basePath = "/ljbmWeb/rest";		

		cadastroFundosInvestimento();

	}


	private static void cadastroFundosInvestimento() {
		Corretora bB = new Corretora();
		bB.setIde(1l);
		Corretora Agora = new Corretora();
		Agora.setIde(2l);
		
		List<FundoInvestimento> fundos = Arrays.asList(
				
				new FundoInvestimento(cnpjBB, "Tesouro IPCA+ 2024", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, bB),
				new FundoInvestimento(cnpjBB, "Tesouro IPCA+ 2035", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, bB),
				new FundoInvestimento(cnpjBB, "Tesouro IPCA+ com Juros Semestrais 2024", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, bB),
				new FundoInvestimento(cnpjBB, "Tesouro IPCA+ com Juros Semestrais 2045", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, bB),
				
				new FundoInvestimento(cnpjAgora, "Tesouro IPCA+ 2019", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, Agora),
				new FundoInvestimento(cnpjAgora, "Tesouro IPCA+ 2024", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, Agora),
				new FundoInvestimento(cnpjAgora, "Tesouro IPCA+ 2035", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, Agora),
				new FundoInvestimento(cnpjAgora, "Tesouro Prefixado 2019", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, Agora),
				new FundoInvestimento(cnpjAgora, "Tesouro Prefixado 2023", TAXA_IMPOSTO_RENDA_POS_2ANOS,
						TipoFundoInvestimento.TesouroDireto, Agora)
			);
		
		
		fundos.forEach(fundo -> {
			 Response retorno = enviaPost(fundo);
			System.out.println("Response Headers\n" + retorno.headers().toString());
		});
	}

}
