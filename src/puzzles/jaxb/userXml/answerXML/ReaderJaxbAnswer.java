package puzzles.jaxb.userXml.answerXML;

import puzzles.Answer;
import puzzles.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbAnswer {
    public static void main(String[] args) throws JAXBException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\answer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Answer.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Answer answer = (Answer) jaxbUnmarshaller.unmarshal(file);
        System.out.println(answer.getAnswer());
        System.out.println(answer.getQuestion());
        System.out.println(answer.isRightAnswer());

    }
}
