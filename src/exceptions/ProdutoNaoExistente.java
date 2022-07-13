package exceptions;

public class ProdutoNaoExistente extends Throwable {

    public String getMessage(){
        return "Produto especificado não existe";
    }
}
