package app.models.entities.produtos.veiculos;

import app.models.entities.Lance;
import app.models.entities.produtos.IProduto;
import app.utils.enums.TipoProdutoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Veiculo implements IProduto {
    private static final TipoProdutoEnum TIPO_PRODUTO = TipoProdutoEnum.VEICULO;
    private Integer id;
    private TipoVeiculoEnum tipoVeiculo;
    private String recinto;
    private Integer quantidade;
    private String unidade;
    private String descricao;
    private BigDecimal valorMinimo;
    private String nome;
    private Integer qtdLances;
    private List<Lance> lances;

    public Veiculo(@NonNull TipoVeiculoEnum tipoVeiculo,
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
        lances = new ArrayList<>();
    }


    public Veiculo(@NonNull Integer id,
                   @NonNull TipoVeiculoEnum tipoVeiculo,
                   @NonNull String recinto,
                   @NonNull Integer quantidade,
                   @NonNull String unidade,
                   @NonNull String descricao,
                   @NonNull BigDecimal valorMinimo,
                   @NonNull String nome)
    {
        setId(id);
        setTipoVeiculo(tipoVeiculo);
        setRecinto(recinto);
        setQuantidade(quantidade);
        setUnidade(unidade);
        setDescricao(descricao);
        setValorMinimo(valorMinimo);
        setNome(nome);
    }

    @Override
    public TipoProdutoEnum getTipo() {
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

    public void update(Veiculo v) {
        setNome(v.getNome());
        setValorMinimo(v.getValorMinimo());
        setDescricao(v.getDescricao());
        setUnidade(v.getUnidade());
        setQuantidade(v.getQuantidade());
        setRecinto(v.getRecinto());
        setTipoVeiculo(v.getTipoVeiculo());
    }
}
