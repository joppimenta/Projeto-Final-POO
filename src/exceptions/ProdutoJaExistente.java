package exceptions;

public class ProdutoJaExistente extends Throwable {

    public String getMessage(){
        return "Produto já encontrado";
    }
}
