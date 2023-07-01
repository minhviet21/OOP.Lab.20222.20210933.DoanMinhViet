package hust.soict.dsai.aims.exception;

public class DataConstraintsException extends Exception{

public DataConstraintsException() {
		
	}
	
	public DataConstraintsException(String message) {
		super(message);
	}
	
	public DataConstraintsException(Throwable cause) {
		super(cause);
	}
	
	public DataConstraintsException(String message, Throwable cause) {
		super(message,cause);
	}
}
