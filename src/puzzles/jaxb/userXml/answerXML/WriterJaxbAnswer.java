package puzzles.jaxb.userXml.answerXML;

import puzzles.Answer;
import puzzles.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriterJaxbAnswer {
    public static void main(String[] args) throws JAXBException {
        Answer answer = new Answer();
        answer.setAnswer("Првый ответ");
        answer.setQuestion(new Question());
        answer.setRightAnswer(true);



        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\answer.xml");
        JAXBContext context = JAXBContext.newInstance(Answer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(answer, file);
        marshaller.marshal(answer, System.out);


    }
}
