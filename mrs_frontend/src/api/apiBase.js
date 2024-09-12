import axios from "axios";

export default axios.create({
	baseURL: 'http://localhost:8881',
	// baseURL: 'http://localhost:8080/MovierReviewer',	// First run server from bin
	// baseURL: 'http://localhost:8080/MovierReviewer',
	headers: {
		"ngrok-skip-browser-warning": "true",
		"Access-Control-Allow-Origin": "*",
		"Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
	},
	data: {
		name: "John Doe",
		email: "johndoe@example.com",
	}
});