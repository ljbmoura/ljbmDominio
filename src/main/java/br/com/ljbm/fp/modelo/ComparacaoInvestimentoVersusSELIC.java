package br.com.ljbm.fp.modelo;

import java.math.BigDecimal;

//ComparativoFundoSELIC ComparacaoInvestimentoVersusSELIC

public class ComparacaoInvestimentoVersusSELIC implements java.io.Serializable {

	private static final long serialVersionUID = -1187014418958905109L;

	/**
	 * @param nomeInvestimento
	 * @param taxaRentabilidadeFundo
	 * @param taxaRentabilidadeSELICEquivalenteFundo
	 * @param diferencaRentabilidadeFundoSELIC
	 * @param totalValorFundo
	 * @param totalValorEquivalenteSELIC
	 */
	public ComparacaoInvestimentoVersusSELIC(String nomeInvestimento,
			BigDecimal taxaRentabilidadeFundo,
			BigDecimal taxaRentabilidadeSELICEquivalenteFundo,
			BigDecimal diferencaRentabilidadeFundoSELIC,
			BigDecimal totalValorFundo, BigDecimal totalValorEquivalenteSELIC) {
		this.nomeInvestimento = nomeInvestimento;
		this.taxaRentabilidadeFundo = taxaRentabilidadeFundo;
		this.taxaRentabilidadeSELICEquivalenteFundo = taxaRentabilidadeSELICEquivalenteFundo;
		this.diferencaRentabilidadeFundoSELIC = diferencaRentabilidadeFundoSELIC;
		this.totalValorFundo = totalValorFundo;
		this.totalValorEquivalenteSELIC = totalValorEquivalenteSELIC;
	}
	
	// BB Ações Energia     
	//	49.6957000  
	//	33.3290000   
	//	4402.657286666064590000    
	//	40268.166180167520000   
	//	35865.508893501455410000
	
	private String nomeInvestimento;
	private BigDecimal taxaRentabilidadeFundo;
	private BigDecimal taxaRentabilidadeSELICEquivalenteFundo;
	private BigDecimal diferencaRentabilidadeFundoSELIC;
	private BigDecimal totalValorFundo;
	private BigDecimal totalValorEquivalenteSELIC;
	/**
	 * @return the nomeInvestimento
	 */
	public String getNomeInvestimento() {
		return nomeInvestimento;
	}
	/**
	 * @return the taxaRentabilidadeFundo
	 */
	public BigDecimal getTaxaRentabilidadeFundo() {
		return taxaRentabilidadeFundo;
	}
	/**
	 * @return the taxaRentabilidadeSELICEquivalenteFundo
	 */
	public BigDecimal getTaxaRentabilidadeSELICEquivalenteFundo() {
		return taxaRentabilidadeSELICEquivalenteFundo;
	}
	/**
	 * @return the diferencaRentabilidadeFundoSELIC
	 */
	public BigDecimal getDiferencaRentabilidadeFundoSELIC() {
		return diferencaRentabilidadeFundoSELIC;
	}
	/**
	 * @return the totalValorFundo
	 */
	public BigDecimal getTotalValorFundo() {
		return totalValorFundo;
	}
	/**
	 * @return the totalValorEquivalenteSELIC
	 */
	public BigDecimal getTotalValorEquivalenteSELIC() {
		return totalValorEquivalenteSELIC;
	}
	/**
	 * @param nomeInvestimento the nomeInvestimento to set
	 */
	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}
	/**
	 * @param taxaRentabilidadeFundo the taxaRentabilidadeFundo to set
	 */
	public void setTaxaRentabilidadeFundo(BigDecimal taxaRentabilidadeFundo) {
		this.taxaRentabilidadeFundo = taxaRentabilidadeFundo;
	}
	/**
	 * @param taxaRentabilidadeSELICEquivalenteFundo the taxaRentabilidadeSELICEquivalenteFundo to set
	 */
	public void setTaxaRentabilidadeSELICEquivalenteFundo(
			BigDecimal taxaRentabilidadeSELICEquivalenteFundo) {
		this.taxaRentabilidadeSELICEquivalenteFundo = taxaRentabilidadeSELICEquivalenteFundo;
	}
	/**
	 * @param diferencaRentabilidadeFundoSELIC the diferencaRentabilidadeFundoSELIC to set
	 */
	public void setDiferencaRentabilidadeFundoSELIC(
			BigDecimal diferencaRentabilidadeFundoSELIC) {
		this.diferencaRentabilidadeFundoSELIC = diferencaRentabilidadeFundoSELIC;
	}
	/**
	 * @param totalValorFundo the totalValorFundo to set
	 */
	public void setTotalValorFundo(BigDecimal totalValorFundo) {
		this.totalValorFundo = totalValorFundo;
	}
	/**
	 * @param totalValorEquivalenteSELIC the totalValorEquivalenteSELIC to set
	 */
	public void setTotalValorEquivalenteSELIC(BigDecimal totalValorEquivalenteSELIC) {
		this.totalValorEquivalenteSELIC = totalValorEquivalenteSELIC;
	}


}
