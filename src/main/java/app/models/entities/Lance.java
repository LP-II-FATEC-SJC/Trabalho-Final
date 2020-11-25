package app.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Lance {
    private Integer id;
    private Cliente cliente;
    private BigDecimal valor;

    public Lance(Cliente cliente, BigDecimal valor) {
        setCliente(cliente);
        setValor(valor);
    }
}
