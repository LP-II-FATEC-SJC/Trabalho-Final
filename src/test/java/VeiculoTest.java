import app.models.entities.Cliente;
import app.models.entities.Lance;
import app.models.entities.produtos.IProduto;
import app.models.entities.produtos.veiculos.TipoVeiculoEnum;
import app.models.entities.produtos.veiculos.Veiculo;
import app.models.repositories.BaseRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    BaseRepository<IProduto> veiculoRepository = new BaseRepository<>();

    @Test
    void validarAdicao() {
        Veiculo v = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v);
        assertEquals(veiculoRepository.getEntidadeById(0), v);
    }

    @Test
    void validarUpdate() {
        Veiculo v = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v);
        Veiculo esperado = new Veiculo(0, TipoVeiculoEnum.MOTOCICLETA,"sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO, "test");
        veiculoRepository.add(esperado);
        IProduto res = veiculoRepository.getEntidadeById(0);
        assertEquals(esperado.getId(), res.getId());
        assertEquals(esperado.getNome(), res.getNome());
        assertEquals(esperado.getTipo(), res.getTipo());
        assertEquals(new ArrayList<>(), res.getLances());
        assertEquals(esperado.getDescricao(), res.getDescricao());
        assertEquals(0, res.getQtdLances());
        assertEquals(esperado.getValorMinimo(), res.getValorMinimo());
    }

    @Test
    void validarDelete() {
        Veiculo v1 = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v3 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
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
        Veiculo v3 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        assertEquals(0, (int) veiculoRepository.getContador());
        veiculoRepository.delete(1);
        assertEquals(0, (int) veiculoRepository.getContador());
        veiculoRepository.add(v3);
        assertEquals(1, (int) veiculoRepository.getContador());
    }

    @Test
    void validarListaVeiculos() {
        List<Veiculo> esperado = new ArrayList<>();
        Veiculo v0 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "sobrescrito", 2, "sobrescrito", "sobrescrito", BigDecimal.ZERO, "test");
        Veiculo v1 = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v3 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v4 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        Veiculo v5 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
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
        List<IProduto> res = veiculoRepository.getEntidades();
        for (int i = 0; i<res.size(); i++) {
            assertEquals(esperado.get(i).getId(), res.get(i).getId());
            assertEquals(esperado.get(i).getNome(), res.get(i).getNome());
            assertEquals(esperado.get(i).getTipo(), res.get(i).getTipo());
            assertEquals(esperado.get(i).getLances(), res.get(i).getLances());
            assertEquals(esperado.get(i).getQtdLances(), res.get(i).getQtdLances());
            assertEquals(esperado.get(i).getDescricao(), res.get(i).getDescricao());
            assertEquals(esperado.get(i).getValorMinimo(), res.get(i).getValorMinimo());
        }
    }

    @Test
    void testGetEntidades() {
        List<Veiculo> esperado = new ArrayList<>();
        Veiculo v1 = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.TEN, "test");
        Veiculo v2 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 1, "test", "test", BigDecimal.ONE, "test");
        Veiculo v3 = new Veiculo(TipoVeiculoEnum.MOTOCICLETA, "test", 10, "test", "test", BigDecimal.ONE, "test");
        veiculoRepository.add(v1);
        veiculoRepository.add(v2);
        veiculoRepository.add(v3);
        esperado.add(v1);
        esperado.add(v2);
        esperado.add(v3);
        List<IProduto> res = veiculoRepository.getEntidades();
        for (int i = 0; i < res.size(); i++) {
            Veiculo v = (Veiculo) res.get(i);
            assertEquals(v, esperado.get(i));
        }
    }

    @Test
    void testAddLance() {
        Veiculo v = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
        v.addLance(new Lance(new Cliente("0", "test", "test"), BigDecimal.ONE));
        List<Lance> lances = v.getLances();
        Lance expectedLance = new Lance(new Cliente("0", "test", "test"), BigDecimal.ONE);
        expectedLance.setId(0);
        assertEquals(1, v.getQtdLances());
        assertEquals(expectedLance.getCliente().getId(), lances.get(0).getCliente().getId());
        assertEquals(expectedLance.getCliente().getCodigoAcesso(), lances.get(0).getCliente().getCodigoAcesso());
        assertEquals(expectedLance.getCliente().getNDocumento(), lances.get(0).getCliente().getNDocumento());
        assertEquals(expectedLance.getCliente().getSenha(), lances.get(0).getCliente().getSenha());
        assertEquals(expectedLance.getCliente().toString(), lances.get(0).getCliente().toString());
        assertEquals(expectedLance.getId(), lances.get(0).getId());
        assertEquals(expectedLance.getValor(), lances.get(0).getValor());
    }

    @Test
    void testToString() {
        Veiculo v = new Veiculo(TipoVeiculoEnum.CARRO, "test", 1, "test", "test", BigDecimal.ONE, "test");
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
