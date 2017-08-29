import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

	public static void main(String[] args) {

		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:postgresql://172.16.2.253:5432/academy", "user1",
						"password1");
		     Statement statement = connection.createStatement();
		     ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

			Class.forName("org.postgresql.Driver");


			List<List<Object>> result = new ArrayList<>();

			int columnCount = resultSet.getMetaData().getColumnCount();

			List<Object> headers = new ArrayList<>();
			for (int index = 1; index <= columnCount; index++) {
				headers.add(resultSet.getMetaData().getColumnName(index));
			}
			result.add(headers);

			while (resultSet.next()) {
				List<Object> row = new ArrayList<>();
				for (int index = 1; index <= columnCount; index++) {
					row.add(resultSet.getObject(index));
				}
				result.add(row);
			}

			result.forEach(row -> {
				row.forEach(value -> System.out.print(value + "         "));
				System.out.println();
			});


			/*
			List<User> users = new ArrayList<>();
			while (resultSet.next()) {
				User user = new User();
				user.setId((Integer) resultSet.getObject(1));
				user.setEmail((String) resultSet.getObject(2));
				user.setName((String) resultSet.getObject("name"));
				user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
				users.add(user);
			}

			users.forEach(System.out::println);
			*/

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
}