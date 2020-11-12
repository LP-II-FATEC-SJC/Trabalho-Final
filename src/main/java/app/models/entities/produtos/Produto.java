package app.models.entities.produtos;

import app.models.entities.Leilao;
import app.utils.Tipo;

public interface Produto {
    void setLeilao();
    Leilao getLeilao();
    Tipo getTipo();
}
