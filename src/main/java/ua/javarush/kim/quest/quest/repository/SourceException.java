package ua.javarush.kim.quest.quest.repository;

import java.sql.SQLException;

public class SourceException extends SQLException {

	public SourceException() {
		super();
	}

	public SourceException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
	}

	public SourceException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
	}

	public SourceException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
	}

	public SourceException(String reason, String SQLState) {
		super(reason, SQLState);
	}

	public SourceException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public SourceException(String reason) {
		super(reason);
	}

	public SourceException(Throwable cause) {
		super(cause);
	}

}
