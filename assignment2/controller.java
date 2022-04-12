
package assignment2;

import java.sql.*;

public class controller {
	private view view;
	private student model;

	public controller(view view, student model) {
		this.view = view;
		this.model = model;
	}

	public void insertData(int id, String name, int age, String department, String nationality, double mathMark,
			double scienceMark) throws SQLException {
		student student = new student();
		// Connect to database
		Connection conn = null;
		// MySQL needs to prompt whether to perform SSL connection in high version,
		// MYSQL time zone problem and Chinese and English garbled characters
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=123456aa"
				+ "&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");

		// Create a statement to retrieve objects
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO STUDENT VALUES (" + id + ", '" + name + "', " + age + ", '" + department
				+ "', '" + nationality + "', " + scienceMark + ", " + mathMark + ");");

		System.out.println("Data saved successfully,please continue");
	}

	public void getStudent(int id) throws SQLException {
		student student = new student();
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=123456aa"
				+ "&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
		Statement stmt = connection.createStatement();
		// SQL statement to retrieve data for specific student with id
		String SQL = "SELECT * FROM STUDENT where id ='" + id + "'";
		ResultSet rs = stmt.executeQuery(SQL);
		if (rs.next()) {
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			student.setDepartment(rs.getString("department"));
			student.setNationality(rs.getString("nationality"));
			student.setMathMark(rs.getInt("mathMark"));
			student.setScienceMark(rs.getInt("scienceMark"));

		}
		view.displayStudentMarks(student.getId(), student.getName(), student.getAge(), student.getDepartment(),
				student.getNationality(), student.getMathMark(), student.getScienceMark());

	}
}