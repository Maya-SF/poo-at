package br.fsa.dao;

// Importação da classe Materia para manipular objetos do tipo Materia e da interface List para trabalhar com listas
import br.fsa.faculdade.Materia;
import java.util.List;

// Classe responsável por realizar operações de leitura e escrita de arquivos relacionados aos dados das matérias
public class MateriaDAO implements LeitorArquivo {

    // Método sobrescrito da interface LeitorArquivo para definir o nome do arquivo a ser utilizado
    @Override
    public void setArquivo(String fileName) {
        // Implementação para armazenar ou definir o caminho/nome do arquivo
    }

    // Método sobrescrito da interface LeitorArquivo para escrever uma lista de linhas em um arquivo
    @Override
    public void escreveArquivo(List<String> linhas) {
        // Implementação para salvar as linhas no arquivo (exemplo: escrever dados das matérias em formato CSV ou TXT)
    }

    // Método sobrescrito da interface LeitorArquivo para ler linhas de um arquivo
    @Override
    public List<String> leArquivo() {
        // Implementação para carregar linhas de um arquivo (exemplo: ler dados de matérias de um arquivo CSV ou TXT)
        return null; // Retorna null como placeholder (deve ser substituído por lógica de leitura)
    }

    // Método para salvar uma lista de objetos Materia em um arquivo
    public void salvarMaterias(List<Materia> materias) {
        // Implementação para converter a lista de objetos Materia em um formato apropriado (exemplo: linhas CSV)
        // e chamar o método escreveArquivo para salvar os dados
    }
}
