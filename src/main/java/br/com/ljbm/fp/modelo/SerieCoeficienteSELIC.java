package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "seriecoeficienteselic")
@Cacheable
@XmlRootElement(name = "SerieCoeficienteSELIC")
@XmlAccessorType(XmlAccessType.FIELD)
public class SerieCoeficienteSELIC implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143557619299084513L;
	private Long ide;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFim;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	private BigDecimal fator;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide")
	public Long getIde() {
		return ide;
	}
	
	/**
	 * @return the data
	 */
	@Column(name = "datainicio", nullable = false)
//	@Temporal(TemporalType.DATE)
	@NotNull
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	/**
	 * @return the data
	 */
	@Column(name = "datafim", nullable = false)
//	@Temporal(TemporalType.DATE)
	@NotNull
	public LocalDate getDataFim() {
		return dataFim;
	}
	/**
	 * @return the fator
	 */
	@Column(name = "fator", nullable = false, precision = 19, scale = 6)
	@NotNull
	public BigDecimal getFator() {
		return fator;
	}

	public void setIde(Long ide) {
		this.ide = ide;
	}
	
	/**
	 * @param dataInicio
	 *            the data to set
	 */
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @param dataFim
	 *            the data to set
	 */
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	/**
	 * @param fator
	 *            the fator to set
	 */
	public void setFator(BigDecimal fator) {
		this.fator = fator;
	}

}
