package br.com.ljbm.fp.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Corretora")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement(name = "Corretora")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
		propOrder = { "ide", "sigla", "razaoSocial", "cnpj", "fundosSobCustodia", "versao" })
@JsonPropertyOrder({ "ide", "sigla", "razaoSocial", "cnpj", "fundosSobCustodia", "versao" })
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ide")
public class Corretora implements java.io.Serializable {

	private static final long serialVersionUID = 5872063361515729800L;
	
	public static String cnpjAgora = "74014747000135";
	public static String cnpjBB = "00000000000191";

	private Long ide;

	private String cnpj;

	private String razaoSocial;

	private String sigla;

	private Integer versao;
	
//	@XmlTransient
//	@JsonIgnore()
	@JsonInclude(Include.NON_NULL)
	@XmlElementWrapper(name="fundosComprados")
	private List<FundoInvestimento> fundosSobCustodia;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ide")
	public Long getIde() {
		return ide;
	}

	public void setIde(Long ide) {
		this.ide = ide;
	}

	@Column(name = "cnpj", nullable = false, unique = true, columnDefinition = "char(14)")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "razaoSocial", nullable = false, length = 70, columnDefinition = "varchar(70)")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "sigla", nullable = false, columnDefinition = "char(10)")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Version
	@Column(name = "versao", nullable = false)
	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer version) {
		this.versao = version;
	}
	
	@OneToMany(mappedBy="corretora", fetch=FetchType.LAZY)
//	@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public List<FundoInvestimento> getFundosSobCustodia() {
		return fundosSobCustodia;
	}
	
	public void setFundosSobCustodia(List<FundoInvestimento> fundosSobCustodia) {
		this.fundosSobCustodia = fundosSobCustodia;
	}

	@Override
	public String toString() {
		return "Corretora [ide=" + ide + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", sigla=" + sigla
				+ ", versao=" + versao + "]";
	}
}
