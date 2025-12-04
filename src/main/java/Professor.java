public class Professor {
    private String nome;
    private String cpf;
    private String areaAtuacao;
    private String email;

    public Professor(String nome, String cpf, String areaAtuacao, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.areaAtuacao = areaAtuacao;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getAreaAtuacao() { return areaAtuacao; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Professor: " + nome + " | CPF: " + cpf + " | Área: " + areaAtuacao;
    }
}
