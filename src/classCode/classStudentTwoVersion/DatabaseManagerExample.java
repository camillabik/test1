package classCode.classStudentTwoVersion;


import java.sql.*;

public class DatabaseManagerExample {
    public static void main(String[] args)
            throws ClassNotFoundException {
        showStudents();
    }

    public static void showStudents()
            throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection connection;
        try {
            connection =
                    DriverManager
                            .getConnection(
                                    "jdbc:postgresql://localhost:5432/Students",
                                    "postgres",
                                    "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                Student student = new Student(
                        (short) resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("birth_date").getTime());
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}