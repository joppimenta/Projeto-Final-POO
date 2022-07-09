package exceptions;

public class LojaNaoExistente extends Exception{
    public String getMessage(){
        return "dados.Loja nao encontrada";
    }
}
