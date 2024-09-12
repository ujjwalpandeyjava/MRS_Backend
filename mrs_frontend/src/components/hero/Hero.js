import { faCirclePlay } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { Paper } from '@mui/material'
import { Button } from 'react-bootstrap'
import Carousel from 'react-material-ui-carousel'
import { Link, useNavigate } from 'react-router-dom'
import packageJson from '../../../package.json'
import './Hero.css'

function Hero(props) {
	const navigate = useNavigate();
	function getToReviews(movieId) {
		navigate(`/${packageJson.homepage}/reviews/${movieId}`);
	}
	return (
		<div className='movie-carousel-container'>
			{props?.movies?.length > 0 ?
				<Carousel>
					{props.movies.map(eachMovie => {
						return (
							<Paper key={eachMovie.id}>
								<div className='movie-card-container'>
									<div className='movie-card' style={{ "--bgImg": `url(${eachMovie.backdrops[0]})` }}>
										<div className='movie-detail'>
											<div className='movie-poster'>
												<img src={eachMovie.poster} alt='' />
											</div>
											<div className='movie-title'>
												<h4>{eachMovie.title}</h4>
											</div>
											<div className='movie-buttons-container'>
												<Link to={`/${packageJson.homepage}/trailer/${eachMovie.trailerLink.substring(eachMovie.trailerLink.length - 11)}`}>
													<div className='play-button-icon-container'>
														<FontAwesomeIcon className='play-button-icon' icon={faCirclePlay} />
													</div>
												</Link>
												<div className='movie-review-button-container'>
													<Button variant='info' onClick={() => getToReviews(eachMovie.imdbId)}>Reviews</Button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</Paper>
						);
					})}
				</Carousel>
				: <div className='loadingCarouselSign'>Loading latest hots...</div>}
		</div>
	)
}

export default Hero