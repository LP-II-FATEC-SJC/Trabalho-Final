package app.models.entities.produtos.imoveis;

import app.models.entities.produtos.Produto;
import app.utils.Tipo;

public abstract class Imovel implements Produto {
    private static final Tipo tipo = Tipo.IMOVEL;
    public Tipo getTipo() {
        return tipo;
    }
}
