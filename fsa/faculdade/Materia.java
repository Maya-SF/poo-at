package br.fsa.faculdade;

// Classe representando uma matéria, com código único e nome
public class Materia {
    // Código único identificador da matéria
    private int codigoUnico;

    // Nome da matéria
    private String nome;

    // Variável estática para gerar códigos únicos de forma incremental
    private static int proximoCodigo = 1;

    // Construtor que inicializa a matéria com o nome e gera automaticamente o código único
    public Materia(String nome) {
        this.codigoUnico = proximoCodigo++; // Incrementa o próximo código único
        this.nome = nome;
    }

    // Getter para o código único da matéria
    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Getter para o nome da matéria
    public String getNome() {
        return nome;
    }

    // Método sobrescrito para retornar uma representação textual da matéria
    @Override
    public String toString() {
        // Exibe o código único e o nome da matéria
        return "Código: " + codigoUnico + " | Nome: " + nome;
    }
}
