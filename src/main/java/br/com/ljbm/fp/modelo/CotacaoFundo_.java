package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-03-02T18:19:30.856-0300")
@StaticMetamodel(CotacaoFundo.class)
public class CotacaoFundo_ {
	public static volatile SingularAttribute<CotacaoFundo, Long> ide;
	public static volatile SingularAttribute<CotacaoFundo, LocalDate> dataCotacao;
	public static volatile SingularAttribute<CotacaoFundo, BigDecimal> valorCota;
	public static volatile SingularAttribute<CotacaoFundo, FundoInvestimento> fundoInvestimento;
}
