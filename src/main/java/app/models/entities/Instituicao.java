package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Instituicao implements IEntidade {
    private Integer id;
    private String cnpj;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private Integer telefone;
    private String emailContato;

    public Instituicao(String cnpj, String nome, String endereco, String cidade, String estado, Integer telefone, String emailContato) {
        setCnpj(cnpj);
        setNome(nome);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
        setTelefone(telefone);
        setEmailContato(emailContato);
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "id=" + getId() +
                ", cnpj='" + getCnpj() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", telefone=" + getTelefone() +
                ", emailContato='" + getEmailContato() + '\'' +
                '}';
    }

    public void update(Instituicao i) {
        setEmailContato(i.getEmailContato());
        setTelefone(i.getTelefone());
        setEstado(i.getEstado());
        setCidade(i.getCidade());
        setEndereco(i.getEndereco());
        setNome(i.getNome());
        setCnpj(i.getCnpj());
    }
}
