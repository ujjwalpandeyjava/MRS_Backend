import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import apiBase from '../../api/apiBase';
import Hero from '../hero/Hero';
import './Home.css';
import ResponsiveFooter from '../footer/ResponsiveFooter'
// import ViewTransitionEg from '../rest/ViewTransitionEg';

const Home = ({ movies, setMovies }) => {
	const navigateTo = useNavigate()
	async function getMovies() {
		await setMovies([]);
		// await apiBase.get("/api/v1/movies/allMovies",{
		await apiBase.get("/api/v1/movies", {
			params: { page: 0, next: 6 }
		})
			.then(response => {
				console.log(response.data);
				// setMovies(response.data)	// All movies
				setMovies(response.data.movies)
			})
			.catch(error => {
				console.error("error: ", error);
				setMovies(error)
			});
	}
	useEffect(() => {
		getMovies();
		// comment to remove error of missing dependency with array/object type
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);
	useEffect(() => {
		if (movies.code === "ERR_NETWORK")
			navigateTo(`/pageNotFound`);
	}, [movies, navigateTo]);
	return (
		<>
			<Hero movies={movies} />
			{/* <Latest /> */}
			{/* <ViewTransitionEg /> */}
			More features/element coming soon
			<ResponsiveFooter />
		</>
	)
}

export default Home;