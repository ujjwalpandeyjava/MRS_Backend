import { Fragment, useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import apiBase from '../../api/apiBase';
import './Search.css'
import ResponsiveFooter from '../footer/ResponsiveFooter'


function Search({ searchParm, setSearchPars }) {
	const [entries, setEntries] = useState([]);
	const navigateTo = useNavigate();

	async function searchBy() {
		setEntries([]);
		let url = `/api/v1/movies/allMoviesContaining`;
		await apiBase.get(url, { params: searchParm })
			.then(searchRes => {
				console.log("Got: ", searchRes);
				if (searchRes.status === 200) {
					setEntries(searchRes.data)
				} else
					navigateTo(`/error`);
			})
			.catch(error => {
				console.error(error.message);
			})
			.finally(() => {
				// console.log('Clear resources');
			});
	}
	useEffect(() => {
		searchBy();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [searchParm])

	return (
		<Fragment>
			{(entries.length > 0) ?
				<Fragment>
					<h1>Search for: '{searchParm.nameContaining ? searchParm.nameContaining : "Latest"}'</h1>
					{entries.map((eachWatchable, index) => {
						return (
							<div key={eachWatchable.imdbId}>
								{/* {(index === 0) ? console.log(eachWatchable, index) : null} */}
								{index + 1}). {eachWatchable.title}
							</div>
						)
					})}
				</Fragment> : <div>No Entry found</div>}
		</Fragment>
	)
}

function PagedSearch({ searchParm, setSearchPars, moveToSpecificMovie }) {
	const [entries, setEntries] = useState([]);
	const navigateTo = useNavigate();

	async function searchBy() {
		await apiBase.get(`/api/v1/movies/searchPagedMoviesContainingName`, { params: searchParm })
			.then(searchRes => {
				// console.log("Got: ", searchRes);
				if (searchRes.status === 200) {
					if (searchParm.pageNo === 0) {
						setEntries(searchRes.data.movies)
					} else
						setEntries([...entries, ...searchRes.data.movies])
					console.log("entries: ", entries);
				} else
					navigateTo(`/error`);
			})
			.catch(error => {
				console.error(error.message);
			})
			.finally(() => {
				// console.log('Clear resources');
			});
	}
	const loadMore = () => {
		let parameters = { ...searchParm };
		parameters.pageNo++;
		setSearchPars(parameters);
	}
	useEffect(() => {
		if (!searchParm.pageNo || searchParm.pageNo < 1)
			setEntries([]);
		searchBy();

		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [searchParm])

	return (
		<Fragment>
			{(entries.length > 0) ?
				<Fragment>
					<h1>Search for: '{searchParm.nameContaining ? searchParm.nameContaining : "Latest"}'</h1>
					<hr />
					<section className='movies'>
						{entries.map((eachWatchable, index) => {
							return (
								<div key={eachWatchable.imdbId} className='eachMovie'>
									<img className='eachMovie_Img' src={eachWatchable.poster} alt={`${eachWatchable.title} poster`} onClick={() => moveToSpecificMovie(eachWatchable.imdbId)} />
									<div className='eachMovie_Details'>
										<div className='eachMovie_Details_Title'>{eachWatchable.title}</div>
										<div className='eachMovie_Details_Genres'><span className='eachMovie_Details_Genres_Title'>Genres: </span>{eachWatchable.genres.join(", ")}</div>
										<div className='eachMovie_Details_Reviews'>
											{(eachWatchable.reviewIds) ? eachWatchable.reviewIds.map((r, index) => {
												return ((index < 7) ? <div className='eachReview' key={r.id.timestamp}>{index + 1}). {r.body}</div> : null);
											}).concat((eachWatchable.reviewIds.length > 8) ? "..." : "") : ""}
										</div>
										<div className='eachMovie_Details_ReleaseDate'>{eachWatchable.releaseDate}</div>
									</div>
								</div>
							)
						})}
					</section>
					<center id='loadMoreButton'>{(entries.length % searchParm.rowInAPage === 0) ? <Button onClick={loadMore}>Load more</Button> : null}</center>
					<ResponsiveFooter />
				</Fragment> : <div>No Entry found</div>}
		</Fragment>
	)
}

export { PagedSearch, Search };
