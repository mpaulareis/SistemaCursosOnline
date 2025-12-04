public class Programa {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstancia();

        Professor prof = new Professor("Paulo Anselmo", "123.456.789-00", "Programação", "paulo@ex.com");
        fachada.cadastrarProfessor(prof);
        System.out.println("Professor cadastrado: " + prof);

        Curso curso = new Curso("Java Básico", "Introdução ao Java", 40, "Tecnologia", prof);
        fachada.cadastrarCurso(curso);
        System.out.println("Curso cadastrado: " + curso);

        Aluno aluno = new Aluno("Maria Paula Reis", "12345678900", "paula@ex.com", "99999-9999", "abcd");
        fachada.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado: " + aluno);

        fachada.matricularAluno("12345678900", "Java Básico", "18/09/2025");
        System.out.println("Matrículas do aluno:");
        Matricula[] mats = fachada.listarMatriculasDoAluno("12345678900");
        for (Matricula m : mats) System.out.println(m);
    }
}

