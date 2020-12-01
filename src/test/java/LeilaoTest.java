import app.models.entities.Instituicao;
import app.models.entities.Leilao;
import app.models.entities.produtos.imoveis.Imovel;
import app.models.entities.produtos.imoveis.TipoImovelEnum;
import app.utils.enums.StatusLeilaoEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeilaoTest {

    @Test
    void getStatusLeilaoTest() {
        Leilao l = new Leilao(LocalDateTime.now(), "local", "endereco", "cidade", "estado",
                LocalTime.now(), LocalTime.now(), "detalhes", new
                Instituicao("00000000000000", "nome", "endereco", "cidade", "estado",
                20102010, "email@contato.com.br"));
        assertEquals(StatusLeilaoEnum.FINALIZADO, l.getStatus());
    }

    @Test
    void leilaoToStringTest() {
        Leilao l = new Leilao(LocalDateTime.of(LocalDate.of(1990, 10,20),
                LocalTime.of(0,0,0)), "local", "endereco", "cidade", "estado",
                LocalTime.of(0,0,0), LocalTime.of(0,0,0), "detalhes", new
                Instituicao("00000000000000", "nome", "endereco", "cidade", "estado",
                20102010, "email@contato.com.br"));
        l.getProdutos().add(new Imovel(1, TipoImovelEnum.APARTAMENTO, "nome", BigDecimal.ONE, 0, new ArrayList<>(), "descricao"));
        String s = l.toString();
        String expectedString = "Leilao{" +
                "id=" + "null" +
                ", dataOcorrencia=" + "1990-10-20T00:00" +
                ", local='" + "local" + '\'' +
                ", endereco='" + "endereco" + '\'' +
                ", cidade='" + "cidade" + '\'' +
                ", estado='" + "estado" + '\'' +
                ", produtos=" + "[Imovel{id=1, tipoImovel=APARTAMENTO, nome='nome', valorMinimo=1, qtdLances=0, lances=[], descricao='descricao', tipo=IMOVEL}]" +
                ", inicioLocalTime=" + "00:00" +
                ", fimLocalTime=" + "00:00" +
                ", status=" + "FINALIZADO" +
                ", detalhes='" + "detalhes" + '\'' +
                ", instituicaoFinanceira='Instituicao" +
                    "{" +
                    "id=null" +
                    ", cnpj='00000000000000'" +
                    ", nome='nome'" +
                    ", endereco='endereco'" +
                    ", cidade='cidade'" +
                    ", estado='estado'" +
                    ", telefone=20102010" +
                    ", emailContato='email@contato.com.br" +
                    "'}" +
                "'}";
        assertEquals(expectedString, s);
    }

    @Test
    void statusEmAbertoTest() {
        Instituicao res = new Instituicao("00000000000000", "nome", "endereco", "cidade", "estado",
                40028922, "email@contato.com.br");
        Leilao nowIsBeforeDataOcorrencia = new Leilao(LocalDateTime.of(LocalDate.of(LocalDate.now().getYear() + 1, 10,20),
                LocalTime.of(0,0,0)), "local", "endereco", "cidade", "estado",
                LocalTime.of(0,0,0), LocalTime.of(0,0,0), "detalhes", res);

        Leilao nowIsEqualDataOcorrenciaAndBeforeInicioLocalTime = new Leilao(LocalDateTime.of(LocalDate.now(),
                LocalTime.now()), "local", "endereco", "cidade", "estado",
                LocalTime.now().plusSeconds(1), LocalTime.now().plusSeconds(2), "detalhes", res);

        Leilao emAndamento = new Leilao(LocalDateTime.of(LocalDate.now(),
                LocalTime.now()), "local", "endereco", "cidade", "estado",
                LocalTime.now().minusSeconds(10), LocalTime.now().plusSeconds(2), "detalhes", res);

        String expectedString = "Instituicao{" +
                "id=" + null +
                ", cnpj='" + "00000000000000" + '\'' +
                ", nome='" + "nome" + '\'' +
                ", endereco='" + "endereco" + '\'' +
                ", cidade='" + "cidade" + '\'' +
                ", estado='" + "estado" + '\'' +
                ", telefone=" + "40028922" +
                ", emailContato='" + "email@contato.com.br" + '\'' +
                '}';
        assertEquals(StatusLeilaoEnum.EM_ABERTO, nowIsBeforeDataOcorrencia.getStatus());
        assertEquals(StatusLeilaoEnum.EM_ABERTO, nowIsEqualDataOcorrenciaAndBeforeInicioLocalTime.getStatus());
        assertEquals(StatusLeilaoEnum.EM_ANDAMENTO, emAndamento.getStatus());
        assertEquals(expectedString, res.toString());
    }
}
