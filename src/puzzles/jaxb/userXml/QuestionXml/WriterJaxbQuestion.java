package puzzles.jaxb.userXml.QuestionXml;

import puzzles.Question;
import puzzles.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriterJaxbQuestion {
    public static void main(String[] args) throws JAXBException {
        Question question = new Question();
        question.setName("Вопрос первый");
        question.setId(1);
        question.setPathToPictureQuestion("C:/1");
        question.setPathToTextQuestion("C:/2");


        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\userXml\\QuestionXml\\question.xml");
        JAXBContext context = JAXBContext.newInstance(Question.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(question, file);
        marshaller.marshal(question, System.out);


    }
}
