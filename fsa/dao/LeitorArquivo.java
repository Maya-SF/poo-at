package br.fsa.dao;

// Interface que define métodos para operações básicas de manipulação de arquivos
// Inclui definição de arquivo, escrita e leitura de dados em formato de lista
import java.util.List;

public interface LeitorArquivo {
    // Método para definir o nome ou caminho do arquivo a ser manipulado
    void setArquivo(String fileName);

    // Método para escrever uma lista de linhas no arquivo
    // Cada elemento da lista representa uma linha a ser escrita
    void escreveArquivo(List<String> linhas);

    // Método para ler o conteúdo de um arquivo e retorná-lo como uma lista de strings
    // Cada elemento da lista representa uma linha lida do arquivo
    List<String> leArquivo();
}
