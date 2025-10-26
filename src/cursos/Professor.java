package cursos;


public class Professor {
    private String nome;
    private String areaAtuacao;
    private String email;

    public Professor(String nome, String areaAtuacao, String email) {
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getAreaAtuacao() { return areaAtuacao; }

    @Override
    public String toString() {
        return "Professor: " + nome + " | Área: " + areaAtuacao;
    }
}

