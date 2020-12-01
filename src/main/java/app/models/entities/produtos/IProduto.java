package app.models.entities.produtos;

import app.models.entities.IEntidade;
import app.models.entities.Lance;
import app.utils.enums.TipoProdutoEnum;

import java.math.BigDecimal;
import java.util.List;

public interface IProduto extends IEntidade {
    TipoProdutoEnum getTipo();
    String getNome();
    BigDecimal getValorMinimo();
    Integer getQtdLances();
    List<Lance> getLances();
    String getDescricao();
    void addLance(Lance lance);
    String toString();
}
