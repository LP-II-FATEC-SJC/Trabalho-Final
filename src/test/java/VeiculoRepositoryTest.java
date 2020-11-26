import app.models.entities.produtos.veiculos.TipoVeiculo;
import app.models.entities.produtos.veiculos.Veiculo;
import app.models.repositories.VeiculoRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoRepositoryTest {

    VeiculoRepository veiculoRepository = new VeiculoRepository();

    @Test
    void validarAdicao() {
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v);
        assertEquals(veiculoRepository.getEntidadeById(0), v);
    }

    @Test
    void validarUpdate() {
        Veiculo v = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v);
        Veiculo esperado = new Veiculo(TipoVeiculo.MOTOCICLETA, "sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO, "test");
        esperado.setId(0);
        veiculoRepository.add(esperado);
        Veiculo res = (Veiculo) veiculoRepository.getEntidadeById(0);
        assertEquals(esperado.getDescricao(), res.getDescricao());
        assertEquals(esperado.getId(), res.getId());
        assertEquals(esperado.getQuantidade(), res.getQuantidade());
        assertEquals(esperado.getRecinto(), res.getRecinto());
        assertEquals(esperado.getTipo(), res.getTipo());
        assertEquals(esperado.getTipoVeiculo(), res.getTipoVeiculo());
        assertEquals(esperado.getUnidade(), res.getUnidade());
        assertEquals(esperado.getValorMinimo(), res.getValorMinimo());
        assertEquals(esperado.getNome(), res.getNome());
    }

    @Test
    void validarDelete() {
        Veiculo v1 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v1);
        veiculoRepository.add(v2);
        veiculoRepository.add(v3);
        veiculoRepository.delete(1);
        assertNull(veiculoRepository.getEntidadeById(1));
        assertNotNull(veiculoRepository.getEntidadeById(0));
        assertNotNull(veiculoRepository.getEntidadeById(2));
    }

    @Test
    void validarContador() {
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        assertEquals(0, (int) veiculoRepository.getContador());
        veiculoRepository.delete(1);
        assertEquals(0, (int) veiculoRepository.getContador());
        veiculoRepository.add(v3);
        assertEquals(1, (int) veiculoRepository.getContador());
    }

    @Test
    void validarListaVeiculos() {
        List<Veiculo> esperado = new ArrayList<>();
        Veiculo v0 = new Veiculo(TipoVeiculo.MOTOCICLETA, "sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO, "test");
        Veiculo v1 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v4 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        Veiculo v5 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
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
        List<Veiculo> res = veiculoRepository.getEntidades();
        for (int i = 0; i<res.size(); i++) {
            assertEquals(esperado.get(i).getDescricao(), res.get(i).getDescricao());
            assertEquals(esperado.get(i).getId(), res.get(i).getId());
            assertEquals(esperado.get(i).getQuantidade(), res.get(i).getQuantidade());
            assertEquals(esperado.get(i).getRecinto(), res.get(i).getRecinto());
            assertEquals(esperado.get(i).getTipo(), res.get(i).getTipo());
            assertEquals(esperado.get(i).getTipoVeiculo(), res.get(i).getTipoVeiculo());
            assertEquals(esperado.get(i).getUnidade(), res.get(i).getUnidade());
            assertEquals(esperado.get(i).getValorMinimo(), res.get(i).getValorMinimo());
            assertEquals(esperado.get(i).getNome(), res.get(i).getNome());
        }
    }

    @Test
    void testGetEntidades() {
        List<Veiculo> esperado = new ArrayList<>();
        Veiculo v1 = new Veiculo(TipoVeiculo.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v3 = new Veiculo(TipoVeiculo.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v1);
        veiculoRepository.add(v2);
        veiculoRepository.add(v3);
        esperado.add(v1);
        esperado.add(v2);
        esperado.add(v3);
        List<Veiculo> res = veiculoRepository.getEntidades();
        for (int i = 0; i < res.size(); i++) {
            Veiculo v = res.get(i);
            assertEquals(v, esperado.get(i));
        }
    }
}
