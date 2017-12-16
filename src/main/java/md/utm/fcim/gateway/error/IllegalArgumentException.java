package md.utm.fcim.gateway.error;

public class IllegalArgumentException extends RuntimeException {

    private int status;

    public IllegalArgumentException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}