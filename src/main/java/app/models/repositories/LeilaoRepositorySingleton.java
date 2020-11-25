package app.models.repositories;

import app.models.entities.Leilao;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LeilaoRepositorySingleton {
    private static LeilaoRepositorySingleton singleInstance = null;
    private final List<Leilao> leiloes;
    private Integer contador;

    private LeilaoRepositorySingleton() {
        leiloes = new ArrayList<>();
        contador = 0;
    }

    public static LeilaoRepositorySingleton getInstance() {
        if(singleInstance == null)
            singleInstance = new LeilaoRepositorySingleton();

        return singleInstance;
    }

    public Leilao getLeilaoById(Integer id) {
        for (Leilao leilao : leiloes) {
            if (leilao.getId().equals(id)) {
                return leilao;
            }
        }
        return null;
    }

    public void add(Leilao leilao) {
        leilao.setId(contador);
        contador++;
        leiloes.add(leilao);
    }

    public void delete(Integer id) {
        for (Leilao leilao : leiloes) {
            if (leilao.getId().equals(id)) {
                leiloes.remove(leilao);
                break;
            }
        }
    }

    public void update(Leilao leilao) {
        for (Leilao l : leiloes) {
            if(l.getId().equals(leilao.getId())) {
                l.setDetalhes(leilao.getDetalhes());
                l.setFimDataHora(leilao.getFimDataHora());
                l.setInicioDataHora(leilao.getInicioDataHora());
                l.setCidade(leilao.getCidade());
                l.setEndereco(leilao.getEndereco());
                l.setLocal(leilao.getLocal());
                l.setDataOcorrencia(leilao.getDataOcorrencia());
                break;
            }
        }
    }
}
