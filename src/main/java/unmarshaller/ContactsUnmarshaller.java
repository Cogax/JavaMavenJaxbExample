package unmarshaller;

import generated.Contactlist;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author Andreas Gyr
 */
public class ContactsUnmarshaller {

    public static Contactlist getContacts() throws JAXBException {
	File file = new File("src/main/resources/contactlist.xml");
	JAXBContext jaxbContext = JAXBContext.newInstance(Contactlist.class);
	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	Contactlist contactlist = (Contactlist) jaxbUnmarshaller
		.unmarshal(file);
	return contactlist;
    }
}
