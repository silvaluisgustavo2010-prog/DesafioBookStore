import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Aluguel> alugueis = new ArrayList<>();

    boolean usuarioExiste = false;

    void alugarLivro(Usuario usuario, Livro livro) {
        boolean usuarioExiste = false;

        for (Usuario usuarioCadastrado : usuarios) {
            if (usuarioCadastrado == usuario) {
                usuarioExiste = true;
                break;
            }
        }
        if (!usuarioExiste) {
            System.out.println("Usuário não cadastrado!\n\n");
            return;
        }
        boolean livroExiste = false;
        for (Livro livroCadastrado: livros) {
            if (livroCadastrado == livro) {
                livroExiste = true;
                break;
            }
        }
        if (!livroExiste) {
            System.out.println("Livro não cadastrado\n\n");
            return;
        }
        if (!livro.disponivel) {
            System.out.println("Livro indisponivel!!\n\n");
            return;
        }
        Aluguel aluguel = new Aluguel(usuario, livro);
        usuario.livrosAlugados.add(livro);
        livro.disponivel = false;
        alugueis.add(aluguel);
        System.out.println("Livro alugado com sucesso!\n\n");
    }

}
