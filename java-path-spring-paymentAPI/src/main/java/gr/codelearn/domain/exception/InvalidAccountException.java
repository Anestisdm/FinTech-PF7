package gr.codelearn.domain.exception;

public class InvalidAccountException extends Exception{
    public InvalidAccountException(String message){
        super(message);
    }
}