import { Fragment, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import apiBase from '../../api/apiBase';
import OneVideo from './oneVideo/OneVideo';

function Title() {
	const [details, setTitledDetails] = useState(null);
	const { imdbId } = useParams();

	useEffect(() => {
		// console.log("loaded", imdbId);
		apiBase.get(`/api/v1/movies/imdbID`, {
			params: { imdbID: imdbId }
		})
			.then((res) => {
				console.log(res.data);
				if (res.status === 200) {
					setTitledDetails(res.data);
				} else alert("Please handle this status: " + res.status)
			})
			.catch((error) => {
				console.error(error.message);
			})
			.finally(() => {
				// console.log('Clear resources');
			});
		return () => {
			// console.log("Component unmounted");
		}
	}, [imdbId])

	return (
		// {/* Switch between: oneVideo - multipleVideo, on base of no of episode */}
		<Fragment>
			{details ?
				<OneVideo details={details} />
				: "Nothing found"}
		</Fragment>
	)
}

export default Title;