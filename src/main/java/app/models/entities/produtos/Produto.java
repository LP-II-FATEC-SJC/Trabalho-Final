package app.models.entities.produtos;

import app.models.entities.Lance;
import app.utils.TipoProduto;

import java.math.BigDecimal;
import java.util.List;

public interface Produto {
    TipoProduto getTipo();
    String getNome();
    BigDecimal getValorMinimo();
    Integer getQtdLances();
    List<Lance> getLances();
    String getDescricao();
    void addLance(Lance lance);
    String toString();
}
