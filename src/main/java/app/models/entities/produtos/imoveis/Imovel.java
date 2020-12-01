package app.models.entities.produtos.imoveis;

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

@AllArgsConstructor
@Getter
@Setter
public class Imovel implements IProduto {
    private static final TipoProdutoEnum TIPO_PRODUTO = TipoProdutoEnum.IMOVEL;
    private Integer id;
    private TipoImovelEnum tipoImovel;
    private String nome;
    private BigDecimal valorMinimo;
    private Integer qtdLances;
    private List<Lance> lances;
    private String descricao;

    public TipoProdutoEnum getTipo() {
        return TIPO_PRODUTO;
    }

    public Imovel(@NonNull TipoImovelEnum tipoImovel,
                   @NonNull String nome,
                   @NonNull BigDecimal valorMinimo,
                   @NonNull String descricao)
    {
        setTipoImovel(tipoImovel);
        setDescricao(descricao);
        setValorMinimo(valorMinimo);
        setNome(nome);
        setQtdLances(0);
        lances = new ArrayList<>();
    }


    public Imovel(@NonNull Integer id,
                  @NonNull TipoImovelEnum tipoImovel,
                  @NonNull String nome,
                  @NonNull BigDecimal valorMinimo,
                  @NonNull String descricao)
    {
        setId(id);
        setTipoImovel(tipoImovel);
        setDescricao(descricao);
        setValorMinimo(valorMinimo);
        setNome(nome);
    }

    @Override
    public void addLance(Lance lance) {
        lance.setId(qtdLances);
        lances.add(lance);
        qtdLances++;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + getId() +
                ", tipoImovel=" + getTipoImovel() +
                ", nome='" + getNome() + '\'' +
                ", valorMinimo=" + getValorMinimo() +
                ", qtdLances=" + getQtdLances() +
                ", lances=" + getLances() +
                ", descricao='" + getDescricao() + '\'' +
                ", tipo=" + getTipo() +
                '}';
    }

    public void update(Imovel i) {
        setNome(i.getNome());
        setQtdLances(i.getQtdLances());
        setValorMinimo(i.getValorMinimo());
        setDescricao(i.getDescricao());
        setLances(i.getLances());
        setTipoImovel(i.getTipoImovel());
    }
}
