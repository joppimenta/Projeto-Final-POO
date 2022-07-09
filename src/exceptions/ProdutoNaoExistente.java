package exceptions;

public class ProdutoNaoExistente extends Throwable {

    public String getMessage(){
        return "dados.Produto especificado não existe";
    }
}
