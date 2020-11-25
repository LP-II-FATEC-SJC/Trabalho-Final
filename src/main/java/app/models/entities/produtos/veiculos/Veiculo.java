package app.models.entities.produtos.veiculos;

import app.models.entities.Lance;
import app.models.entities.produtos.Produto;
import app.utils.TipoProduto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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
    private String nome;
    private Integer qtdLances;
    private List<Lance> lances;

    public Veiculo(@NonNull TipoVeiculo tipoVeiculo,
                   @NonNull String recinto,
                   @NonNull Integer quantidade,
                   @NonNull String unidade,
                   @NonNull String descricao,
                   @NonNull BigDecimal valorMinimo,
                   @NonNull String nome)
    {
        setTipoVeiculo(tipoVeiculo);
        setRecinto(recinto);
        setQuantidade(quantidade);
        setUnidade(unidade);
        setDescricao(descricao);
        setValorMinimo(valorMinimo);
        setNome(nome);
        setQtdLances(0);
    }

    @Override
    public TipoProduto getTipo() {
        return TIPO_PRODUTO;
    }

    @Override
    public void addLance(Lance lance) {
        lance.setId(qtdLances);
        lances.add(lance);
        qtdLances++;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", tipoVeiculo=" + tipoVeiculo +
                ", recinto='" + recinto + '\'' +
                ", quantidade=" + quantidade +
                ", unidade='" + unidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorMinimo=" + valorMinimo +
                ", nome='" + nome + '\'' +
                ", qtdLances=" + qtdLances +
                ", lances=" + lances +
                '}';
    }
}
