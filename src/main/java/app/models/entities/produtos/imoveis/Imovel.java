package app.models.entities.produtos.imoveis;

import app.models.entities.Entidade;
import app.models.entities.Lance;
import app.models.entities.produtos.Produto;
import app.utils.enums.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Imovel implements Produto, Entidade {
    private static final TipoProduto TIPO_PRODUTO = TipoProduto.IMOVEL;
    private Integer id;
    private TipoImovel tipoImovel;

    public TipoProduto getTipo() {
        return TIPO_PRODUTO;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public BigDecimal getValorMinimo() {
        return null;
    }

    @Override
    public Integer getQtdLances() {
        return null;
    }

    @Override
    public List<Lance> getLances() {
        return null;
    }

    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public void addLance(Lance lance) {

    }
}
