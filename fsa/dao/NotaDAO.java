package br.fsa.dao;

// Importação da classe Nota para manipular objetos do tipo Nota e da interface List para trabalhar com listas
import br.fsa.faculdade.Nota;
import java.util.List;

// Classe responsável por realizar operações de leitura e escrita de arquivos relacionados aos dados de notas
public class NotaDAO implements LeitorArquivo {

    // Método sobrescrito da interface LeitorArquivo para definir o nome do arquivo a ser utilizado
    @Override
    public void setArquivo(String fileName) {
        // Implementação para armazenar ou definir o caminho/nome do arquivo
    }

    // Método sobrescrito da interface LeitorArquivo para escrever uma lista de linhas em um arquivo
    @Override
    public void escreveArquivo(List<String> linhas) {
        // Implementação para salvar as linhas no arquivo (exemplo: escrever dados das notas em formato CSV ou TXT)
    }

    // Método sobrescrito da interface LeitorArquivo para ler linhas de um arquivo
    @Override
    public List<String> leArquivo() {
        // Implementação para carregar linhas de um arquivo (exemplo: ler dados de notas de um arquivo CSV ou TXT)
        return null; // Retorna null como placeholder (deve ser substituído por lógica de leitura)
    }

    // Método para salvar uma lista de objetos Nota em um arquivo
    public void salvarNotas(List<Nota> notas) {
        // Implementação para converter a lista de objetos Nota em um formato apropriado (exemplo: linhas CSV)
        // e chamar o método escreveArquivo para salvar os dados
    }
}
