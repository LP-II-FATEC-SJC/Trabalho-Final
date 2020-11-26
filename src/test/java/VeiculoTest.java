import app.models.entities.Cliente;
import app.models.entities.Lance;
import app.models.entities.produtos.veiculos.TipoVeiculo;
import app.models.entities.produtos.veiculos.Veiculo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void testAddLance() {
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        v.addLance(new Lance(new Cliente(), BigDecimal.ONE));
        List<Lance> lances = v.getLances();
        Lance expectedLance = new Lance(new Cliente(), BigDecimal.ONE);
        expectedLance.setId(0);
        assertEquals(1, v.getQtdLances());
        assertEquals(expectedLance.getCliente().getId(), lances.get(0).getCliente().getId());
        assertEquals(expectedLance.getId(), lances.get(0).getId());
        assertEquals(expectedLance.getValor(), lances.get(0).getValor());
    }

    @Test
    void testToString() {
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        String res = v.toString();
        String expectedString = "Veiculo{" +
                "id=" + "null" +
                ", tipoVeiculo=" + "CARRO" +
                ", recinto='" + "test" + '\'' +
                ", quantidade=" + 1 +
                ", unidade='" + "test" + '\'' +
                ", descricao='" + "test" + '\'' +
                ", valorMinimo=" + 1 +
                ", nome='" + "test" + '\'' +
                ", qtdLances=" + 0 +
                ", lances=" + "[]" +
                '}';
        assertEquals(expectedString, res);
    }
}
