package puzzles;

import java.util.Set;

public class Game {
    private User user;
    private Set<Question> questions;
    private Set<Answer> answers;


    public Game(User user, Set<Question> questions, Set<Answer> answers) {
        this.user = user;
        this.questions = questions;
        this.answers = answers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
