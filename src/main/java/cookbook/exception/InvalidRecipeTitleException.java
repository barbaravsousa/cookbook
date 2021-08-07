package cookbook.exception;

public class InvalidRecipeTitleException extends Exception {

    public InvalidRecipeTitleException(String errorMessage){
        super(errorMessage);
    }
}
