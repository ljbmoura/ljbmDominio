package br.com.ljbm.fp.modelo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Corretora")
@Cacheable
@XmlRootElement
public class Corretora implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5419698720414307969L;

	private Long ide;
	
	private String cnpj;
	
	private String razaoSocial;
	
	private String sigla;
	
	private Integer versao;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ide")
	public Long getIde() {
		return ide;
	}

	public void setIde(Long ide) {
		this.ide = ide;
	}

	@Column(name="cnpj", nullable = false, unique=true, columnDefinition="char(14)")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name="razaoSocial", nullable=false, length=70, columnDefinition="varchar(70)")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name="sigla", nullable=false, columnDefinition="char(10)")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Version
	@Column(name="versao", nullable=false)
	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer version) {
		this.versao = version;
	}
}
