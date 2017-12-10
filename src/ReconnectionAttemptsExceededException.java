public class ReconnectionAttemptsExceededException extends RuntimeException {
	
	  private static final long serialVersionUID = 3756544403778584892L;
	  
	  public ReconnectionAttemptsExceededException() { super(); }
	  public ReconnectionAttemptsExceededException(String message) { super(message); }
	  public ReconnectionAttemptsExceededException(String message, Throwable cause) { super(message, cause); }
	  public ReconnectionAttemptsExceededException(Throwable cause) { super(cause); }
	}
