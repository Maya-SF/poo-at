package br.fsa.util;

// Classe Utilitarios que contém métodos estáticos auxiliares para validação de CPF e telefone
public class Utilitarios {

    // Método estático para verificar se um CPF é válido
    public static boolean verificaCPF(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return false; // CPF inválido se não tiver 11 dígitos
        }

        // Verifica se todos os dígitos do CPF são iguais (ex.: "11111111111" é inválido)
        if (cpf.chars().distinct().count() == 1) {
            return false; // CPF inválido se todos os dígitos forem iguais
        }

        // Validação dos dígitos verificadores do CPF
        int soma;
        int resto;

        // Valida o primeiro dígito verificador
        soma = 0;
        for (int i = 0; i < 9; i++) {
            // Multiplica os primeiros 9 dígitos pelos pesos decrescentes de 10 a 2
            soma += (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
        }
        resto = 11 - (soma % 11);
        if (resto >= 10) {
            resto = 0; // Se o resto for maior ou igual a 10, o dígito deve ser 0
        }
        // Verifica se o primeiro dígito calculado corresponde ao informado no CPF
        if (resto != Character.getNumericValue(cpf.charAt(9))) {
            return false; // CPF inválido
        }

        // Valida o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            // Multiplica os primeiros 10 dígitos pelos pesos decrescentes de 11 a 2
            soma += (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        resto = 11 - (soma % 11);
        if (resto >= 10) {
            resto = 0; // Se o resto for maior ou igual a 10, o dígito deve ser 0
        }
        // Retorna true se o segundo dígito calculado corresponder ao informado
        return resto == Character.getNumericValue(cpf.charAt(10));
    }

    // Método estático para verificar se um telefone é válido
    public static boolean verificaTelefone(String telefone) {
        // Remove caracteres não numéricos do telefone
        telefone = telefone.replaceAll("[^0-9]", "");

        // Verifica se o telefone tem 10 (fixo) ou 11 (celular) dígitos
        return telefone.length() == 10 || telefone.length() == 11;
    }
}
