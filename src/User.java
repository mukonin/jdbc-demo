import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {

	private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("d MMM, yyyy");
	private static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm");

	private int id;
	private  String email;
	private String name;
	private LocalDateTime createdAt;

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return String.format("User - id: %d, email: %s, name: %s, created date: %s, created time: %s",
				id,
				email,
				name,
				createdAt.format(FORMATTER_DATE),
				createdAt.format(FORMATTER_TIME));
	}
}