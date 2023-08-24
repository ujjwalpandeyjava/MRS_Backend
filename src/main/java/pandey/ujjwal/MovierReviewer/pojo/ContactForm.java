package pandey.ujjwal.MovierReviewer.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document("contactForms")
public record ContactForm(@Id ObjectId id, String name, @NotBlank(message = "E-mail is required") String email,
		@NotBlank(message = "Message is required") String message) {
}
