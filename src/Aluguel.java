public class Aluguel {
    Usuario usuario;
    Livro livro;
    boolean devolvido;

    public Aluguel(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.devolvido = false;
    }
}
