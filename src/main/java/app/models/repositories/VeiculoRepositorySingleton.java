package app.models.repositories;

import app.models.entities.produtos.veiculos.Veiculo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VeiculoRepositorySingleton {
    private static VeiculoRepositorySingleton singleInstance = null;
    private final List<Veiculo> veiculos;
    private Integer contador;

    private VeiculoRepositorySingleton() {
        veiculos = new ArrayList<>();
        contador = 0;
    }

    public static VeiculoRepositorySingleton getInstance()
    {
        if (singleInstance == null)
            singleInstance = new VeiculoRepositorySingleton();

        return singleInstance;
    }

    public Veiculo getVeiculoById(Integer id) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId().equals(id)) {
                return veiculo;
            }
        }
        return null;
    }

    public void add(Veiculo veiculo) {
        veiculo.setId(contador);
        contador++;
        veiculos.add(veiculo);
    }

    public void delete(Integer id) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId().equals(id)) {
                veiculos.remove(veiculo);
                break;
            }
        }
    }

    public void update(Veiculo veiculo) {
        for (Veiculo v : veiculos) {
            if(v.getId().equals(veiculo.getId())) {
                v.setDescricao(veiculo.getDescricao());
                v.setQuantidade(veiculo.getQuantidade());
                v.setRecinto(veiculo.getRecinto());
                v.setTipoVeiculo(veiculo.getTipoVeiculo());
                v.setUnidade(veiculo.getUnidade());
                v.setValorMinimo(veiculo.getValorMinimo());
                break;
            }
        }
    }
}
