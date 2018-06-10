package pl.sebastianstrzalkowski.exception;

public class InvalidBarcodeException extends RuntimeException {
    public InvalidBarcodeException(String message){
        super(message);
    }
}
