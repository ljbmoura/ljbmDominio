package br.com.ljbm.fp.modelo;




import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity()
@Table(name = "CotacaoFundo")
public class CotacaoFundo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cotacao_fundo_seq")
    @SequenceGenerator(name = "cotacao_fundo_seq", sequenceName = "CotacaoFundo_ide", allocationSize = 1, schema = "dbo")
    @Column(name="ide")
    private Long ide;

    @Column(name = "dataCotacao", nullable = false)
    @NotNull
    private LocalDate dataCotacao;

    @Column(name = "valorCota", nullable = false, precision = 16, scale = 9)
    @NotNull
    private BigDecimal valorCota;

    @JoinColumn(name="fundoInvestimento_ide",  nullable = false)
	@ManyToOne(optional = false, fetch=FetchType.LAZY)
    private FundoInvestimento fundoInvestimento;

    public CotacaoFundo() {}

	public Long getIde() {
		return ide;
	}

	public void setIde(Long ide) {
		this.ide = ide;
	}

	public LocalDate getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(LocalDate dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public BigDecimal getValorCota() {
		return valorCota;
	}

	public void setValorCota(BigDecimal valorCota) {
		this.valorCota = valorCota;
	}

}
