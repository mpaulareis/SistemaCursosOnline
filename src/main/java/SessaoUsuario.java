/**
 * Guarda o usuário logado entre telas.
 * Usamos Object para suportar Aluno e Professor.
 */
public class SessaoUsuario {

    private static Object usuarioLogado;

    public static void setUsuarioLogado(Object u) {
        usuarioLogado = u;
    }

    public static Object getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void limpar() {
        usuarioLogado = null;
    }
}
