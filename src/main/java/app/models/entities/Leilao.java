package app.models.entities;

import app.models.entities.produtos.Produto;
import app.utils.StatusLeilao;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Leilao {
    private Integer id;
    private Date dataOcorrencia;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Produto> produtos;
    private Date inicioDataHora;
    private Date fimDataHora;
    private StatusLeilao status;
    private String detalhes;

    public Leilao (Date dataOcorrencia, String local, String endereco, String cidade, Date inicioDataHora, Date fimDataHora, String detalhes) {
        setDataOcorrencia(dataOcorrencia);
        setLocal(local);
        setEndereco(endereco);
        setCidade(cidade);
        setInicioDataHora(inicioDataHora);
        setFimDataHora(fimDataHora);
        setDetalhes(detalhes);
        produtos = new ArrayList<>();
        updateStatusLeilao();
    }

    public StatusLeilao getStatus() {
        updateStatusLeilao();
        return status;
    }

    private void updateStatusLeilao() {
        Date now = new Date(System.currentTimeMillis());
        if(now.compareTo(getDataOcorrencia()) < 0) {
            setStatus(StatusLeilao.EM_ABERTO);
        } else if(now.compareTo(getDataOcorrencia()) == 0) {
            if(now.compareTo(getInicioDataHora()) < 0) {
                setStatus(StatusLeilao.EM_ABERTO);
            } else if(now.compareTo(getInicioDataHora()) >= 0) {
                if(now.compareTo(getFimDataHora()) < 0) {
                    setStatus(StatusLeilao.EM_ANDAMENTO);
                } else {
                    setStatus(StatusLeilao.FINALIZADO);
                }
            }
        } else {
            setStatus(StatusLeilao.FINALIZADO);
        }
    }
}
