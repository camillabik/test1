package puzzles.db.daos;

import puzzles.Answer;
import puzzles.Category;
import puzzles.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
//            for (Answer answer: getAll()) {
//                System.out.println(answer);
//            }
            getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Answer> getAll() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

      //  Connection con = ConnectionManager.getConnection();
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/puzzles.answers",
                "postgres",
                "root");
        List<Answer> answers = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet =statement.executeQuery("SELECT * FROM answers");

            while (resultSet.next()){
                Question question = new Question(resultSet.getInt("id"), (Category) resultSet.getObject("category"), resultSet.getString("name"), resultSet.getString("text"));
                Answer answer = new Answer(question, resultSet.getString("answer"), resultSet.getBoolean("is_right"));
                answer.setAnswer(resultSet.getString("answer"));
                //use another sets

                answers.add(answer);
                System.out.println(answer);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            //throw your own exception here
        }

        return answers;

    }
}
