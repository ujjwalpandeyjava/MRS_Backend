import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import apiBase from '../../api/apiBase';

function Latest() {
	const [entries, setEntries] = useState([]);
	const navigateTo = useNavigate();

	async function searchBy() {
		try {
			console.log("Latest movies called");
			let searchReturns = await apiBase.get(`/api/v1/movies`)
			console.log(searchReturns);
			setEntries([{ id: "001", title: "ff" }, { id: "002", title: "ff2" }])
		} catch (error) {
			if (error.code === "ERR_NETWORK")
				navigateTo(`/error`);
			else
				console.log(error, error.message);
		}
	}
	useEffect(() => {
		setEntries([])
		searchBy();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [])
	return (
		<div>Latest</div>
	)
}

export default Latest