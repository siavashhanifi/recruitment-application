package kth.iv1201.grupp10.recruitmentApplication.domain;

public class InvalidRegistrationException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
    * Exception related to registration attempts. Is thrown when registration fails
    * due to invalid credentials.
    */
    public InvalidRegistrationException(String message) {
        super(message);
    }
}