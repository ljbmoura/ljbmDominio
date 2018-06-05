package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table(name = "FundoInvestimento")
//, uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
//@Cacheable
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement(name = "FundoInvestimento")
@JsonRootName(value = "FundoInvestimento")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = { "ide", "nome", "cnpj", "tipoFundoInvestimento", "taxaImpostoRenda", "versao" })
//@JsonPropertyOrder({ "ide", "nome", "cnpj", "tipoFundoInvestimento", "taxaImpostoRenda", "versao" })
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ide")
public class FundoInvestimento implements java.io.Serializable {

	private static final long serialVersionUID = 3905125413892087441L;
	
	private Long ide;
	private Integer versao;
	private String cnpj;
	private String nome;
	private BigDecimal taxaImpostoRenda;
	private TipoFundoInvestimento tipoFundoInvestimento;
	@JsonInclude(Include.NON_NULL)
	private Corretora corretora;

	public FundoInvestimento() {
		// The no-arg constructor required by JPA
	}

	public FundoInvestimento(String cnpj, String nome, BigDecimal taxaImpostoRenda,
			TipoFundoInvestimento tipoFundoInvestimento, Corretora corretora) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.taxaImpostoRenda = taxaImpostoRenda;
		this.tipoFundoInvestimento = tipoFundoInvestimento;
		this.corretora = corretora;
	}

	// TODO desativar este construtor
	public FundoInvestimento(String cnpj, String nome, BigDecimal taxaimpostorenda,
			TipoFundoInvestimento tipoFundoInvestimento) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.taxaImpostoRenda = taxaimpostorenda;
		this.tipoFundoInvestimento = tipoFundoInvestimento;
		this.corretora = null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ide", nullable = false)
	public Long getIde() {
		return this.ide;
	}

	public void setIde(Long ide) {
		this.ide = ide;
	}

	@Version
	@Column(name = "versao")
	public Integer getVersao() {
		return this.versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Column(name = "cnpj", nullable = true, length = 14)
	// TODO configurar validações CNPJ, ver curso caelum
	// @Size(min = 0, max = 14)
	// @Digits(fraction = 0, integer = 14)
	public String getCNPJ() {
		return this.cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nome", nullable = false, length = 90)
	@NotNull
	@Size(min = 5, max = 90)
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
		return this.taxaImpostoRenda;
	}

	public void setTaxaImpostoRenda(BigDecimal taxaimpostorenda) {
		this.taxaImpostoRenda = taxaimpostorenda;
	}

	@Column(name = "tipoFundoInvestimento", nullable = true)
	@Enumerated(EnumType.ORDINAL)
	public TipoFundoInvestimento getTipoFundoInvestimento() {
		return tipoFundoInvestimento;
	}

	public void setTipoFundoInvestimento(TipoFundoInvestimento tipoFundoInvestimento) {
		this.tipoFundoInvestimento = tipoFundoInvestimento;
	}

	@ManyToOne(optional = false, fetch=FetchType.LAZY)
	public Corretora getCorretora() {
		return corretora;
	}

	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundoInvestimento \n\t[id=" + ide + ", \tnome=" + nome + ", \tCNPJ=" + cnpj
				+ ", \ttipoFundoInvestimento=" + tipoFundoInvestimento  
				+ ", \ttaxaImpostoRenda=" + taxaImpostoRenda
//				+ ", \n\tcorretora=" + corretora.getIde()
				+ ", \tversion=" + versao + "]";
	}

}
