package kth.iv1201.grupp10.recruitmentApplication.domain;

public class AuthorizationException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * General exception for authorization-dependent requests
     * @param message the error message
     */
    public AuthorizationException(String message) {
        super(message);
    }
}