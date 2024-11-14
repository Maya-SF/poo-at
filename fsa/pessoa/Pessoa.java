package br.fsa.pessoa;

import java.util.Date;

// Classe abstrata Pessoa, representando uma entidade base para diferentes tipos de pessoas (e.g., Aluno, Professor)
// Contém atributos comuns a todas as pessoas, como nome, endereço, e documentos pessoais
public abstract class Pessoa {
    // Nome completo da pessoa
    protected String nome;

    // Data de nascimento da pessoa
    protected Date dataNascimento;

    // Endereço completo da pessoa
    protected String endereco;

    // Código postal (CEP) do endereço
    protected String cep;

    // Nome da rua do endereço
    protected String rua;

    // Número do endereço
    protected String numero;

    // Cidade do endereço
    protected String cidade;

    // Estado do endereço
    protected String estado;

    // Telefone de contato da pessoa
    protected String telefone;

    // Gênero da pessoa (opcionalmente usado para documentação ou relatórios)
    protected String genero;

    // Registro Geral (RG), documento de identificação
    protected String rg;

    // Cadastro de Pessoa Física (CPF), documento de identificação fiscal
    protected String cpf;

    // Getters e Setters para acessar e modificar os atributos da classe

    // Retorna o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Define o nome da pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a data de nascimento da pessoa
    public Date getDataNascimento() {
        return dataNascimento;
    }

    // Define a data de nascimento da pessoa
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Retorna o endereço completo da pessoa
    public String getEndereco() {
        return endereco;
    }

    // Define o endereço completo da pessoa
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Retorna o CEP do endereço da pessoa
    public String getCep() {
        return cep;
    }

    // Define o CEP do endereço da pessoa
    public void setCep(String cep) {
        this.cep = cep;
    }

    // Retorna o nome da rua do endereço
    public String getRua() {
        return rua;
    }

    // Define o nome da rua do endereço
    public void setRua(String rua) {
        this.rua = rua;
    }

    // Retorna o número do endereço
    public String getNumero() {
        return numero;
    }

    // Define o número do endereço
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Retorna a cidade do endereço
    public String getCidade() {
        return cidade;
    }

    // Define a cidade do endereço
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Retorna o estado do endereço
    public String getEstado() {
        return estado;
    }

    // Define o estado do endereço
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Retorna o telefone da pessoa
    public String getTelefone() {
        return telefone;
    }

    // Define o telefone da pessoa
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Retorna o gênero da pessoa
    public String getGenero() {
        return genero;
    }

    // Define o gênero da pessoa
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Retorna o RG da pessoa
    public String getRg() {
        return rg;
    }

    // Define o RG da pessoa
    public void setRg(String rg) {
        this.rg = rg;
    }

    // Retorna o CPF da pessoa
    public String getCpf() {
        return cpf;
    }

    // Define o CPF da pessoa
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
