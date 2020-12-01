package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cliente implements IEntidade {
    private Integer id;
    private String nDocumento; //CPF ou CNPJ
    private String codigoAcesso;
    private String senha;

    public Cliente(String nDocumento, String codigoAcesso, String senha) {
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

    public void update(Cliente c) {
        setNDocumento(c.getNDocumento());
        setCodigoAcesso(c.getCodigoAcesso());
        setSenha(c.getSenha());
    }
}
