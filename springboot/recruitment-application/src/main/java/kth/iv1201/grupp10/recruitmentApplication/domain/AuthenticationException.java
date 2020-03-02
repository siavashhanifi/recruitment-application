package kth.iv1201.grupp10.recruitmentApplication.domain;

public class AuthenticationException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * Exception used at token validation
     * @param message the error message
     */
    public AuthenticationException(String message) {
        super(message);
    }
}