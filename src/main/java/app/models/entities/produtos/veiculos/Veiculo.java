package app.models.entities.produtos.veiculos;

import app.models.entities.produtos.Produto;
import app.utils.Tipo;

public abstract class Veiculo implements Produto {
    private static final Tipo tipo = Tipo.VEICULO;
    public Tipo getTipo() {
        return tipo;
    }
}
