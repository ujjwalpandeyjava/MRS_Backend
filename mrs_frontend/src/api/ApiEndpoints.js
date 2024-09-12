import axios from "axios";

const ax = axios.create({
	baseURL: 'http://localhost:8080',
	headers: {},
	timeout: 30000
});

window.mustForChat = {
	userId: "",
}

const apiEndPoints = {
	WORK_ONE(url = '') {
		return {
			initialAIMessage: () => `Hi!`,
			resolveQuery: (query) => ax.get(url, { params: { query: query } }),
			fetchAll: () => ax.get(url),
			fetchById: (id) => ax.get(url, { params: { id: id } }),
			create: (newRecord) => ax.post(url, { newRecord: newRecord }),
			update: (id, respBody) => ax.put(url, { updatedRecord: respBody }, { params: { id: id } }),
			delete: (id) => ax.delete(url + id),
		}
	},
	OTHER_WORK(url = '/addPath') {
		return {
			fetchAll: () => ax.get(url),
			fetchById: (id) => ax.get(url + id),
			create: (newRecord) => ax.post(url, newRecord),
			update: (id, respBody) => ax.put(url + id, respBody),
			delete: (id) => ax.delete(url + id),
		}
	}
}

// Axios Interceptors
ax.interceptors.request.use(
	(config) => {
		let defaultData = {
			userId: window.mustForChat.userId,
			userName: window.mustForChat.userName,
			orgId: window.mustForChat.orgId,
			companyName: window.mustForChat.companyName
		};
		config.params = { ...defaultData, ...config.params };
		return config;
	},
	(error) => {
		console.error("Error in interceptor: ", error.message);
		return Promise.reject(error);
	}
);
ax.interceptors.response.use(
	(response) => {
		/* console.log({
			URL_base: response.baseURL,
			URL_Full: `${response.baseURL}${response.url}`,
			response: response,
			params: response.config.params,
			data: response.data,
			status: response.status,
			statusText: response.statusText
		}); */
		// Check the status and redirect it as per the status to specific page 
		return response;
	},
	(error) => {
		console.error("Error in response interceptor ", error.message);
		return Promise.reject(error);
	}
);

export { apiEndPoints };