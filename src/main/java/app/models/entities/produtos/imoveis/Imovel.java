package app.models.entities.produtos.imoveis;

import app.models.entities.produtos.Produto;
import app.utils.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Imovel implements Produto {
    private static final TipoProduto TIPO_PRODUTO = TipoProduto.IMOVEL;
    private TipoImovel tipoImovel;

    public TipoProduto getTipo() {
        return TIPO_PRODUTO;
    }
}
