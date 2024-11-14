package br.fsa.dao;

// Importação da classe Professor para manipular objetos do tipo Professor e da interface List para trabalhar com listas
import br.fsa.pessoa.Professor;
import java.util.List;

// Classe responsável por realizar operações de leitura e escrita de arquivos relacionados aos dados de professores
public class ProfessorDAO implements LeitorArquivo {

    // Método sobrescrito da interface LeitorArquivo para definir o nome do arquivo a ser utilizado
    @Override
    public void setArquivo(String fileName) {
        // Implementação para armazenar ou definir o caminho/nome do arquivo
    }

    // Método sobrescrito da interface LeitorArquivo para escrever uma lista de linhas em um arquivo
    @Override
    public void escreveArquivo(List<String> linhas) {
        // Implementação para salvar as linhas no arquivo (exemplo: escrever dados dos professores em formato CSV ou TXT)
    }

    // Método sobrescrito da interface LeitorArquivo para ler linhas de um arquivo
    @Override
    public List<String> leArquivo() {
        // Implementação para carregar linhas de um arquivo (exemplo: ler dados de professores de um arquivo CSV ou TXT)
        return null; // Retorna null como placeholder (deve ser substituído por lógica de leitura)
    }

    // Método para salvar uma lista de objetos Professor em um arquivo
    public void salvarProfessores(List<Professor> professores) {
        // Implementação para converter a lista de objetos Professor em um formato apropriado (exemplo: linhas CSV)
        // e chamar o método escreveArquivo para salvar os dados
    }
}
