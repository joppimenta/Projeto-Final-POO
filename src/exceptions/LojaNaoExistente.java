package exceptions;

public class LojaNaoExistente extends Exception{
    public String getMessage(){
        return "Loja nao encontrada";
    }
}
