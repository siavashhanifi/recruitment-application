package kth.iv1201.grupp10.recruitmentApplication.domain;

public class InvalidLoginException extends Exception {

    private static final long serialVersionUID = 1L;
    
    /**
     * General exception for login attempts
     * @param message
     */
    public InvalidLoginException(String message) {
        super(message);
    }
}