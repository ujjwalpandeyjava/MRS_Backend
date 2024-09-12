import { useState } from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import packageJson from '../package.json';
import ErrorPage from './ErrorPage';
import apiBase from './api/apiBase';
import Layout from './components/Layout';
import Contact from './components/contact/Contact';
import { ResponsiveHeader } from './components/header/Header';
import Home from './components/home/Home';
import NotFound from './components/notFound/NotFound';
import Request from './components/request/Request';
import Review from './components/review/Review';
import { PagedSearch } from './components/search/Search';
import Title from './components/streamable/Title';
import Trailer from './components/trailer/Trailer';
import { urlSetup } from './utlity/commonFunctions';
// import ResponsiveFooter from './components/footer/ResponsiveFooter';

function App() {
	const navigateTo = useNavigate();
	const [movies, setMovies] = useState([]);
	const [reviews, setReviews] = useState([]);
	const [searchParm, setSearchParm] = useState('');
	const getMovieData = async (movieId) => {
		const response = await apiBase.get(`/api/v1/movies/imdbID`, {
			params: {
				imdbID: movieId
			}
		});
		const singleMovie = response.data;
		setMovies(singleMovie);
		setReviews(singleMovie.reviewIds);
	}
	const setSearchPars = (props) => {
		setSearchParm(props);
		navigateTo(urlSetup("/search"));
	}
	const [imdbID, setImdbID] = useState(null);
	const moveToSpecificMovie = async (imdbID) => {
		setImdbID(imdbID);
		navigateTo(`/${packageJson.homepage}/title/${imdbID}`);
	}
	return (
		<div className='App'>
			<ResponsiveHeader setSearchPars={setSearchPars} />
			{/* Can use Switch also, Switch will go for exact match and, Routes can look for similar also */}
			<Routes>
				<Route path={`/${packageJson.homepage}`} element={<Layout />}>
					<Route path={`/${packageJson.homepage}`} element={<Home movies={movies} setMovies={setMovies} />}></Route>
					<Route path={`/${packageJson.homepage}/`} element={<Home movies={movies} setMovies={setMovies} />}></Route>
					<Route path={`/${packageJson.homepage}/title/:imdbId`} element={<Title imdbID={imdbID} />}></Route>
					{/* <Route path={`/${packageJson.homepage}/search`} element={<Search searchParm={searchParm} setSearchPars={setSearchPars} />}></Route> */}
					<Route path={`/${packageJson.homepage}/search`} element={<PagedSearch searchParm={searchParm} setSearchPars={setSearchPars} moveToSpecificMovie={moveToSpecificMovie} />}></Route>
					<Route path={`/${packageJson.homepage}/trailer/:ytTrailerId`} element={<Trailer />}></Route>
					<Route path={`/${packageJson.homepage}/reviews/:movieId`} element={<Review getMovieData={getMovieData} movie={movies} reviews={reviews} setReviews={setReviews} />}></Route>
					<Route path={`/${packageJson.homepage}/request`} element={<Request />}></Route>
					<Route path={`/${packageJson.homepage}/contact`} element={<Contact />}></Route>
				</Route>
				<Route path={`/error`} element={<ErrorPage />}></Route>
				<Route path='*' element={<NotFound />}></Route>
			</Routes>
			{/* <ResponsiveFooter /> */}
		</div>
	);
}

export default App;