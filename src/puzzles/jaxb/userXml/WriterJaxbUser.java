package puzzles.jaxb.userXml;

import puzzles.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriterJaxbUser {
    public static void main(String[] args) throws JAXBException {
        User user = new User();

        user.setName("Vadya");
        user.setLogin("vas");
        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\user.xml");
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(user, file);
        marshaller.marshal(user, System.out);
    }
}
