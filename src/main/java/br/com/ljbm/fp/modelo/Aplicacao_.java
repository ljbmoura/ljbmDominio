package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-07T22:39:53.593-0300")
@StaticMetamodel(Aplicacao.class)
public class Aplicacao_ {
	public static volatile SingularAttribute<Aplicacao, Long> ide;
	public static volatile SingularAttribute<Aplicacao, LocalDate> dataCompra;
	public static volatile SingularAttribute<Aplicacao, Long> documento;
	public static volatile SingularAttribute<Aplicacao, FundoInvestimento> fundoInvestimento;
	public static volatile SingularAttribute<Aplicacao, BigDecimal> valorAplicado;
	public static volatile SingularAttribute<Aplicacao, BigDecimal> quantidadeCotas;
	public static volatile SingularAttribute<Aplicacao, BigDecimal> saldoCotas;
}
