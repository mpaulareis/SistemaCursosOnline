import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {

    // JAVAFX
    private StringProperty nome;
    private StringProperty cpf;
    private StringProperty email;
    private StringProperty telefone;
    private StringProperty senha;   // <<< NOVO


    public Aluno(String nome, String cpf, String email, String telefone, String senha) {
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.email = new SimpleStringProperty(email);
        this.telefone = new SimpleStringProperty(telefone);
        this.senha = new SimpleStringProperty(senha);
    }

    public String getNome() { return nome.get(); }
    public String getCpf() { return cpf.get(); }
    public String getEmail() { return email.get(); }
    public String getTelefone() { return telefone.get(); }
    public String getSenha() { return senha.get(); }


    public StringProperty nomeProperty() { return nome; }
    public StringProperty cpfProperty() { return cpf; }
    public StringProperty emailProperty() { return email; }
    public StringProperty telefoneProperty() { return telefone; }
    public StringProperty senhaProperty() { return senha; }

    public void setNome(String nome) { this.nome.set(nome); }
    public void setCpf(String cpf) { this.cpf.set(cpf); }
    public void setEmail(String email) { this.email.set(email); }
    public void setTelefone(String telefone) { this.telefone.set(telefone); }
    public void setSenha(String senha) { this.senha.set(senha); }

    @Override
    public String toString() {
        return "Aluno: " + getNome() + " | CPF: " + getCpf() + " | Email: " + getEmail();}}
