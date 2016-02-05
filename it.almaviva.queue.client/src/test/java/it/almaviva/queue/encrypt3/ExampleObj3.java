package it.almaviva.queue.encrypt3;

import org.springframework.stereotype.Component;

@Component
public class ExampleObj3 {

	private String password;
	private String user;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
