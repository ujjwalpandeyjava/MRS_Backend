import { Fragment, useRef } from 'react'
import apiBase from '../../api/apiBase'
import reqCss from './Request.module.css'

function Request() {
	const requesterNameRef = useRef("Not-Disclosed")
	const requestedTitleRef = useRef("")
	const requestedNameTypeRef = useRef("")
	const types = [
		"Movie",
		"Web-series",
		"Series",
		"Adult",
	];

	const handleRequestSubmit = (event) => {
		event.preventDefault();
		apiBase.post("/api/v1/request", {
			requestedTitle: requestedTitleRef.current.value,
			requesterName: requesterNameRef.current.value,
			requestedNameType: requestedNameTypeRef.current.value,
		})
			.then(apiResp => {
				console.log(apiResp);
				if (apiResp.status === 200) {
					let data = apiResp.data;
					alert("Request sent successfully!");
					console.log(data);
				} else
					console.error("status: " + apiResp.status);
			})
			.catch((error) => {
				console.error(error.message);
			})
			.finally(() => {
				requesterNameRef.current.value = '';
				requestedTitleRef.current.value = '';
				requestedNameTypeRef.current.value = '';
			});
	}

	return (
		<Fragment>
			<h2>Request Page</h2>
			<form onSubmit={handleRequestSubmit} className={reqCss.form}>
				<div className={reqCss.formField}>
					<label htmlFor="requesterName">Your name:</label>
					<input name='requesterName' ref={requesterNameRef} type="text" placeholder='Name' />
				</div>
				<div className={reqCss.formField}>
					<label htmlFor="requestedNameType">Type:</label>
					<input type="text" ref={requestedNameTypeRef} required name="requestedNameType" list="requestedNameTypeId" placeholder='What it is?' />
					<datalist id="requestedNameTypeId">{types.map((eachType) => (<option key={eachType} value={eachType}>{eachType}</option>))}</datalist>
				</div>
				<div className={reqCss.formField}>
					<label htmlFor="requestedTitle">Title:</label>
					<input name='requestedTitle' ref={requestedTitleRef} required type="text" placeholder='Movie/Series name' />
				</div>
				<input type="submit" value="Submit Request" />
			</form>
		</Fragment>
	);
}

export default Request;