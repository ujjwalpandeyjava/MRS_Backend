package pandey.ujjwal.MovierReviewer.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "requests")
public class RequestedTitle {
	@Id
	private ObjectId requestId;
	private String requesterName;
	@JsonProperty(required = true)
	@NotBlank(message = "Title is mandatory")
	private String requestedTitle;
	private String requestedNameType;

	RequestedTitle() {
		super();
	}

	public RequestedTitle(String requesterName, String requestedTitle, String requestedNameType) {
		super();
		this.requesterName = requesterName;
		this.requestedTitle = requestedTitle;
		this.requestedNameType = requestedNameType;
	}

	public ObjectId getRequestId() {
		return requestId;
	}

	public void setRequestId(ObjectId requestId) {
		this.requestId = requestId;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public String getRequestedTitle() {
		return requestedTitle;
	}

	public void setRequestedTitle(String requestedTitle) {
		this.requestedTitle = requestedTitle;
	}

	public String getRequestedNameType() {
		return requestedNameType;
	}

	public void setRequestedNameType(String requestedNameType) {
		this.requestedNameType = requestedNameType;
	}

	@Override
	public String toString() {
		return "RequestedTitle [requestId=" + requestId + ", requesterName=" + requesterName + ", requestedTitle="
				+ requestedTitle + ", requestedNameType=" + requestedNameType + "]";
	}

}
