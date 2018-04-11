package br.com.ljbm.fp.modelo;

import static com.jayway.restassured.RestAssured.given;

import static com.jayway.restassured.RestAssured.basePath;
import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.jayway.restassured.path.json.JsonPath;

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

	private Long ide;
	private Integer versao;
	private String cnpj;
	private String nome;
	private BigDecimal taxaImpostoRenda;
	private TipoFundoInvestimento tipoFundoInvestimento;
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

	public FundoInvestimento(String cnpj, String nome, BigDecimal taxaimpostorenda,
			TipoFundoInvestimento tipoFundoInvestimento) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.taxaImpostoRenda = taxaimpostorenda;
		this.tipoFundoInvestimento = tipoFundoInvestimento;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	@ManyToOne(optional = false)
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
		return "FundoInvestimento \n\t[id=" + ide + ", \n\tnome=" + nome + ", \n\tCNPJ=" + cnpj
				+ ", \n\tipoFundoInvestimento=" + tipoFundoInvestimento + ", \n\ttaxaImpostoRenda=" + taxaImpostoRenda
				+ ", \n\tversion=" + versao + "]";
	}

	public static void main(String[] args) {

		basePath = "http://pc:9080/ljbmWeb";

		Corretora Agora = new Corretora();
		Agora.setIde(3l);
		
		// JsonPath retorno = criaNtnb2024Agora(Agora);
		// JsonPath retorno = criaNtnb2035Agora(Agora);
		// JsonPath retorno = criaAgoraPrefixado2019(Agora);

		JsonPath retorno = criaAgoraPrefixado2023(Agora);
		
		retorno.prettyPrint();
		FundoInvestimento x = retorno.getObject("", FundoInvestimento.class);
		System.out.println(x.toString());
	}

	private static JsonPath enviaPost(FundoInvestimento fundoInvestimento) {
		JsonPath retorno = given().header("Accept", "application/json").contentType("application/json")
				.body(fundoInvestimento).when().post("http://pc:9080/ljbmWeb/rest/fundosInvestimento").andReturn()
				.jsonPath();
		return retorno;
	}

	private static JsonPath criaAgoraPrefixado2023(Corretora corretora) {

		FundoInvestimento fundoInvestimento = new FundoInvestimento("74014747000135", "Agora Prefixado 2023",
				new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, corretora);

		return enviaPost(fundoInvestimento);
	}

	@SuppressWarnings("unused")
	private static JsonPath criaAgoraPrefixado2019(Corretora corretora) {

		FundoInvestimento fundoInvestimento = new FundoInvestimento("74014747000135", "Agora Prefixado 2019",
				new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, corretora);
		return enviaPost(fundoInvestimento);

	}
	
	@SuppressWarnings("unused")
	private static JsonPath criaNtnb2035Agora(Corretora corretora) {

		FundoInvestimento fundoInvestimento = new FundoInvestimento("74014747000135", "agora ntnb-2035",
				new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, corretora);
		return enviaPost(fundoInvestimento);
	}
	
	@SuppressWarnings("unused")
	private static JsonPath criaNtnb2024Agora(Corretora corretora) {

		FundoInvestimento fundoInvestimento = new FundoInvestimento("74014747000135", "agora ntnb-2024",
				new BigDecimal("0.15"), TipoFundoInvestimento.TesouroDireto, corretora);
		return enviaPost(fundoInvestimento);
	}
}
