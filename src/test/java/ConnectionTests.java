import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import generated.Contact;
import generated.Contactlist;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import unmarshaller.ContactsUnmarshaller;

/**
 * @author Andreas Gyr
 */
public class ConnectionTests {
    private Contactlist contactlist;

    @Before
    public void setUp() {
	try {
	    contactlist = ContactsUnmarshaller.getContacts();
	} catch (JAXBException e) {
	    fail("Contactlist couldn't be created!");
	}
    }

    @Test
    public void testContactsCount() {
	assertEquals(2, contactlist.getContact().size());
    }

    @Test
    public void testFirstContactName() {
	Contact c = contactlist.getContact().get(0);
	assertEquals("Leonardo Da Vinci", c.getName());
	assertEquals("Rosenbergstrasse 3, 9000 St.Gallen", c.getAddress());
	assertEquals("+41 79 333 44 55", c.getPhone().get(0).getValue());
	assertEquals("mobile", c.getPhone().get(0).getType().value());
	assertEquals("+41 71 245 43 23", c.getPhone().get(1).getValue());
	assertEquals("private", c.getPhone().get(1).getType().value());
	assertEquals("l.davinci@gmail.com", c.getMail());
    }

    @Test
    public void testSecondContactName() {
	Contact c = contactlist.getContact().get(1);
	assertEquals("Mario Maler", c.getName());
	assertEquals("Heimatstrasse 5, 9000 St.Gallen", c.getAddress());
	assertEquals("+41 71 345 67 88", c.getPhone().get(0).getValue());
	assertEquals("office", c.getPhone().get(0).getType().value());
	assertEquals("+41 71 345 67 89", c.getPhone().get(1).getValue());
	assertEquals("mobile", c.getPhone().get(1).getType().value());
	assertEquals("maler@gmail.com", c.getMail());
    }

}
