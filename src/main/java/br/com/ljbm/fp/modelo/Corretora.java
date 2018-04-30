package br.com.ljbm.fp.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Corretora")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
public class Corretora implements java.io.Serializable {

	private static final long serialVersionUID = 5872063361515729800L;
	
	public static String cnpjAgora = "74014747000135";
	public static String cnpjBB = "00000000000191";

	private Long ide;

	private String cnpj;

	private String razaoSocial;

	private String sigla;

	private Integer versao;
	
	private List<FundoInvestimento> fundosComprados;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy="corretora")
	@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public List<FundoInvestimento> getFundosComprados() {
		return fundosComprados;
	}
	
	public void setFundosComprados(List<FundoInvestimento> fundosComprados) {
		this.fundosComprados = fundosComprados;
	}

	@Override
	public String toString() {
		return "Corretora [ide=" + ide + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", sigla=" + sigla
				+ ", versao=" + versao + "]";
	}
}
