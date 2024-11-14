package br.fsa.pessoa;

import java.util.Date;
import java.util.List;

// Classe Professor, que herda atributos e métodos da classe Pessoa e adiciona características específicas de um professor
public class Professor extends Pessoa {
    // Lista de matérias que o professor leciona
    protected List<String> materias;

    // Código único identificador do professor
    protected int codigoUnico;

    // Construtor padrão, utilizado para criar um objeto Professor sem inicializar atributos
    public Professor() {
    }

    // Construtor que inicializa todos os atributos do professor, incluindo os herdados da classe Pessoa
    public Professor(String nome, Date dataNascimento, String endereco, String cep, String rua, String numero,
                     String cidade, String estado, String telefone, String genero, String rg, String cpf,
                     List<String> materias, int codigoUnico) {
        // Inicializa os atributos herdados da classe Pessoa
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.genero = genero;
        this.rg = rg;
        this.cpf = cpf;

        // Inicializa os atributos específicos da classe Professor
        this.materias = materias;
        this.codigoUnico = codigoUnico;
    }

    // Getter para a lista de matérias que o professor leciona
    public List<String> getMaterias() {
        return this.materias;
    }

    // Setter para a lista de matérias que o professor leciona
    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    // Getter para o código único do professor
    public int getCodigoUnico() {
        return this.codigoUnico;
    }

    // Setter para o código único do professor
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    // Método sobrescrito toString para retornar uma representação textual dos dados do professor
    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", genero='" + genero + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", materias=" + materias +
                ", codigoUnico=" + codigoUnico +
                '}';
    }
}
