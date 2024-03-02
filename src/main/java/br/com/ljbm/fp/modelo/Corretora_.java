package br.com.ljbm.fp.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-03-02T18:19:30.854-0300")
@StaticMetamodel(Corretora.class)
public class Corretora_ {
	public static volatile SingularAttribute<Corretora, Long> ide;
	public static volatile SingularAttribute<Corretora, String> cnpj;
	public static volatile SingularAttribute<Corretora, String> razaoSocial;
	public static volatile SingularAttribute<Corretora, String> sigla;
	public static volatile SingularAttribute<Corretora, Integer> versao;
	public static volatile ListAttribute<Corretora, FundoInvestimento> fundosSobCustodia;
}
