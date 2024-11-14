// Log.java
package br.fsa.util;

import java.io.FileWriter;
import java.io.IOException;

// Classe responsável por registrar logs de erros e informações em um arquivo
public class Log {
    // Nome do arquivo onde os logs serão gravados
    private String nomeArquivo;

    // Construtor que define o arquivo de log a ser utilizado
    public Log(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Método para registrar mensagens de erro no arquivo de log
    public void logErro(String mensagem) {
        // Usa um bloco try-with-resources para garantir que o FileWriter seja fechado automaticamente
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write("ERRO - " + mensagem + "\n"); // Adiciona a mensagem de erro ao arquivo com prefixo "ERRO"
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a stack trace no console em caso de falha ao gravar o log
        }
    }

    // Método para registrar mensagens informativas no arquivo de log
    public void logInfo(String mensagem) {
        // Usa um bloco try-with-resources para garantir que o FileWriter seja fechado automaticamente
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write("INFO - " + mensagem + "\n"); // Adiciona a mensagem informativa ao arquivo com prefixo "INFO"
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a stack trace no console em caso de falha ao gravar o log
        }
    }
}
