package app.models.entities;

import app.models.entities.produtos.IProduto;
import app.utils.enums.StatusLeilaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Leilao implements IEntidade {
    private Integer id;
    private LocalDateTime dataOcorrencia;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;
    private List<IProduto> produtos;
    private LocalTime inicioLocalTime;
    private LocalTime fimLocalTime;
    private StatusLeilaoEnum status;
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

    public Leilao (Integer id, LocalDateTime dataOcorrencia, String local, String endereco, String cidade, String estado,
                   LocalTime inicioLocalTime, LocalTime fimLocalTime, String detalhes, Instituicao instituicaoFinanceira) {
        setId(id);
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

    public StatusLeilaoEnum getStatus() {
        updateStatusLeilao();
        return status;
    }

    private void updateStatusLeilao() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        if(now.isBefore(getDataOcorrencia())) {
            setStatus(StatusLeilaoEnum.EM_ABERTO);
        } else if(
                now.getYear() == getDataOcorrencia().getYear() &&
                now.getMonth() == getDataOcorrencia().getMonth() &&
                now.getDayOfMonth() == getDataOcorrencia().getDayOfMonth()
        ) {
            if(now.toLocalTime().isBefore(getInicioLocalTime())) {
                setStatus(StatusLeilaoEnum.EM_ABERTO);
            } else if(now.toLocalTime().isAfter(getInicioLocalTime()) || now.toLocalTime().equals(getInicioLocalTime())) {
                if(now.toLocalTime().isBefore(getFimLocalTime())) {
                    setStatus(StatusLeilaoEnum.EM_ANDAMENTO);
                } else {
                    setStatus(StatusLeilaoEnum.FINALIZADO);
                }
            }
        } else {
            setStatus(StatusLeilaoEnum.FINALIZADO);
        }
    }

    @Override
    public String toString() {
        setProdutos(produtos.stream().sorted(Comparator.comparing(IProduto::getNome)).collect(Collectors.toList()));
        return "Leilao{" +
                "id=" + getId() +
                ", dataOcorrencia=" + getDataOcorrencia() +
                ", local='" + getLocal() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", produtos=" + getProdutos().toString() +
                ", inicioLocalTime=" + getInicioLocalTime() +
                ", fimLocalTime=" + getFimLocalTime() +
                ", status=" + getStatus() +
                ", detalhes='" + getDetalhes() + '\'' +
                ", instituicaoFinanceira='" + getInstituicaoFinanceira() + '\'' +
                '}';
    }

    public void update(Leilao l) {
        setInstituicaoFinanceira(l.getInstituicaoFinanceira());
        setEstado(l.getEstado());
        setLocal(l.getLocal());
        setEndereco(l.getEndereco());
        setCidade(l.getCidade());
        setDetalhes(l.getDetalhes());
        setDataOcorrencia(l.getDataOcorrencia());
        setFimLocalTime(l.getFimLocalTime());
        setInicioLocalTime(l.getInicioLocalTime());
    }
}
