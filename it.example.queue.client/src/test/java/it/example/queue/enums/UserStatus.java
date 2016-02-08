package it.example.queue.enums;

import org.springframework.stereotype.Service;

@Service
public enum UserStatus {
	PENDING("P", 1), ACTIVE("A", 2), INACTIVE("I", 3), DELETED("D", 4);

	private String statusCode;
	private int position;

	private UserStatus(String s, int p) {
		statusCode = s;
		position = p;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public int getPosition() {
		return position;
	}
}