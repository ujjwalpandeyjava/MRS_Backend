package pandey.ujjwal.MovierReviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import pandey.ujjwal.MovierReviewer.pojo.RequestedTitle;

@Service
public class RequestImpl implements RequestService {

	@Autowired
	private MongoTemplate mongoTemplate;

	// Need to add validations
	public RequestedTitle saveNewRequest(RequestedTitle newToSave) {
		RequestedTitle save = mongoTemplate.save(newToSave);
		System.out.println(save);
		return save;
	}
}