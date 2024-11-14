package br.fsa.faculdade;

import br.fsa.pessoa.Aluno;

// Classe representando uma nota, associada a um aluno e uma matéria, com valores para provas e trabalho
public class Nota {
    // Aluno ao qual a nota está vinculada
    protected Aluno aluno;

    // Matéria à qual a nota está associada
    protected Materia materia;

    // Nota da Prova 1
    protected double p1;

    // Nota da Prova 2
    protected double p2;

    // Nota do Trabalho
    protected double trabalho;

    // Construtor padrão, utilizado para criar um objeto Nota sem inicializar atributos
    public Nota() {
    }

    // Construtor que inicializa todos os atributos da classe Nota
    public Nota(Aluno aluno, Materia materia, double p1, double p2, double trabalho) {
        this.aluno = aluno;          // Define o aluno associado
        this.materia = materia;      // Define a matéria associada
        this.p1 = p1;                // Define a nota da Prova 1
        this.p2 = p2;                // Define a nota da Prova 2
        this.trabalho = trabalho;    // Define a nota do Trabalho
    }

    // Getter para o atributo aluno, retornando o aluno associado à nota
    public Aluno getAluno() {
        return aluno;
    }

    // Setter para o atributo aluno, permitindo alterar o aluno associado
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    // Getter para o atributo materia, retornando a matéria associada à nota
    public Materia getMateria() {
        return materia;
    }

    // Setter para o atributo materia, permitindo alterar a matéria associada
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // Getter para a nota da Prova 1
    public double getP1() {
        return p1;
    }

    // Setter para a nota da Prova 1
    public void setP1(double p1) {
        this.p1 = p1;
    }

    // Getter para a nota da Prova 2
    public double getP2() {
        return p2;
    }

    // Setter para a nota da Prova 2
    public void setP2(double p2) {
        this.p2 = p2;
    }

    // Getter para a nota do Trabalho
    public double getTrabalho() {
        return trabalho;
    }

    // Setter para a nota do Trabalho
    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }
}
