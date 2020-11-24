package app.models.entities.produtos.veiculos;

import app.models.entities.produtos.Produto;
import app.utils.TipoProduto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Veiculo implements Produto {
    private static final TipoProduto TIPO_PRODUTO = TipoProduto.VEICULO;
    private Integer id;
    private TipoVeiculo tipoVeiculo;
    private String recinto;
    private Integer quantidade;
    private String unidade;
    private String descricao;
    private BigDecimal valorMinimo;

    public Veiculo(TipoVeiculo tipoVeiculo, String recinto, Integer quantidade, String unidade, String descricao, BigDecimal valorMinimo) {
        setTipoVeiculo(tipoVeiculo);
        setRecinto(recinto);
        setQuantidade(quantidade);
        setUnidade(unidade);
        setDescricao(descricao);
        setValorMinimo(valorMinimo);
    }

    @Override
    public TipoProduto getTipo() {
        return TIPO_PRODUTO;
    }
}
