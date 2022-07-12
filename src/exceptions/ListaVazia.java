package exceptions;

public class ListaVazia extends Exception{
    public String getMessage(){
        return "Nenhuma loja cadastrada";
    }
}
