import java.util.ArrayList;

public class Usuario {
    String nome;
    int idade;
    ArrayList<Livro> livrosAlugados = new ArrayList<>();

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
