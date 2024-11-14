package br.fsa.faculdade;

import java.util.List;

// Classe representando um curso, contendo informações como nome, matérias associadas e um código único
public class Curso {
    // Nome do curso
    private String nome; 

    // Lista de matérias associadas ao curso
    protected List<String> materias;

    // Código único identificador do curso
    protected int codigoUnico;

    // Construtor padrão, utilizado para criar um curso sem inicializar os atributos
    public Curso() {
    }

    // Construtor que inicializa o curso apenas com o nome
    public Curso(String nome) {
        this.nome = nome;
    }

    // Construtor que inicializa todos os atributos do curso
    public Curso(String nome, List<String> materias, int codigoUnico) {
        this.nome = nome;
        this.materias = materias;
        this.codigoUnico = codigoUnico;
    }

    // Getter para o atributo nome
    public String getNome() {
        return nome;
    }

    // Setter para o atributo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o atributo materias, retornando a lista de matérias do curso
    public List<String> getMaterias() {
        return materias;
    }

    // Setter para o atributo materias, permitindo alterar a lista de matérias do curso
    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    // Getter para o atributo codigoUnico, retornando o identificador único do curso
    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Setter para o atributo codigoUnico, permitindo alterar o identificador único do curso
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
