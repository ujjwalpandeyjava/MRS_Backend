package pandey.ujjwal.MovierReviewer.service;

import pandey.ujjwal.MovierReviewer.pojo.RequestedTitle;

public interface RequestService {
	public RequestedTitle saveNewRequest(RequestedTitle newToSave);
}
