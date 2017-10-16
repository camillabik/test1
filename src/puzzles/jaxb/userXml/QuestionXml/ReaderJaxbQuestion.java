package puzzles.jaxb.userXml.QuestionXml;

import puzzles.Question;
import puzzles.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbQuestion {
    public static void main(String[] args) throws JAXBException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\userXml\\QuestionXml\\question.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Question question = (Question) jaxbUnmarshaller.unmarshal(file);
        System.out.println(question.getName());
        System.out.println(question.getId());
        System.out.println(question.getPathToPictureQuestion());
        System.out.println(question.getPathToTextQuestion());
    }
}
