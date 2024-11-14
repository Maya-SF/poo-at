package br.fsa.util;

// Classe personalizada para tratar erros específicos relacionados a cadastros
// Estende a classe Exception para criar uma exceção específica
public class ErroCadastro extends Exception {

    // Construtor que recebe uma mensagem como parâmetro e a passa para a classe base Exception
    public ErroCadastro(String mensagem) {
        super(mensagem); // Chama o construtor da classe Exception com a mensagem fornecida
    }
}
