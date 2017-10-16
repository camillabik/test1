package puzzles.jaxb.userXml;

import puzzles.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbUser {
    public static void main(String[] args) throws JAXBException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\user.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        User user = (User) jaxbUnmarshaller.unmarshal(file);
        System.out.println(user.getLogin());
        System.out.println(user.getName());

    }
}
