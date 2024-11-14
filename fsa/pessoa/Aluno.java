package br.fsa.pessoa;

import java.util.Date;

// Classe Aluno, que herda atributos e métodos da classe Pessoa e adiciona características específicas de um aluno
public class Aluno extends Pessoa {
    // Curso no qual o aluno está matriculado
    protected String curso;

    // Código único identificador do aluno
    protected int codigoUnico;

    // Construtor padrão, utilizado para criar um objeto Aluno sem inicializar atributos
    public Aluno() {
    }

    // Construtor que inicializa todos os atributos do aluno, incluindo os herdados da classe Pessoa
    public Aluno(String nome, Date dataNascimento, String endereco, String cep, String rua, String numero, 
                 String cidade, String estado, String telefone, String genero, String rg, String cpf, 
                 String curso, int codigoUnico) {
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
        
        // Inicializa os atributos específicos da classe Aluno
        this.curso = curso;
        this.codigoUnico = codigoUnico;
    }

    // Getter para o atributo curso, que retorna o curso no qual o aluno está matriculado
    public String getCurso() {
        return curso;
    }

    // Setter para o atributo curso, permitindo alterar o curso do aluno
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Getter para o atributo codigoUnico, que retorna o identificador único do aluno
    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Setter para o atributo codigoUnico, permitindo alterar o identificador único do aluno
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
