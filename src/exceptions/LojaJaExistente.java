package exceptions;

public class LojaJaExistente extends Exception{
    public String getMessage(){
        return "Essa loja já existe";
    }
}
