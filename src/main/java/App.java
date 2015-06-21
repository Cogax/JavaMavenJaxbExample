import generated.Contact;
import generated.Contactlist;
import generated.Phone;

import javax.xml.bind.JAXBException;

import unmarshaller.ContactsUnmarshaller;

/**
 * @author Andreas Gyr
 */
public class App {

    public static void main(String args[]) {
	try {
	    Contactlist contactlist = ContactsUnmarshaller.getContacts();
	    for (Contact contact : contactlist.getContact()) {
		System.out.println(contact.getName());
		System.out.println(contact.getAddress());
		for (Phone phone : contact.getPhone()) {
		    System.out.println(phone.getType().value() + ": "
			    + phone.getValue());
		}
		System.out.println(contact.getMail());
		System.out.println();
	    }
	} catch (JAXBException e) {
	    System.out.println("JAXB throws an error: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
