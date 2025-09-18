package cursos;


public class Programa {
    public static void main(String[] args) {

        Professor prof1 = new Professor("Maria Silva", "Programação", "maria@cursos.com");

        Curso cursoJava = new Curso("Java Básico", "Introdução ao Java", 40, "Tecnologia", prof1);

        Aula aula1 = new Aula("Introdução", "História do Java", "01/09/2025");
        Aula aula2 = new Aula("Sintaxe", "Variáveis e Operadores", "02/09/2025");
        cursoJava.adicionarAula(aula1);
        cursoJava.adicionarAula(aula2);

        Aluno aluno1 = new Aluno("João Souza", "12345678900", "joao@email.com", "99999-9999");

        Matricula mat1 = new Matricula(aluno1, cursoJava, "01/09/2025");
        mat1.registrarNota(9.0);

        System.out.println(prof1);
        System.out.println(cursoJava);
        System.out.println(aluno1);
        System.out.println(mat1);
    }
}
