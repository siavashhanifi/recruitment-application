package kth.iv1201.grupp10.recruitmentApplication.domain;

public class InvalidRegistrationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    

    public InvalidRegistrationException(String message) {
        super(message);
    }
}