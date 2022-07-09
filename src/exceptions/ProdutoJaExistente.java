package exceptions;

public class ProdutoJaExistente extends Throwable {

    public String getMessage(){
        return "dados.Produto já encontrado";
    }
}
