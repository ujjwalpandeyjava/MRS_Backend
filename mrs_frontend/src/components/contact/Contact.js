import { useRef } from 'react';
import './Contact.css';
import reqCss from '../request/Request.module.css'
import apiBase from '../../api/apiBase';

const Contact = () => {
	const name = useRef("");
	const email = useRef("");
	const message = useRef("");

	const handleSubmit = async (e) => {
		e.preventDefault();
		await apiBase.post("/api/v1/contact/addNewForm", {
			name: name.current.value,
			email: email.current.value,
			message: message.current.value,
		})
			.then((res) => {
				console.log(res);
				if (res.status === 200) {
					alert(res.status, "Your message has been sent!");
				} else {
					alert("Got:", res.status);
				}
			})
			.catch((error) => {
				console.error(error.message);
			})
			.finally(() => {
				console.log("Clear resources");
				name.current.value = "";
				email.current.value = "";
				message.current.value = "";
			});
	};

	return (
		<>
			<h2>Contact form</h2>
			<form onSubmit={handleSubmit} className={reqCss.form}>
				<div className={reqCss.formField}>
					<label>Name:</label>
					<input type="text" ref={name} placeholder="Your name" />
				</div>
				<div className={reqCss.formField}>
					<label>Email:</label>
					<input type="email" ref={email} placeholder="To connect you back" required={true} />
				</div>
				<div className={reqCss.formField}>
					<label>Message:</label>
					<textarea ref={message} placeholder="Anything you want to say" required={true} />
				</div>
				<input type="submit" value="Send Message" />
			</form>
		</>
	);
};

export default Contact;