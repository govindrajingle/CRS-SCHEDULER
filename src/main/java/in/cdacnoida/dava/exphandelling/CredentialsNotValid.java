package in.cdacnoida.dava.exphandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CredentialsNotValid extends RuntimeException{

	public CredentialsNotValid(String message) {
		super(message);
	}
}
