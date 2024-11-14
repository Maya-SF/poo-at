package br.fsa;

import br.fsa.pessoa.Aluno;
import br.fsa.pessoa.Professor;
import br.fsa.faculdade.Curso;
import br.fsa.faculdade.Materia;
import br.fsa.faculdade.Nota;
import br.fsa.util.Log;
import br.fsa.util.ErroCadastro;
import br.fsa.util.Utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Classe principal para gerenciamento do sistema da faculdade
// Contém menus e funcionalidades para gerenciar alunos, professores, cursos, matérias e notas
public class GerenciaFaculdade {
      // Instâncias estáticas para gerenciamento e registro de operações
    private static final Log log = new Log("Log.txt");
    private static final Scanner scanner = new Scanner(System.in);
    // Listas para armazenamento de entidades do sistema
    private static final List<Aluno> alunos = new ArrayList<>();
    private static final List<Professor> professores = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Nota> notas = new ArrayList<>();
    private static final List<Materia> materias = new ArrayList<>();

        // Método principal que inicia o sistema
    public static void main(String[] args) {
        menuPrincipal();
    }
 // Menu principal para navegar entre diferentes funcionalidades
    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n--- SISTEMA DE GERENCIAMENTO DA FACULDADE ---");
            System.out.println("1. Alunos");
            System.out.println("2. Professores");
            System.out.println("3. Cursos");
            System.out.println("4. Materias");
            System.out.println("5. Notas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    menuAlunos(); // Submenu para gerenciamento de alunos
                    break;
                case 2:
                    menuProfessores(); // Submenu para gerenciamento de professores
                    break;
                case 3:
                    menuCursos();// Submenu para gerenciamento de cursos
                    break;
                case 4:
                    menuMaterias();// Submenu para gerenciamento de matérias
                    break;
                case 5:
                    menuNotas();// Submenu para gerenciamento de notas
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
 // Gerenciamento de matérias
    private static void menuMaterias() {
        while (true) {
            System.out.println("\n--- MENU MATÉRIAS ---");
            System.out.println("1. Adicionar Matéria");
            System.out.println("2. Listar Matérias");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarMateria();// Adiciona nova matéria
                    break;
                case 2:
                    listarMaterias();// Lista matérias cadastradas
                    break;
                case 0:
                    return;// Volta ao menu principal
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    // Adiciona uma nova matéria
    private static void adicionarMateria() {
        System.out.print("Digite o nome da matéria: ");
        String nomeMateria = scanner.nextLine();

        // Verifica se a matéria já existe
        boolean materiaExiste = materias.stream()
                .anyMatch(m -> m.getNome().equalsIgnoreCase(nomeMateria));

        if (materiaExiste) {
            System.out.println("Matéria já cadastrada!");
            return;
        }

        // Cria e adiciona a nova matéria
        Materia novaMateria = new Materia(nomeMateria);
        materias.add(novaMateria);

        log.logInfo("Matéria adicionada: " + nomeMateria);
        System.out.println("Matéria adicionada com sucesso!");
    }
// Lista todas as matérias cadastradas
    private static void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("Nenhuma matéria cadastrada.");
            return;
        }

        System.out.println("\n--- LISTA DE MATÉRIAS ---");
        materias.forEach(materia ->
                System.out.printf("Código: %d | Nome: %s\n",
                        materia.getCodigoUnico(), materia.getNome())
        );
    }

    private static void menuAlunos() {
        while (true) {
            System.out.println("\n--- MENU ALUNOS ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Editar Aluno");
            System.out.println("4. Remover Aluno");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    editarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void validarCodigoAluno(String codigoAluno) throws ErroCadastro {
        // Verificar se o código está vazio
        if (codigoAluno == null || codigoAluno.trim().isEmpty()) {
            throw new ErroCadastro("Código do Aluno não pode ser vazio.");
        }

        // Verificar se tem exatamente 6 dígitos
        if (!codigoAluno.matches("\\d{6}")) {
            throw new ErroCadastro("Código do Aluno deve conter exatamente 6 dígitos numéricos.");
        }

        // Verificar se o código já existe
        boolean codigoExistente = alunos.stream()
                .anyMatch(aluno -> String.valueOf(aluno.getCodigoUnico()).equals(codigoAluno));

        if (codigoExistente) {
            throw new ErroCadastro("Código do Aluno já cadastrado.");
        }
    }
// Adiciona um novo aluno
    private static void adicionarAluno() {
        try {
            System.out.println("\n--- ADICIONAR ALUNO ---");
            // Validação do Código do Aluno (6 dígitos numéricos)
            String codigoAluno;
            while (true) {
                System.out.print("Código do Aluno (6 dígitos numéricos): ");
                codigoAluno = scanner.nextLine();

                try {
                    validarCodigoAluno(codigoAluno);
                    break; // Sai do loop se a validação for bem-sucedida
                } catch (ErroCadastro e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            validarNome(nome); // Valida o nome do aluno

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNascimento = parseData(scanner.nextLine());

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            validarCPF(cpf);// Valida o CPF do aluno

            System.out.print("RG: ");
            String rg = scanner.nextLine();

            System.out.print("Endereço Completo: ");
            String endereco = scanner.nextLine();

            System.out.print("CEP: ");
            String cep = scanner.nextLine();

            System.out.print("Rua: ");
            String rua = scanner.nextLine();

            System.out.print("Número: ");
            String numero = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            validarTelefone(telefone);// Valida o telefone do aluno

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            int codigoUnico = alunos.size() + 1;
 // Cria um novo objeto Aluno com os dados fornecidos
            Aluno novoAluno = new Aluno(
                    nome, dataNascimento, endereco, cep, rua, numero,
                    cidade, estado, telefone, genero, rg, cpf, curso, codigoUnico
            );
// Adiciona o novo aluno à lista
            alunos.add(novoAluno);
            log.logInfo("Aluno adicionado: " + nome);
            System.out.println("Aluno cadastrado com sucesso!");

        } catch (ErroCadastro e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    // Lista todos os alunos cadastrados
    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE ALUNOS ---");
        alunos.forEach(aluno ->
                System.out.printf("Código: %d | Nome: %s | Curso: %s\n",
                        aluno.getCodigoUnico(), aluno.getNome(), aluno.getCurso())
        );
    }
    // Edita os dados de um aluno existente
    private static void editarAluno() {
        System.out.print("Digite o código do aluno a editar: ");
        int codigo = lerInteiro();
// Procura o aluno pelo código fornecido
        Aluno aluno = alunos.stream()
                .filter(a -> a.getCodigoUnico() == codigo)
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Editar dados de: " + aluno.getNome());
        // Implementar lógica de edição
    }
 // Remove um aluno pelo código
    private static void removerAluno() {
        System.out.print("Digite o código do aluno a remover: ");
        int codigo = lerInteiro();

        boolean removido = alunos.removeIf(a -> a.getCodigoUnico() == codigo);

        if (removido) {
            System.out.println("Aluno removido com sucesso!");
        } else {
 System.out.println("Aluno não encontrado.");
        }
    }

    // Validação do nome do aluno
    private static void validarNome(String nome) throws ErroCadastro {
        if (!nome.matches("[a-zA-ZÀ-ú\\s]+")) {
            throw new ErroCadastro("Nome inválido.");
        }
    }
    // Validação do CPF
    private static void validarCPF(String cpf) throws ErroCadastro {
        if (!Utilitarios.verificaCPF(cpf)) {
            throw new ErroCadastro("CPF inválido.");
        }
    }
    //Validação do Telefone  do aluno
    private static void validarTelefone(String telefone) throws ErroCadastro {
        if (!Utilitarios.verificaTelefone(telefone)) {
            throw new ErroCadastro("Telefone inválido.");
        }
    }
 // Método para converter uma string em um objeto Date.
    // Exige que a data esteja no formato "dd/MM/yyyy". Lança uma exceção personalizada em caso de erro.
    private static Date parseData(String dataStr) throws ErroCadastro {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
        } catch (ParseException e) {
            throw new ErroCadastro("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }
// Menu principal para operações relacionadas a professores.
    // Permite adicionar, listar, editar e remover professores.
    private static void menuProfessores() {
        while (true) {
            System.out.println("\n--- MENU PROFESSORES ---");
            System.out.println("1. Adicionar Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Editar Professor");
            System.out.println("4. Remover Professor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    editarProfessor();
                    break;
                case 4:
                    removerProfessor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
// Método para adicionar um professor ao sistema.
    // Recolhe diversas informações e valida entradas como nome, telefone e CPF.
    private static void adicionarProfessor() {
        try {
            System.out.println("\n--- ADICIONAR PROFESSOR ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            validarNome(nome);

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNascimento = parseData(scanner.nextLine());

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("CEP: ");
            String cep = scanner.nextLine();

            System.out.print("Rua: ");
            String rua = scanner.nextLine();

            System.out.print("Número: ");
            String numero = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            validarTelefone(telefone);

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("RG: ");
            String rg = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            validarCPF(cpf);
 // Solicita e processa as matérias que o professor ensinará.
            System.out.print("Matérias (separadas por vírgula): ");
            String[] materiasArray = scanner.nextLine().split(",");
            List<String> materias = Arrays.asList(materiasArray);
 // Solicita o código único do professor.
            System.out.print("Código Único: ");
            int codigoUnico = Integer.parseInt(scanner.nextLine());
// Cria o objeto Professor e o adiciona à lista de professores.
            Professor professor = new Professor(nome, dataNascimento, endereco, cep, rua, numero, cidade, estado, telefone, genero, rg, cpf, materias, codigoUnico);
            professores.add(professor);
            log.logInfo("Professor adicionado: " + nome);
            System.out.println("Professor adicionado com sucesso: " + professor);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar professor: " + e.getMessage());
        }
    }
    // Lista todos os professores cadastrados.
    // Exibe o código único e o nome de cada professor.
    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE PROFESSORES ---");
        professores.forEach(professor ->
                System.out.printf("Código: %d | Nome: %s\n",
                        professor.getCodigoUnico(), professor.getNome())
        );
    }
// Método para editar informações de um professor existente.
    // Permite buscar o professor pelo código único.
    private static void editarProfessor() {
        System.out.print("Digite o código do professor a editar: ");
        int codigo = lerInteiro();

        Professor professor = professores.stream()
                .filter(p -> p.getCodigoUnico() == codigo)
                .findFirst()
                .orElse(null);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        System.out.println("Editar dados de: " + professor.getNome());
        // Implementar lógica de edição
    }
// Método para remover um professor do sistema.
    // Exige o código único do professor como entrada.
    private static void removerProfessor() {
        System.out.print("Digite o código do professor a remover: ");
        int codigo = lerInteiro();

        boolean removido = professores.removeIf(p -> p.getCodigoUnico() == codigo);

        if (removido) {
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }
// Menu principal para operações relacionadas a cursos.
    // Permite adicionar e listar cursos.
    private static void menuCursos() {
        while (true) {
            System.out.println("\n--- MENU CURSOS ---");
            System.out.println("1. Adicionar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
  // Método para adicionar um curso ao sistema.
    private static void adicionarCurso() {
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.nextLine();
        Curso novoCurso = new Curso(nomeCurso);
        cursos.add(novoCurso);
        log.logInfo("Curso adicionado: " + nomeCurso);
        System.out.println("Curso adicionado com sucesso!");
    }
 // Lista todos os cursos cadastrados.
    private static void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE CURSOS ---");
        cursos.forEach(curso ->
                System.out.printf("Código: %d | Nome: %s\n",
                        curso.getCodigoUnico(), curso.getNome())
        );
    }
    // Menu principal para operações relacionadas a notas.
    // Permite adicionar, calcular a média e listar notas.
    private static void menuNotas() {
        while (true) {
            System.out.println("\n--- MENU NOTAS ---");
            System.out.println("1. Adicionar Nota");
            System.out.println("2. Calcular Média");
            System.out.println("3. Listar Notas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    adicionarNota();
                    break;
                case 2:
                    calcularMedia();
                    break;
                case 3:
                    listarNotas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
// Método para adicionar uma nota ao sistema.
    // Verifica se há alunos cadastrados antes de continuar.
    private static void adicionarNota() {
        // Verificar se existem alunos e matérias
        if (alunos.isEmpty()) {
            System.out.println("Não existem alunos cadastrados.");
            return;
        }

        if (materias.isEmpty()) {
            System.out.println("Não existem matérias cadastradas.");
            return;
        }

        // Selecionar Aluno
        Aluno aluno = selecionarAluno();
        if (aluno == null) return;

        // Selecionar Matéria
        Materia materia = selecionarMateria();
        if (materia == null) return;

        try {
            System.out.print("Nota da P1: ");
            double p1 = lerDouble();

            System.out.print("Nota da P2: ");
            double p2 = lerDouble();

            System.out.print("Nota do Trabalho: ");
            double trabalho = lerDouble();

            // Criar nova nota
            Nota novaNota = new Nota(aluno, materia, p1, p2, trabalho);
            notas.add(novaNota);

            log.logInfo("Nota adicionada para aluno: " + aluno.getNome() +
                    " na matéria: " + materia.getNome());
            System.out.println("Nota adicionada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao adicionar nota: " + e.getMessage());
        }
    }

    private static Aluno selecionarAluno() {
        System.out.println("Alunos disponíveis:");
        alunos.forEach(a ->
                System.out.printf("Código: %d | Nome: %s\n", a.getCodigoUnico(), a.getNome())
        );

        System.out.print("Digite o código do aluno: ");
        int codigoAluno = lerInteiro();

        Aluno aluno = alunos.stream()
                .filter(a -> a.getCodigoUnico() == codigoAluno)
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
        }

        return aluno;
    }

    private static Materia selecionarMateria() {
        System.out.println("Matérias disponíveis:");
        materias.forEach(m ->
                System.out.printf("Código: %d | Nome: %s\n", m.getCodigoUnico(), m.getNome())
        );

        System.out.print("Digite o nome da matéria: ");
        String nomeMateriaEscolhida = scanner.nextLine();

        Materia materia = materias.stream()
                .filter(m -> m.getNome().equalsIgnoreCase(nomeMateriaEscolhida))
                .findFirst()
                .orElse(null);

        if (materia == null) {
            System.out.println("Matéria não encontrada.");
        }

        return materia;
    }

    private static void calcularMedia() {
        // Selecionar Aluno
        Aluno aluno = selecionarAluno();
        if (aluno == null) return;
    
        // Selecionar Matéria
        Materia materia = selecionarMateria();
        if (materia == null) return;
    
        // Filtrar notas do aluno na matéria específica
        List<Nota> notasAluno = notas.stream()
                .filter(n -> n.getAluno().getCodigoUnico() == aluno.getCodigoUnico()
                        && n.getMateria().getNome().equalsIgnoreCase(materia.getNome()))
                .collect(Collectors.toList());
    
        if (notasAluno.isEmpty()) {
            System.out.println("Nenhuma nota encontrada para o aluno nesta matéria.");
            return;
        }
    
        // Solicitar notas adicionais se necessário
        List<Double> notasAtividade = new ArrayList<>();
    
        System.out.print("\nDigite a quantidade de atividades por matéria: ");
        int quantidadeAtividade = lerInteiro(); // Use lerInteiro() em vez de scanner.nextInt()
    
        for (int i = 0; i < quantidadeAtividade; i++) {
            System.out.print("Digite a nota da atividade " + (i + 1) + ": ");
            double nota = lerDouble(); // Use lerDouble() em vez de scanner.nextDouble()
            notasAtividade.add(nota);
        }
    
        // Calcular média das atividades
        double somaNotasAtividade = notasAtividade.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double notaFinalAtividade = (somaNotasAtividade / quantidadeAtividade) * 0.2;
    
        // Calcular média das provas
        double mediaProvas = notasAluno.stream()
                .mapToDouble(n -> ((n.getP1() + n.getP2()) / 2) * 0.8)
                .findFirst()
                .orElse(0);
    
        // Calcular média geral
        double mediaGeral = mediaProvas + notaFinalAtividade;
    
        // Determinar status e possível recuperação
        String status;
        if (mediaGeral >= 5) {
            status = "APROVADO";
            System.out.printf("\nA sua média geral foi: %.2f\n", mediaGeral);
            System.out.println("\nVocê passou! Parabéns!");
        } else if (mediaGeral >= 3) {
            status = "Em Recuperação";
            System.out.printf("\nA sua nota foi: %.2f\n", mediaGeral);
            System.out.println("\nVocê reprovou e terá que fazer P3");
            
            System.out.print("\nDigite a nota da P3: ");
            double notaP3 = lerDouble(); // Use lerDouble()
            
            double mediaFinal = (mediaGeral + notaP3) / 2;
            
            if (mediaFinal >= 5) {
                status = "APROVADO";
                System.out.printf("\nA sua nota final foi: %.2f\n", mediaFinal);
                System.out.println("\nVocê passou! Parabéns!");
            } else {
                status = "REPROVADO";
                System.out.printf("\nA sua nota final foi: %.2f\n", mediaFinal);
                System.out.println("\nVocê foi reprovado!");
            }
        } else {
            status = "REPROVADO";
            System.out.println("Você foi reprovado!");
        }
    
        // Log da operação
        log.logInfo("Média calculada para aluno: " + aluno.getNome() +
                " na matéria: " + materia.getNome() +
                " - Média: " + mediaGeral + " - Status: " + status);
    }

    private static void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
            return;
        }

        System.out.println("\n--- LISTA DE NOTAS ---");
        notas.forEach(nota ->
                System.out.printf("Aluno: %s | Matéria: %s | P1: %.2f | P2: %.2f | Trabalho: %.2f\n",
                        nota.getAluno().getNome(),
                        nota.getMateria().getNome(),
                        nota.getP1(),
                        nota.getP2(),
                        nota.getTrabalho())
        );
    }
// Método para ler um número inteiro do usuário.
    // Permanece em loop até que uma entrada válida seja fornecida.
    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());// Converte a entrada para inteiro.
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
            }
        }
    }
   // Método para ler um número decimal (double) do usuário.
    // Permanece em loop até que uma entrada válida seja fornecida.
    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());// Converte a entrada para double.
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número decimal: ");// Mensagem de erro para entrada inválida.
            }
        }
    }
}