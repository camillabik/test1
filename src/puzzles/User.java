package puzzles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    // id
    private String name;
    private String login;
    //pass
   // private String category;

    public User(){}
    public User(String name, String login) {
        this.name = name;
        this.login = login;
      //  this.category = category;
    }
    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }
    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

//    public String getCategory() {
//        return category;
//    }
//    @XmlElement
//    public void setCategory(String category) {
//        this.category = category;
//    }
}
