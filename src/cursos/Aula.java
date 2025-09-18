package cursos;


public class Aula {
    private String titulo;
    private String conteudo;
    private String data;

    public Aula(String titulo, String conteudo, String data) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Aula: " + titulo + " | Data: " + data;
    }
}
