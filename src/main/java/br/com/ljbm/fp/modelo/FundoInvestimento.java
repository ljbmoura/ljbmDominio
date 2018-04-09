package br.com.ljbm.fp.modelo;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Fundo Investimento entity
 * 
 * @author ljbm
 * @since 27/03/2012
 * 
 *        ex: BB Ações Const Civil, CNPJ: 09.648.050/0001-54, taxa IR 15%
 * 
 */
@Entity
@Table(name = "FundoInvestimento", uniqueConstraints = @UniqueConstraint(columnNames = "CNPJ"))
@Cacheable
@XmlRootElement
public class FundoInvestimento implements java.io.Serializable {

	private static final long serialVersionUID = 4518086212521607721L;

	private Long id;
	private Integer version;
	private String cnpj;
	private String nome;
	private BigDecimal taxaimpostorenda;
	private TipoFundoInvestimento tipoFundoInvestimento;

	public FundoInvestimento() {
		// The no-arg constructor required by JPA
	}

	public FundoInvestimento(String cnpj, String nome,
			BigDecimal taxaimpostorenda, TipoFundoInvestimento tipoFundoInvestimento) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.taxaimpostorenda = taxaimpostorenda;
		this.tipoFundoInvestimento = tipoFundoInvestimento;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDEFUNDOINVESTIMENTO", nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "versaoregistro")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "CNPJ", unique = true, nullable = true, length = 14)
	// TODO configurar validações CNPJ, ver curso caelum
//	@Size(min = 0, max = 14)
//	@Digits(fraction = 0, integer = 14)
	public String getCNPJ() {
		return this.cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nome", nullable = false, length = 60)
	@NotNull
	@Size(min = 5, max = 30)
	// TODO configurar validação alfabética
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "taxaImpostoRenda", nullable = true, precision = 19, scale = 6)
	public BigDecimal getTaxaImpostoRenda() {
		return this.taxaimpostorenda;
	}

	public void setTaxaImpostoRenda(BigDecimal taxaimpostorenda) {
		this.taxaimpostorenda = taxaimpostorenda;
	}

	@Column(name = "tipoFundoInvestimento", nullable = true)
	@Enumerated(EnumType.ORDINAL)
	public TipoFundoInvestimento getTipoFundoInvestimento() {
		return tipoFundoInvestimento;
	}

	public void setTipoFundoInvestimento(TipoFundoInvestimento tipoFundoInvestimento) {
		this.tipoFundoInvestimento = tipoFundoInvestimento;
	}	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundoInvestimento \n\t[id=" + id + 
				", \n\tnome=" + nome 
				+ ", \n\tCNPJ=" + cnpj 
				+ ", \n\tipoFundoInvestimento=" + tipoFundoInvestimento
				+ ", \n\ttaxaImpostoRenda=" + taxaimpostorenda
				+ ", \n\tversion=" + version + "]";
	}


}
