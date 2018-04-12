package br.com.ljbm.utilitarios;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.given;

import java.math.BigDecimal;
import java.util.stream.Stream;

import com.jayway.restassured.path.json.JsonPath;

import br.com.ljbm.fp.modelo.Corretora;
import br.com.ljbm.fp.modelo.FundoInvestimento;
import br.com.ljbm.fp.modelo.TipoFundoInvestimento;


public class Cadastros {


	private static JsonPath enviaPost(FundoInvestimento fundoInvestimento) {
		JsonPath retorno = given().header("Accept", "application/json").contentType("application/json")
				.body(fundoInvestimento).when().post("http://pc:9080/ljbmWeb/rest/fundosInvestimento").andReturn()
				.jsonPath();
		return retorno;
	}


	public static void main(String[] args) {

		basePath = "http://pc:9080/ljbmWeb";

		Corretora bB = new Corretora();
		bB.setIde(1l);
		Corretora Agora = new Corretora();
		Agora.setIde(2l);
		
		Stream<FundoInvestimento> stream = Stream.of(
			new FundoInvestimento("74014747000135", "Agora Prefixado 2019", new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, Agora)
		  , new FundoInvestimento("74014747000135", "Agora Prefixado 2023", new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, Agora)
		  , new FundoInvestimento("74014747000135", "Agora NTNB-2024",      new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, Agora)
		  , new FundoInvestimento("74014747000135", "Agora NTNB-2035",      new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, Agora)
		);
		
		stream.forEach(fundo -> {
			JsonPath retorno = enviaPost(fundo);
			retorno.prettyPrint();
//			FundoInvestimento x = retorno.getObject("", FundoInvestimento.class);
//			System.out.println(x.toString());
		});
	}

}
