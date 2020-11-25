package app.models.repositories;

import app.models.entities.produtos.imoveis.Imovel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ImovelRepositorySingleton {
    private final List<Imovel> imoveis;

    public ImovelRepositorySingleton() {
        imoveis = new ArrayList<>();
    }

}
