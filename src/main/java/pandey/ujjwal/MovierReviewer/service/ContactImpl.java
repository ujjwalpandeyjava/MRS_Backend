package pandey.ujjwal.MovierReviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import pandey.ujjwal.MovierReviewer.pojo.ContactForm;

@Service
public class ContactImpl implements ContactService {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public ContactForm saveNewForm(ContactForm contactFormObj) {
		return mongoTemplate.save(contactFormObj);
	}

}
