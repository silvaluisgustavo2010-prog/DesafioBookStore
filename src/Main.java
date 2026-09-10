import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;
        do {
            System.out.println("Bem vindo à biblioteca!!!");
            System.out.println("[1] Cadastrar usuário");
            System.out.println("[2] Cadastrar livro");
            System.out.println("[3] Alugar livro");
            System.out.println("[4] Devolver livro");
            System.out.println("[5] Listar usuários");
            System.out.println("[6] Listar Livros");
            System.out.println("[0] Sair");
            System.out.println("Digite uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    input.nextLine();
                    System.out.println("Digite o nome do usuário: ");
                    String nome = input.nextLine();
                    System.out.println("Digite a idade: ");
                    int idade = input.nextInt();
                    Usuario usuario = new Usuario(nome,idade);
                    biblioteca.usuarios.add(usuario);
                    System.out.println("Usuário cadastrado com sucesso!\n\n");
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = input.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = input.nextLine();
                    Livro livro = new Livro(titulo, autor);
                    biblioteca.livros.add(livro);
                    System.out.println("Livro cadastrado com sucesso!\n\n");
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Digite o nome do usuário:");
                    String nomeUsuario = input.nextLine();
                    Usuario usuarioEncontrado = null;
                    for (Usuario usuarioCadastrado : biblioteca.usuarios) {
                        if (usuarioCadastrado.nome.equals(nomeUsuario)) {
                            usuarioEncontrado = usuarioCadastrado;
                            break;
                        }
                    }
                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado!\n\n");
                        break;
                    }
                    System.out.println("Digite o titulo do livro:");
                    String tituloLivro = input.nextLine();
                    Livro livroEncontrado = null;
                    for (Livro livroCadastrado : biblioteca.livros) {
                        if (livroCadastrado.titulo.equals(tituloLivro)) {
                            livroEncontrado = livroCadastrado;
                            break;
                        }
                    }
                    if (livroEncontrado == null) {
                        System.out.println("Livro não encontrado!\n\n");
                        break;
                    }
                    biblioteca.alugarLivro(usuarioEncontrado, livroEncontrado);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Digite o nome do usuário:");
                    String nomeUsuarioDevolucao = input.nextLine();
                    Usuario usuarioDevolucao = null;

                    for (Usuario usuarioCadastrado : biblioteca.usuarios) {
                        if (usuarioCadastrado.nome.equals(nomeUsuarioDevolucao)) {
                            usuarioDevolucao = usuarioCadastrado;
                            break;
                        }
                    }
                    if (usuarioDevolucao == null) {
                        System.out.println("Usuário não cadastrado!\n\n");
                        break;
                    }
                    System.out.println("Digite o titulo do livro:");
                    String tituloLivroDevolucao = input.nextLine();
                    Livro livroDevolucao = null;
                    for (Livro livroAlugado : usuarioDevolucao.livrosAlugados) {
                        if (livroAlugado.titulo.equals(tituloLivroDevolucao)) {
                            livroDevolucao = livroAlugado;
                            break;
                        }
                    }
                    if (livroDevolucao == null) {
                        System.out.println("Esse usuário não possui esse livro alugado!\n\n");
                        break;
                    }
                    Aluguel aluguelEncontrado = null;
                    for (Aluguel aluguel : biblioteca.alugueis) {
                        if (aluguel.usuario == usuarioDevolucao && aluguel.livro == livroDevolucao) {
                            aluguelEncontrado = aluguel;
                            break;
                        }
                    }
                    if (aluguelEncontrado == null) {
                        System.out.println("Aluguel não encontrado!\n\n");
                    }
                    aluguelEncontrado.devolvido = true;
                    livroDevolucao.disponivel = true;
                    usuarioDevolucao.livrosAlugados.remove(livroDevolucao);
                    System.out.println("Livro devolvido com sucesso!\n\n");
                    break;
                case 5:
                    for (Usuario usuarioCadastrado : biblioteca.usuarios) {
                        System.out.println("Nome: " + usuarioCadastrado.nome);
                        System.out.println("Idade: " + usuarioCadastrado.idade);
                        System.out.println("Livros alugados: " + usuarioCadastrado.livrosAlugados.size());
                        System.out.println();
                    }
                    break;
                case 6:
                    for (Livro livroCadastrado : biblioteca.livros) {
                        System.out.println("Titulo do livro: " + livroCadastrado.titulo);
                        System.out.println("Autor do livro: " + livroCadastrado.autor);
                        System.out.println("Disponível: " + (livroCadastrado.disponivel? "Sim" : "Não"));
                        for (Aluguel aluguel : biblioteca.alugueis) {
                            if (aluguel.livro == livroCadastrado && !aluguel.devolvido) {
                                System.out.println("Alugado por: " + aluguel.usuario.nome);
                                break;
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (opcao != 0);
    }
}
