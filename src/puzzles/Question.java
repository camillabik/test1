package puzzles;


import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question {
   private int id;
   private Category category;
   private String name;
   private String textQuestion;
   private String pathToPictureQuestion;

   public Question() {
   }

   public Question(int id,Category category, String name, String textQuestion) {
      this.category = category;
      this.id = id;
      this.name = name;
      this.textQuestion =textQuestion;
   }

   public Question(Category category,  String name,int id,String pathToPictureQuestion) {
      this.category = category;
      this.id = id;
      this.name = name;
      this.pathToPictureQuestion = pathToPictureQuestion;
   }
   public Category getCategory() {
      return category;
   }
   @XmlElement
   public void setCategory(Category category) {
      this.category = category;
   }

   public int getId() {
      return id;
   }
   @XmlElement
   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }
   @XmlElement
   public void setName(String name) {
      this.name = name;
   }

   public String getPathToTextQuestion() {
      return textQuestion;
   }
   @XmlElement
   public void setPathToTextQuestion(String pathToTextQuestion) {
      this.textQuestion = pathToTextQuestion;
   }

   public String getPathToPictureQuestion() {
      return pathToPictureQuestion;
   }

   public void setPathToPictureQuestion(String pathToPictureQuestion) {
      this.pathToPictureQuestion = pathToPictureQuestion;
   }
}
