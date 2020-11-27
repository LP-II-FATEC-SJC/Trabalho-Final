package app.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente implements Entidade {
    private Integer id;
    private Integer nDocumento; //CPF ou CNPJ
    private String codigoAcesso;
    private String senha;

    public Cliente(Integer nDocumento, String codigoAcesso, String senha) {
        setNDocumento(nDocumento);
        setCodigoAcesso(codigoAcesso);
        setSenha(senha);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nDocumento=" + getNDocumento() +
                ", codigoAcesso='" + getCodigoAcesso() + '\'' +
                ", senha='" + getSenha() + '\'' +
                '}';
    }
}
