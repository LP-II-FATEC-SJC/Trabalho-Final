package app.models.entities;

import app.models.entities.produtos.Produto;
import app.utils.enums.StatusLeilao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Leilao implements Entidade {
    private Integer id;
    private LocalDateTime dataOcorrencia;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Produto> produtos;
    private LocalTime inicioLocalTime;
    private LocalTime fimLocalTime;
    private StatusLeilao status;
    private String detalhes;
    private Instituicao instituicaoFinanceira;

    public Leilao (LocalDateTime dataOcorrencia, String local, String endereco, String cidade, String estado,
                   LocalTime inicioLocalTime, LocalTime fimLocalTime, String detalhes, Instituicao instituicaoFinanceira) {
        setDataOcorrencia(dataOcorrencia);
        setLocal(local);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
        setInicioLocalTime(inicioLocalTime);
        setFimLocalTime(fimLocalTime);
        setDetalhes(detalhes);
        setProdutos(new ArrayList<>());
        setInstituicaoFinanceira(instituicaoFinanceira);
        updateStatusLeilao();
    }

    public StatusLeilao getStatus() {
        updateStatusLeilao();
        return status;
    }

    private void updateStatusLeilao() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        if(now.isBefore(getDataOcorrencia())) {
            setStatus(StatusLeilao.EM_ABERTO);
        } else if(
                now.getYear() == getDataOcorrencia().getYear() &&
                now.getMonth() == getDataOcorrencia().getMonth() &&
                now.getDayOfMonth() == getDataOcorrencia().getDayOfMonth()
        ) {
            if(now.toLocalTime().isBefore(getInicioLocalTime())) {
                setStatus(StatusLeilao.EM_ABERTO);
            } else if(now.toLocalTime().isAfter(getInicioLocalTime()) || now.toLocalTime().equals(getInicioLocalTime())) {
                if(now.toLocalTime().isBefore(getFimLocalTime())) {
                    setStatus(StatusLeilao.EM_ANDAMENTO);
                } else {
                    setStatus(StatusLeilao.FINALIZADO);
                }
            }
        } else {
            setStatus(StatusLeilao.FINALIZADO);
        }
    }

    @Override
    public String toString() {
        return "Leilao{" +
                "id=" + getId() +
                ", dataOcorrencia=" + getDataOcorrencia() +
                ", local='" + getLocal() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", produtos=" + getProdutos() +
                ", inicioLocalTime=" + getInicioLocalTime() +
                ", fimLocalTime=" + getFimLocalTime() +
                ", status=" + getStatus() +
                ", detalhes='" + getDetalhes() + '\'' +
                '}';
    }
}
