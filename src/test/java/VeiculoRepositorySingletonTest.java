import app.models.entities.produtos.veiculos.TipoVeiculo;
import app.models.entities.produtos.veiculos.Veiculo;
import app.models.repositories.VeiculoRepositorySingleton;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VeiculoRepositorySingletonTest {

    @Test
    @Order(1)
    void validarSingleton() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        VeiculoRepositorySingleton esperado = VeiculoRepositorySingleton.getInstance();
        assertEquals(veiculoRepositorySingleton, esperado);
    }

    @Test
    @Order(2)
    void validarAdicao() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE);
        veiculoRepositorySingleton.add(v);
        assertEquals(veiculoRepositorySingleton.getVeiculoById(0), v);
    }

    @Test
    @Order(3)
    void validarUpdate() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE);
        veiculoRepositorySingleton.add(v);
        Veiculo esperado = new Veiculo(TipoVeiculo.MOTOCICLETA, "sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO);
        esperado.setId(0);
        veiculoRepositorySingleton.update(esperado);
        Veiculo res = veiculoRepositorySingleton.getVeiculoById(0);
        assertEquals(esperado.getDescricao(), res.getDescricao());
        assertEquals(esperado.getId(), res.getId());
        assertEquals(esperado.getQuantidade(), res.getQuantidade());
        assertEquals(esperado.getRecinto(), res.getRecinto());
        assertEquals(esperado.getTipo(), res.getTipo());
        assertEquals(esperado.getTipoVeiculo(), res.getTipoVeiculo());
        assertEquals(esperado.getUnidade(), res.getUnidade());
        assertEquals(esperado.getValorMinimo(), res.getValorMinimo());
    }

    @Test
    @Order(4)
    void validarDelete() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        Veiculo v1 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN);
        Veiculo v2 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE);
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE);
        veiculoRepositorySingleton.add(v1);
        veiculoRepositorySingleton.add(v2);
        veiculoRepositorySingleton.add(v3);
        veiculoRepositorySingleton.delete(1);
        assertNull(veiculoRepositorySingleton.getVeiculoById(1));
        assertNotNull(veiculoRepositorySingleton.getVeiculoById(0));
        assertNotNull(veiculoRepositorySingleton.getVeiculoById(2));
        assertNotNull(veiculoRepositorySingleton.getVeiculoById(3));
    }

    @Test
    @Order(5)
    void validarContador() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE);
        assertEquals(5, (int) veiculoRepositorySingleton.getContador());
        veiculoRepositorySingleton.delete(1);
        assertEquals(5, (int) veiculoRepositorySingleton.getContador());
        veiculoRepositorySingleton.add(v3);
        assertEquals(6, (int) veiculoRepositorySingleton.getContador());
    }

    @Test
    @Order(6)
    void validarListaVeiculos() {
        VeiculoRepositorySingleton veiculoRepositorySingleton = VeiculoRepositorySingleton.getInstance();
        List<Veiculo> esperado = new ArrayList<>();
        Veiculo v0 = new Veiculo(TipoVeiculo.MOTOCICLETA, "sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO);
        Veiculo v1 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN);
        Veiculo v2 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN);
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE);
        Veiculo v4 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE);
        Veiculo v5 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE);
        v0.setId(0);
        esperado.add(v0);
        v1.setId(1);
        esperado.add(v1);
        v2.setId(2);
        esperado.add(v2);
        v3.setId(3);
        esperado.add(v3);
        esperado.remove(1);
        v4.setId(4);
        esperado.add(v4);
        v5.setId(5);
        esperado.add(v5);
        List<Veiculo> res = veiculoRepositorySingleton.getVeiculos();
        for (int i = 0; i<res.size(); i++) {
            assertEquals(esperado.get(i).getDescricao(), res.get(i).getDescricao());
            assertEquals(esperado.get(i).getId(), res.get(i).getId());
            assertEquals(esperado.get(i).getQuantidade(), res.get(i).getQuantidade());
            assertEquals(esperado.get(i).getRecinto(), res.get(i).getRecinto());
            assertEquals(esperado.get(i).getTipo(), res.get(i).getTipo());
            assertEquals(esperado.get(i).getTipoVeiculo(), res.get(i).getTipoVeiculo());
            assertEquals(esperado.get(i).getUnidade(), res.get(i).getUnidade());
            assertEquals(esperado.get(i).getValorMinimo(), res.get(i).getValorMinimo());
        }
    }
}
