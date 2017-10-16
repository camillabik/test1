package puzzles.db.daos;

import puzzles.Answer;
import puzzles.Category;
import puzzles.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
//    public static List<Question> getAll() throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//
//        //  Connection con = ConnectionManager.getConnection();
//        Connection con = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5432/puzzles.answers",
//                "postgres",
//                "root");
//        List<Question> questions = new ArrayList<>();
//        try (Statement statement = con.createStatement()) {
//            ResultSet resultSet =statement.executeQuery("SELECT * FROM questions;");
//
//            while (resultSet.next()){
//                Question question = new Question(resultSet.getInt("id"), (Category) resultSet.getObject("category"), resultSet.getString("name"), resultSet.getString("text"));
//                Answer answer = new Answer(question, resultSet.getString("answer"), resultSet.getBoolean("is_right"));
//              //  answer.setQuestion((Question) resultSet("question"));
//                //use another sets
//
//                questions.add(question);
//                System.out.println(question);
//            }
//        } catch (SQLException ex){
//            ex.printStackTrace();
//            //throw your own exception here
//        }
//
//        return questions;
//
//    }
//}

}
