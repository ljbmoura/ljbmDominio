package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.ljbm.utilitarios.FormatadorBR;

/**
 * Aplicação entity
 * 
 * @author ljbm
 * @since 27/03/2012
 * 
 *        um evento de aplicação financeira. Ex:
 *        -------------------------------------------------------------------
 *        Data Documento Valor aplicado Quantidade Cotas Saldo Cotas
 *        -------------------------------------------------------------------
 *        05/07/2006 105173037 1.867,00 309,394394 309,394394
 * 
 */
@Entity
@Table(name = "Aplicacao")
@Cacheable
@XmlRootElement
public class Aplicacao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019221936078212375L;

	private Calendar data;
	private Long documento;
	private BigDecimal valorAplicado;
	private BigDecimal quantidadeCotas;
	private BigDecimal saldoCotas;

	/**
	 * @param data
	 * @param documento
	 * @param valorAplicado
	 * @param quantidadeCotas
	 * @param saldoCotas
	 */
	public Aplicacao(Calendar data, Long documento, BigDecimal valorAplicado,
			BigDecimal quantidadeCotas, BigDecimal saldoCotas) {
		this.data = data;
		this.documento = documento;
		this.valorAplicado = valorAplicado;
		this.quantidadeCotas = quantidadeCotas;
		this.saldoCotas = saldoCotas;
	}

	public Aplicacao() {
		// construtor sem argumentos exigido pela JPA
	}

	/**
	 * @return the data
	 */
	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getData() {
		return (Calendar) data.clone();
	}

	/**
	 * @return the documento
	 */
	@Id
	@Column(name = "documento", nullable = false)
	public Long getDocumento() {
		return documento;
	}

	/**
	 * @return the valorAplicado
	 */
	@Column(name = "valorAplicado", nullable = false, precision = 19, scale = 2)
	@NotNull
	public BigDecimal getValorAplicado() {
		return valorAplicado;
	}

	/**
	 * @return the quantidadeCotas
	 */
	@Column(name = "quantidadeCotas", nullable = false, precision = 19, scale = 6)
	@NotNull
	public BigDecimal getQuantidadeCotas() {
		return quantidadeCotas;
	}

	/**
	 * @return the saldoCotas
	 */
	@Column(name = "saldoCotas", nullable = false, precision = 19, scale = 6)
	@NotNull
	public BigDecimal getSaldoCotas() {
		return saldoCotas;
	}

	/**
	 * @return the saldoCotas
	 */
	@Transient
	public BigDecimal getValorAplicadoRemanescente() {
		return saldoCotas.multiply(getValorCotaAplicacao());
	}

	/**
	 * @return the saldoCotas
	 */
	@Transient
	public BigDecimal getValorCotaAplicacao() {
		return valorAplicado.divide(quantidadeCotas, 9, RoundingMode.DOWN);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nAplicacao [data=" + FormatadorBR.formataDataCurta(data)
				+ ", documento=" + documento + ", valorAplicado="
				+ FormatadorBR.formataDecimal(valorAplicado)
				+ ", quantidadeCotas="
				+ FormatadorBR.formataDecimal(quantidadeCotas)
				+ ", saldoCotas=" + FormatadorBR.formataDecimal(saldoCotas)
				+ "]";
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	/**
	 * @param valorAplicado
	 *            the valorAplicado to set
	 */
	public void setValorAplicado(BigDecimal valorAplicado) {
		this.valorAplicado = valorAplicado;
	}

	/**
	 * @param quantidadeCotas
	 *            the quantidadeCotas to set
	 */
	public void setQuantidadeCotas(BigDecimal quantidadeCotas) {
		this.quantidadeCotas = quantidadeCotas;
	}

	/**
	 * @param saldoCotas
	 *            the saldoCotas to set
	 */
	public void setSaldoCotas(BigDecimal saldoCotas) {
		this.saldoCotas = saldoCotas;
	}
}
