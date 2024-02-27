package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-02-25T16:31:10.661-0300")
@StaticMetamodel(SerieCoeficienteSELIC.class)
public class SerieCoeficienteSELIC_ {
	public static volatile SingularAttribute<SerieCoeficienteSELIC, Long> ide;
	public static volatile SingularAttribute<SerieCoeficienteSELIC, LocalDate> dataInicio;
	public static volatile SingularAttribute<SerieCoeficienteSELIC, LocalDate> dataFim;
	public static volatile SingularAttribute<SerieCoeficienteSELIC, BigDecimal> fator;
}
