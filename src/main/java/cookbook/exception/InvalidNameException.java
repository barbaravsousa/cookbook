package cookbook.exception;

public class InvalidNameException extends Exception {

    public InvalidNameException(String errorMessage){
        super(errorMessage);
    }
}
