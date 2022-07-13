package exceptions;

public class PreenchimentoInvalido extends Exception{
    public String getMessage(){
        return "Preencha os campos corretamente!";
    }
}
