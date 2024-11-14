package br.fsa.dao; 

// Importação da classe Aluno e da interface List para manipulação de listas
import br.fsa.pessoa.Aluno;
import java.util.List;

// Classe responsável por realizar operações de leitura e escrita de arquivos
// relacionados aos dados de alunos
public class AlunoDAO implements LeitorArquivo {

    // Método sobrescrito da interface LeitorArquivo para definir o nome do arquivo
    @Override
    public void setArquivo(String fileName) {
        // Implementação para definir o nome do arquivo (exemplo: armazenar o caminho ou nome em uma variável)
    }

    // Método sobrescrito da interface LeitorArquivo para escrever uma lista de linhas em um arquivo
    @Override
    public void escreveArquivo(List<String> linhas) {
        // Implementação para salvar as linhas no arquivo (exemplo: escrever em um arquivo CSV ou TXT)
    }

    // Método sobrescrito da interface LeitorArquivo para ler linhas de um arquivo
    @Override
    public List<String> leArquivo() {
        // Implementação para leitura de linhas de um arquivo (exemplo: carregar o conteúdo de um arquivo CSV ou TXT)
        return null; // Retorna null como placeholder (deve ser substituído por lógica de leitura)
    }

    // Método para salvar uma lista de objetos Aluno em um arquivo
    public void salvarAlunos(List<Aluno> alunos) {
        // Implementação para converter a lista de alunos em formato apropriado (exemplo: linhas CSV)
        // e chamar o método escreveArquivo para salvar os dados
    }
}
