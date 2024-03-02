package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-03-02T18:19:30.857-0300")
@StaticMetamodel(FundoInvestimento.class)
public class FundoInvestimento_ {
	public static volatile ListAttribute<FundoInvestimento, Aplicacao> aplicacoes;
	public static volatile SingularAttribute<FundoInvestimento, Long> ide;
	public static volatile SingularAttribute<FundoInvestimento, Integer> versao;
	public static volatile SingularAttribute<FundoInvestimento, String> CNPJ;
	public static volatile SingularAttribute<FundoInvestimento, String> nome;
	public static volatile SingularAttribute<FundoInvestimento, String> nomeAbreviado;
	public static volatile SingularAttribute<FundoInvestimento, BigDecimal> taxaImpostoRenda;
	public static volatile SingularAttribute<FundoInvestimento, TipoFundoInvestimento> tipoFundoInvestimento;
	public static volatile SingularAttribute<FundoInvestimento, Corretora> corretora;
}
